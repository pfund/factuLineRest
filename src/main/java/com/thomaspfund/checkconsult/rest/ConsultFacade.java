package com.thomaspfund.checkconsult.rest;

import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.bson.types.ObjectId;

import com.thomaspfund.checkconsult.dao.ConsultDAO;
import com.thomaspfund.checkconsult.entity.Consult;

@Path("consult")
public class ConsultFacade {

	private ConsultDAO dao = new ConsultDAO();
	
	@GET
	@Produces({"application/json"})
	public List<Consult> findAll() throws UnknownHostException {
		return dao.findAll();
	}
	
	@GET
	@Path("{id}")
	@Produces({"application/json"})
	public Consult find(@PathParam("id") ObjectId id) throws UnknownHostException {
		return dao.find(id);
	}
	
	@POST
	@Produces({"application/json"})
	public Consult create(Consult consult) throws UnknownHostException {
		return dao.insert(consult);
	}
	
	@PUT
	@Produces({"application/json"})
	public void update(Consult consult) throws UnknownHostException {
		dao.update(consult);
	}

	@DELETE
	@Produces({"application/json"})
	public void delete(Consult consult) throws UnknownHostException {
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

}
