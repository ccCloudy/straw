package cyl.straw.ap.iuser.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * redis操作工具类
 */
@Component
public class RedisUtils {
    @Autowired
    RedisTemplate<String , Serializable> redisTemplate;

    /**
     * 删除Redis中的某个数据
     * @param key 被删除的数据的key
     * @return 删除操作是否成功
     */
    public Boolean delete(String key){
        return redisTemplate.delete(key);
    }

    public Long rightPush(String key, Serializable value){
        ListOperations<String , Serializable> ops = redisTemplate.opsForList();
        return ops.rightPush(key, value);
    }

    /**
     * 获取Redis中某List集合
     * @param key 需要获取的数据在redis中的key
     * @return List集合
     */
    public List<Serializable> listRange(String key){
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        long start = 0;
        long end = ops.size(key);
        return ops.range(key, start, end);
    }

    /**
     * 获取Redis中某List集合中的数据片段
     * @param key 需要获取的数据在Redis中的Key
     * @param start 获取的数据片段在List集合中的起始位置
     * @param end 获取的数据片段在List集合中的结束位置
     * @return List集合中的数据片段
     */
    public List<Serializable> listRange(String key, long start, long end){
        ListOperations<String , Serializable> ops = redisTemplate.opsForList();
        return ops.range(key, start, end);
    }
}
