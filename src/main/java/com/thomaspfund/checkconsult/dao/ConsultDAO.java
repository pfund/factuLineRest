package com.thomaspfund.checkconsult.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.thomaspfund.checkconsult.convert.ConsultConverter;
import com.thomaspfund.checkconsult.entity.Consult;

public class ConsultDAO {

	private MongoClient getClient() throws UnknownHostException {
		return new MongoClient();
	}

	private DBCollection getCollection(MongoClient mongoClient)
			throws UnknownHostException {

		DB db = mongoClient.getDB("factuLine");

		return db.getCollection("consult");

	}

	public Consult find(String id) throws UnknownHostException {
		Consult consult = null;

		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);

			DBObject mongoConsult = collection.findOne(new BasicDBObject("_id",
					new ObjectId(id)));
			if (mongoConsult != null) {
				consult = ConsultConverter.getConsultFromMongo(mongoConsult);
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}

		return consult;
	}

	public Consult insert(Consult consult) throws UnknownHostException {
		DBObject mongoConsult = ConsultConverter
				.getMongoObjectFromConsult(consult);

		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);

			collection.insert(mongoConsult);
		} finally {
			if (client != null) {
				client.close();
			}
		}

		return ConsultConverter.getConsultFromMongo(mongoConsult);
	}

	public void update(Consult consult) throws UnknownHostException {
		DBObject object = ConsultConverter.getMongoObjectFromConsult(consult);

		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);
			collection
					.update(new BasicDBObject("_id", consult.getId()), object);
		} finally {
			if (client != null) {
				client.close();
			}
		}
	}

	public void delete(String id) throws UnknownHostException {
		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);
			DBObject mongoConsult = collection.findOne(new BasicDBObject("_id",
					new ObjectId(id)));
			collection.remove(mongoConsult);
		} finally {
			if (client != null) {
				client.close();
			}
		}
	}

	public List<Consult> findAll() throws UnknownHostException {
		List<Consult> returnList = new ArrayList<>();
		
		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);
			DBCursor cursor = collection.find();
			
			while (cursor.hasNext()) {
				returnList.add(ConsultConverter.getConsultFromMongo(cursor.next()));
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}
		
		return returnList;
	}

	public List<Consult> findByDateConsult(Date dateConsult) throws UnknownHostException {
		List<Consult> returnList = new ArrayList<>();

		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);

			DBCursor cursor = collection.find(new BasicDBObject("dateConsult", dateConsult)).sort(new BasicDBObject("order", 1));
			
			while (cursor.hasNext()) {
				returnList.add(ConsultConverter.getConsultFromMongo(cursor.next()));
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}

		return returnList;
	}

}
