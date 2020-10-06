package cyl.straw.ap.iuser.schedule;

import cyl.straw.ap.iuser.Util.RedisUtils;
import cyl.straw.ap.iuser.service.ITagService;
import cyl.straw.commons.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
public class RedisSchedule {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    ITagService tagService;
    @Scheduled(fixedRate = 10*3000,initialDelay = 1000)

    public void updateRedisTags(){
        log.debug("[{}]准备更新Redis服务器中的问题标签缓存",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        //在redis中“标签列表”数据的Key
        String tagListKey = "tags";
        //清空Redis中的标签列表缓存数据
        redisUtils.delete(tagListKey);
        //从数据库中读取新的标签列表
        List<Tag> tags = tagService.list();
        for (Tag tag:tags){
            redisUtils.rightPush(tagListKey,tag);
        }
        log.debug("[{}]更新Redis服务器中的问题标签缓存",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
