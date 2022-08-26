package com.example.rest;

import com.example.service.AliveInfoService;
import com.example.service.ExampleService;
import com.example.service.IbmMqProducerResource;
import com.example.service.SimpleScheduler;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/members/{msg}")
@RequestScoped
public class MemberResourceRESTService {

   @EJB
   IbmMqProducerResource producerResource;

//   @GET
//   public String listAllMembers(@PathParam("msg") String message) throws JMSException {
//      return "JNDI CALL : " + exampleService.getInfo(message);
//   }


   @GET
   public String listAllMembers(@PathParam("msg") String message) throws JMSException {
      return "JNDI CALL : " + producerResource.publishMessage(message);
   }
}