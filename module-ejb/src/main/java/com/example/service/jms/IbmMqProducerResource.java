package com.example.service.jms;

import com.example.service.utils.LoggerUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.ws.rs.PathParam;

@Stateless(name = "ibmMqProducer")
public class IbmMqProducerResource {

    private static final Logger log = LoggerUtils.getLogger(MessageListener.class);
    @Resource(mappedName = "java:jboss/IbmMqConnectionFactory")
    ConnectionFactory cf;

    @Resource(mappedName = "java:/TestQueue")
    Queue queue;

    public String publishMessage(@PathParam("msg") String msg) throws JMSException {
        try (JMSContext context = cf.createContext()) {
            TextMessage m = context.createTextMessage(msg);
            context.createProducer()
                    .send(queue, m);
            log.info(">> Connection factory info: " + context.getMetaData().getJMSProviderName());
            log.info(">> Jms version: " + context.getMetaData().getJMSVersion());
            log.info(">> Sent message: " + m);
            return m.getJMSMessageID();
        }
    }

}
