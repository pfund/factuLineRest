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
		consult.setDateConsult((Date) object.get("dateConsult"));
		consult.setMontant((Double) object.get("montant"));
		consult.setRabais((Double) object.get("rabais"));
		
		return consult;
	}
	
	public static DBObject getMongoObjectFromConsult(Consult consult) {
		DBObject object = new BasicDBObject();
		
		if (consult.getId() != null) {
			object.put("_id", new ObjectId(consult.getId()));
		}
		object.put("montant", consult.getMontant());
		object.put("dateConsult", consult.getDateConsult());
		object.put("rabais", consult.getRabais());

		return object;
	}
}
