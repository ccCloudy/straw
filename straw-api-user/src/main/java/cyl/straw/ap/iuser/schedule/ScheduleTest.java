package cyl.straw.ap.iuser.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
@Deprecated
@Slf4j
public class ScheduleTest {
    private int i = 0;
    @Scheduled(fixedRate = 3*1000 )
    public void task(){
        log.debug("测试任务：{}",i);
    }
}
