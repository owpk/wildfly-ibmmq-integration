package com.example.rest;

import com.example.service.AliveInfoService;
import com.example.service.jms.IbmMqProducerResource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RequestScoped
public class MemberResourceRESTService {

   @EJB
   IbmMqProducerResource producerResource;
   @EJB
   AliveInfoService aliveInfoService;

   @GET
   @Path("/alive/{msg}")
   public String checkIfAlive(@PathParam("msg") String message) {
      return "JNDI CALL : " + aliveInfoService.getInfo(message);
   }

   @GET
   @Path("/jms/send/{msg}")
   public String listAllMembers(@PathParam("msg") String message) throws JMSException {
      return "JNDI CALL : " + producerResource.publishMessage(message);
   }
}