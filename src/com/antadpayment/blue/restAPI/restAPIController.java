package com.antadpayment.blue.restAPI;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.antadpayment.blue.Spring.blueDao;
import com.antadpayment.blue.beans.userData;

@Path("/blue")
public class restAPIController {
	userData newUsrLog;
	Logger logInf = Logger.getLogger(restAPIController.class.getName());
	@GET
	public Response getMsg() {
		String output = "{'mesaage':'Welcome to Blue, a payment system by Francisco Otero'}";
		return Response.status(200).entity(output).build();

	}
	@GET
	@Path("/Login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logIn(@QueryParam("user") String user) {		
		
		if(user.equals("")) {
			return Response.status(Status.NOT_ACCEPTABLE)
					.entity("{'message':'not ok, user was not provided'}" ).build();
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
		
		blueDao userDao = (blueDao) context.getBean("blueDao");
		newUsrLog = userDao.findUser(user);
		
		
		
		
		
		
		
		//newUsrLog = new userData(user);
		//here we return that filled object as JSON
		if(newUsrLog != null) {
			logInf.info("here the new user : " + newUsrLog.toString());
			//return Response.status(Response.Status.OK).entity(newUsrLog).build();	
			return Response.ok(newUsrLog.toString()).build();
		}else {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(newUsrLog).build();
		}
		
	}


}
