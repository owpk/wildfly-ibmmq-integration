// package com.example.service.jms;
//
// import com.example.service.utils.LoggerUtils;
// import com.ibm.mq.MQException;
// import com.ibm.mq.MQQueue;
// import com.ibm.mq.MQQueueManager;
// import com.ibm.mq.MQTopic;
// import com.ibm.mq.constants.MQConstants;
// import org.apache.logging.log4j.Logger;
//
// import javax.annotation.Resource;
// import javax.ejb.Stateless;
// import javax.jms.*;
// import javax.ws.rs.PathParam;
//
// @Stateless(name = "ibmMqProducer")
// public class IbmMqProducerResource {
//
//     private static final Logger log = LoggerUtils.getLogger(MessageListener.class);
//     @Resource(mappedName = "java:jboss/jms/agent/connectionFactory")
//     ConnectionFactory cf;
//
//     @Resource(mappedName = "java:/jms/system/request")
//     Queue queue;
//
//     public String publishMessage(@PathParam("msg") String msg) throws JMSException {
//         try (JMSContext context = cf.createContext()) {
//             TextMessage m = context.createTextMessage(msg);
//             context.createProducer()
//                     .send(queue, m);
//             log.info(">> Connection factory info: " + context.getMetaData().getJMSProviderName());
//             log.info(">> Jms version: " + context.getMetaData().getJMSVersion());
//             log.info(">> Sent message: " + m);
//             return m.getJMSMessageID();
//         }
//     }
//
//     public void subscribeToTopic(boolean unsubscribe, String topicName, String queueManagerName) {
//         MQQueueManager queueManager;
//         MQQueue mqQueue;
//         MQTopic topic;
//         try {
//             queueManager = new MQQueueManager(queueManagerName);
//             mqQueue = queueManager.accessQueue(queue.getQueueName(), MQConstants.MQOO_INPUT_AS_Q_DEF,
//                     null, null, null);
//             topic = queueManager.accessTopic(mqQueue, topicName, null,
//                     MQConstants.MQSO_CREATE | MQConstants.MQSO_ALTER |
//                             MQConstants.MQSO_DURABLE | MQConstants.MQSO_ANY_USERID,
//                     null, "TOPIC-SUBSCRIPTION");
//         } catch (MQException | JMSException e) {
//             throw new RuntimeException(e);
//         }
//     }
// }
