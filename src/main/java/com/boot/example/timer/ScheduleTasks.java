package com.boot.example.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiaohu on 2018/3/26.
 */
@Component
public class ScheduleTasks {

    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0 2 0 * * ?")
    public void scheduleTest(){
        System.out.println(sf.format(new Date()));
    }
}
