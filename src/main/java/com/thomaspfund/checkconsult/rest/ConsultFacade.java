package com.thomaspfund.checkconsult.rest;

import java.net.UnknownHostException;
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
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.thomaspfund.checkconsult.dao.ConsultDAO;
import com.thomaspfund.checkconsult.entity.Consult;

@Path("consult")
public class ConsultFacade {

	  @Context
	  private HttpServletResponse anotherServlerResponse;
	  
	private ConsultDAO dao = new ConsultDAO();
	
	@OPTIONS
	@PermitAll
	public Response getOptions() {
		addHeaders();
		return Response.ok()
                .header("Access-Control-Allow-Methods", "DELETE PUT GET POST")
                .header("Access-Control-Allow-Credentials", "false")
                .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
                //.header("Access-Control-Allow-Origin", "*")
                .build();
	}
	
	@GET
	@Produces({"application/json"})
	public List<Consult> findAll() throws UnknownHostException {
		addHeaders();
		return dao.findAll();
	}
	
	@GET
	@Path("{id}")
	@Produces({"application/json"})
	public Consult find(@PathParam("id") ObjectId id) throws UnknownHostException {
		addHeaders();
		return dao.find(id);
	}
	
	@POST
	@Produces({"application/json"})
	public Consult create(Consult consult) throws UnknownHostException {
		addHeaders();
		return dao.insert(consult);
	}
	
	@PUT
	@Produces({"application/json"})
	public void update(Consult consult) throws UnknownHostException {
		addHeaders();
		dao.update(consult);
	}

	@DELETE
	@Produces({"application/json"})
	public void delete(Consult consult) throws UnknownHostException {
		addHeaders();
		dao.delete(consult);
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
