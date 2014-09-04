package com.thomaspfund.checkconsult.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public abstract class AbstractDAO {
	private final static String OPENSHIFT_MONGODB_DB_URL = System.getProperty("OPENSHIFT_MONGODB_DB_URL");

    MongoClient getClient() throws UnknownHostException {
    	MongoClientURI uri = new MongoClientURI(OPENSHIFT_MONGODB_DB_URL);
//    	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/");
		return new MongoClient(uri);
	}

    DBCollection getCollection(MongoClient mongoClient)
			throws UnknownHostException {

		DB db = mongoClient.getDB("wildfly8");
//		DB db = mongoClient.getDB("factuLine");
		return db.getCollection("consult");

	}

}
