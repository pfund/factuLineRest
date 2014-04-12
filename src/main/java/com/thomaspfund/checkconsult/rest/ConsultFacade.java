package com.thomaspfund.checkconsult.rest;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.thomaspfund.checkconsult.dao.ConsultDAO;
import com.thomaspfund.checkconsult.entity.Consult;

@Path("consult")
public class ConsultFacade {

	  @Context
	  private HttpServletResponse anotherServlerResponse;
	  
	private ConsultDAO dao = new ConsultDAO();
	
	@OPTIONS
	@PermitAll
	public void getOptions() {
		anotherServlerResponse.addHeader("Access-Control-Allow-Origin", "*");
		anotherServlerResponse.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
		anotherServlerResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

//		addHeaders();
//		return Response.ok()
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS")
//                .header("Access-Control-Allow-Credentials", "false")
//                .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
//                .build();
	}
	@OPTIONS
	@Path("{id}")
	@PermitAll
	public void getOptionsForConsult() {
		anotherServlerResponse.addHeader("Access-Control-Allow-Origin", "*");
		anotherServlerResponse.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
		anotherServlerResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

//		addHeaders();
//		return Response.ok()
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS")
//                .header("Access-Control-Allow-Credentials", "false")
//                .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
//                .build();
	}

	
	@GET
	@Produces({"application/json"})
	public List<Consult> findAll() throws UnknownHostException {
		addHeaders();
		return dao.findAll();
	}
	
	@GET @Path("{id}")
	@Produces({"application/json"})
	public Consult find(@PathParam("id") String id) throws UnknownHostException {
		addHeaders();
		return dao.find(id);
	}
	
	@GET @Path("getByDateConsult/{dateConsult}")
	@Produces({"application/json"})
	public List<Consult> getByDateConsult(@PathParam("dateConsult") Date dateConsult) throws UnknownHostException {
		addHeaders();
		return dao.findByDateConsult(dateConsult);
	}

	@POST
	@Produces({"application/json"})
	public Consult create(Consult consult) throws UnknownHostException {
		addHeaders();
		return dao.insert(consult);
	}
	
	@PUT @Path("{id}")
	@Produces({"application/json"})
	public Consult update(Consult consult) throws UnknownHostException {
		addHeaders();
		return dao.update(consult);
	}

	@DELETE
	@Path("{id}")
	@Produces({"application/json"})
	public void delete(@PathParam("id") String id) throws UnknownHostException {
		addHeaders();
		dao.delete(id);
	}
	

//	@GET
//	@Produces({"application/json"})
//	public String getAll() {
//		Consult consult = new Consult();
//		consult.setDateConsult(new Date());
//		consult.setMontant(1234.5d);
//		consult.setRabais(0d);
//		
//		consultDao.insert(consult);
//		
//		return "hi all...";
//	}

	private void addHeaders() {
		anotherServlerResponse.addHeader("Access-Control-Allow-Origin", "*");
	}
}
