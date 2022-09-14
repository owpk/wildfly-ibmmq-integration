package com.example.service;

// import com.example.service.jms.IbmMqProducerResource;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.jms.JMSException;
import java.util.Date;

/**
 * @author Vorobyev Vyacheslav
 */
@Singleton
@Startup
public class SimpleScheduler {

//    @EJB
    // IbmMqProducerResource producerResource;

//    @Resource
//    private TimerService timerService;
//
//    @PostConstruct
//    public void start() {
//        System.out.println("START SCHEDULING");
//        TimerConfig timerConfig = new TimerConfig("TIMER", false);
//        Timer timer = timerService.createIntervalTimer(0, 10000, timerConfig);
//        System.out.println(timer);
//    }

//    @Timeout
//    public void handleTimerEvent(Timer timer) throws JMSException {
//        System.out.println("TIMER INVOKED");
//        producerResource.publishMessage("JMS MESSAGE: " + new Date());
//    }

}
