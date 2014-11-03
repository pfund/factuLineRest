package com.thomaspfund.checkconsult.convert;

import com.mongodb.DBObject;

public interface Converter<T> {

	public String getCollectionName();
	
	public T getFromMongo(DBObject object);
	
	public DBObject getMongoObject(T consult);
}
