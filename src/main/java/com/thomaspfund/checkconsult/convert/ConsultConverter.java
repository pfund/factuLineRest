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
		consult.setConsultationPrice((Double) object.get("consultationPrice"));
		consult.setMaterialPrice((Double) object.get("materialPrice"));
		consult.setMedicamentPrice((Double) object.get("medicamentPrice"));
		consult.setRebate((Double) object.get("rebate"));
		consult.setComment((String) object.get("comment"));
		
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
		object.put("consultationPrice", consult.getConsultationPrice());
		object.put("materialPrice", consult.getMaterialPrice());
		object.put("medicamentPrice", consult.getMedicamentPrice());
		object.put("rebate", consult.getRebate());
		object.put("comment", consult.getComment());

		return object;
	}
}
