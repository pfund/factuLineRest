package com.thomaspfund.checkconsult.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public abstract class AbstractDAO {

    MongoClient getClient() throws UnknownHostException {
    	MongoClientURI uri = new MongoClientURI("mongodb://admin:rjUGkdppNsdu@127.4.18.2:27017/");
		return new MongoClient(uri);
	}

    DBCollection getCollection(MongoClient mongoClient)
			throws UnknownHostException {

		DB db = mongoClient.getDB("wildfly8");
		return db.getCollection("consult");

	}

}
