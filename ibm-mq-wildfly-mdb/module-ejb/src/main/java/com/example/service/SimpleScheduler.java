package com.example.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

/**
 * @author Vorobyev Vyacheslav
 */
@Singleton
@Startup
public class SimpleScheduler {

//    @Resource
    private TimerService timerService;

//    @PostConstruct
    public void start() {
        System.out.println("START SCHEDULING");
        TimerConfig timerConfig = new TimerConfig("TIMER", false);
        Timer timer = timerService.createIntervalTimer(0, 10, timerConfig);
        System.out.println(timer);
    }

//    @Timeout
    public void handleTimerEvent(Timer timer) {
        System.out.println("TIMER INVOKED");
    }

}
