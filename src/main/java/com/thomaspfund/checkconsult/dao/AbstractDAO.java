package com.thomaspfund.checkconsult.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public abstract class AbstractDAO {

    MongoClient getClient() throws UnknownHostException {
		return new MongoClient();
	}

    DBCollection getCollection(MongoClient mongoClient)
			throws UnknownHostException {

		DB db = mongoClient.getDB("factuLine");

		return db.getCollection("consult");

	}

}
