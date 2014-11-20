package com.thomaspfund.checkconsult.convert;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.thomaspfund.checkconsult.entity.Operation;

public class OperationConverter implements Converter<Operation> {

	public String getCollectionName() {
		return "operation";
	}
	
	@Override
	public Operation getFromMongo(DBObject object) {
		Operation operation = new Operation();
		
		operation.setId(((ObjectId)object.get("_id")).toStringMongod());
		operation.setDateOperation((Date) object.get("dateOperation"));
		operation.setFirstName((String) object.get("firstName"));
		operation.setLastName((String) object.get("lastName"));
		operation.setOperationHospital((String) object.get("operationHospital"));
		operation.setAmount(getDouble(object.get("amount")));
		operation.setAssistantOne((String) object.get("assistantOne"));
		operation.setAssistantOneAmount(getDouble(object.get("assistantOneAmount")));
		operation.setAssistantTwo((String) object.get("assistantTwo"));
		operation.setAssistantTwoAmount(getDouble(object.get("assistantTwoAmount")));
		operation.setPaymentRecieved((Boolean) object.get("paymentRecieved"));
		operation.setAssistantsPaid((Boolean) object.get("assistantsPaid"));
		
		return operation;
	}
	
	/**
	 * Converts a mongodb object into a double (if possible). Sometimes we get Integers, so we convert them into doubles.
	 * @param o the mongodb object that we want to convert into a double
	 * @return the double value of the given o object
	 */
	private static Double getDouble(Object o) {
		if (o instanceof Integer) {
			return ((Integer) o).doubleValue();
		} else {
			return (Double) o;
		}
	}
	
	public DBObject getMongoObject(Operation operation) {
		DBObject object = new BasicDBObject();
		
		if (operation.getId() != null) {
			object.put("_id", new ObjectId(operation.getId()));
		}
		object.put("dateOperation", operation.getDateOperation());
		object.put("firstName", operation.getFirstName());
		object.put("lastName", operation.getLastName());
		object.put("operationHospital", operation.getOperationHospital());
		object.put("amount", operation.getAmount());
		object.put("assistantOne", operation.getAssistantOne());
		object.put("assistantOneAmount", operation.getAssistantOneAmount());
		object.put("assistantTwo", operation.getAssistantTwo());
		object.put("assistantTwoAmount", operation.getAssistantTwoAmount());
		object.put("paymentRecieved", operation.getPaymentRecieved());
		object.put("assistantsPaid", operation.getAssistantsPaid());

		return object;
	}

}
