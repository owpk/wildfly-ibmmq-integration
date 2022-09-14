package com.example.service.jms;

import com.example.service.utils.LoggerUtils;
import org.apache.logging.log4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

// @MessageDriven(activationConfig = {
//         @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
//         @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/TestQueue"),
//         @ActivationConfigProperty(propertyName = "useJNDI", propertyValue = "true"),
//         @ActivationConfigProperty(propertyName = "connectionFactoryLookup", propertyValue = "java:jboss/IbmMqConnectionFactory"),
//         @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
// public class IbmMqConsumerMDB implements MessageListener {
//
//     private static final Logger log = LoggerUtils.getLogger(MessageListener.class);
//
//     @Override
//     public void onMessage(Message m) {
//         log.info(">> Received message: " + m);
//     }
// }
