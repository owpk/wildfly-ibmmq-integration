package com.example.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Stateless(name = "ibmMqProducer")
public class IbmMqProducerResource {

    @Resource(mappedName = "java:jboss/IbmMqConnectionFactory")
    ConnectionFactory cf;

    @Resource(mappedName = "java:jboss/TestQueue")
    Queue queue;

    public String publishMessage(@PathParam("msg") String msg) throws JMSException {
        try (JMSContext context = cf.createContext()) {
            TextMessage m = context.createTextMessage(msg);
            context.createProducer()
                    .send(queue, m);
            System.out.println(">> Connection factory info: " + context.getMetaData().getJMSProviderName());
            System.out.println(">> " + context.getMetaData().getJMSVersion());
            System.out.println(">> Sent message: " + m);
            return m.getJMSMessageID();
        }
    }

}
