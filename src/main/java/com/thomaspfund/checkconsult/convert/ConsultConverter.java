package com.thomaspfund.checkconsult.convert;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.thomaspfund.checkconsult.entity.Consult;

public class ConsultConverter {

	public static Consult getConsultFromMongo(DBObject object) {
		Consult consult = new Consult();
		
		consult.setId(((ObjectId)object.get("_id")).toStringMongod());
		consult.setOrder((Integer) object.get("order"));
		consult.setDateConsult((Date) object.get("dateConsult"));
		consult.setFirstName((String) object.get("firstName"));
		consult.setLastName((String) object.get("lastName"));
		consult.setBirthDate((Date) object.get("birthDate"));
		consult.setFullPrice((Double) object.get("fullPrice"));
		consult.setRebate((Double) object.get("rebate"));
		
		return consult;
	}
	
	public static DBObject getMongoObjectFromConsult(Consult consult) {
		DBObject object = new BasicDBObject();
		
		if (consult.getId() != null) {
			object.put("_id", new ObjectId(consult.getId()));
		}
		object.put("order",  consult.getOrder());
		object.put("dateConsult", consult.getDateConsult());
		object.put("firstName", consult.getFirstName());
		object.put("lastName", consult.getLastName());
		object.put("birthDate", consult.getBirthDate());
		object.put("fullPrice", consult.getFullPrice());
		object.put("rebate", consult.getRebate());

		return object;
	}
}
