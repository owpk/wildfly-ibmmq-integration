package com.example.rest;

import com.example.service.AliveInfoService;
import com.example.service.ClusterTest;
//import com.example.service.jms.IbmMqProducerResource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RequestScoped
public class MemberResourceRESTService {

//   @EJB
//   IbmMqProducerResource producerResource;
   @EJB
   AliveInfoService aliveInfoService;

   @EJB
   ClusterTest clusterTest;

   @GET
   @Path("/alive/{msg}")
   public String checkIfAlive(@PathParam("msg") String message) {
      return "JNDI CALL : " + aliveInfoService.getInfo(message);
   }

//   @GET
//   @Path("/jms/send/{msg}")
//   public String sendJMSMessage(@PathParam("msg") String message) throws JMSException {
//      return "JNDI CALL : " + producerResource.publishMessage(message);
//   }

//   @GET
//   @Path("/jms/topic/subscribe")
//   public String subscribeToJMSTopic() {
//      producerResource.subscribeToTopic(false, "testTopic", "QM1");
//      return "OK";
//   }

   @GET
   @Path("/clusterinfo")
   public String serverName() {
      return clusterTest.getServerName();
   }
}