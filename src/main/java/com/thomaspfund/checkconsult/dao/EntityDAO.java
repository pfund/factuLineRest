package com.thomaspfund.checkconsult.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.thomaspfund.checkconsult.convert.Converter;
import com.thomaspfund.checkconsult.entity.MongoEntity;

public class EntityDAO<T extends MongoEntity> extends AbstractDAO {
	
	private Converter<T> converter;
	
	public EntityDAO(Converter<T> converter) {
		this.converter = converter;
	}
	
    private DBCollection getCollection(MongoClient mongoClient)
			throws UnknownHostException {
    	return super.getCollection(mongoClient, converter.getCollectionName());
    }


	public T find(String id) throws UnknownHostException {
		T consult = null;

		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);

			DBObject mongoConsult = collection.findOne(new BasicDBObject("_id",
					new ObjectId(id)));
			if (mongoConsult != null) {
				consult = converter.getFromMongo(mongoConsult);
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}

		return consult;
	}

	public T insert(T consult) throws UnknownHostException {
		DBObject mongoConsult = converter
				.getMongoObject(consult);

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

		return converter.getFromMongo(mongoConsult);
	}

	public T update(T consult) throws UnknownHostException {
		DBObject object = converter.getMongoObject(consult);

		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);
			collection
					.update(new BasicDBObject("_id", new ObjectId(consult.getId())), object);
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return converter.getFromMongo(object);
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

	public List<T> findAll() throws UnknownHostException {
		List<T> returnList = new ArrayList<>();
		
		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);
			DBCursor cursor = collection.find();
			
			while (cursor.hasNext()) {
				returnList.add(converter.getFromMongo(cursor.next()));
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}
		
		return returnList;
	}

	public List<T> findByDateConsult(Date dateConsult) throws UnknownHostException {
		return findByDate(dateConsult, "dateConsult");
	}
	
	public List<T> findByDateOperation(Date dateOperation) throws UnknownHostException {
		return findByDate(dateOperation, "dateOperation");
	}
	
	public List<T> findByDate(Date dateConsult, String dateField) throws UnknownHostException {
		List<T> returnList = new ArrayList<>();

		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);

			DBCursor cursor = collection.find(new BasicDBObject(dateField, dateConsult)).sort(new BasicDBObject("order", 1));
			
			while (cursor.hasNext()) {
				returnList.add(converter.getFromMongo(cursor.next()));
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}

		return returnList;
	}
	
}
