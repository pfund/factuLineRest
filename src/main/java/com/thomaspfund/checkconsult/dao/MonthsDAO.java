package com.thomaspfund.checkconsult.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.thomaspfund.checkconsult.convert.MonthResumeConverter;
import com.thomaspfund.checkconsult.dto.MonthResume;

public class MonthsDAO extends AbstractDAO {

	public List<MonthResume> getAllMonths() throws UnknownHostException {
		
		List<MonthResume> resultList = new ArrayList<>();
		
		MongoClient client = null;
		try {
			client = getClient();
			DBCollection collection = getCollection(client);

			DBObject projectFields = new BasicDBObject("_id", 0);
			DBObject keyObject = new BasicDBObject();
			keyObject.put("month", new BasicDBObject("$month", "$dateConsult"));
			keyObject.put("year", new BasicDBObject("$year", "$dateConsult"));
			projectFields.put("key", keyObject);
			projectFields.put("consultationPrice", "$consultationPrice");
			projectFields.put("materialPrice", "$materialPrice");
			projectFields.put("medicamentPrice", "$medicamentPrice");
			
			BasicDBList subtractList = new BasicDBList();
			subtractList.add(Integer.valueOf(1));
			subtractList.add("$rebate");
			DBObject ratio = new BasicDBObject();
			ratio.put("$subtract", subtractList);
			
			projectFields.put("ratio", ratio);
			
			DBObject sortFields = new BasicDBObject();
			sortFields.put("month", Integer.valueOf(1));
			sortFields.put("year", Integer.valueOf(1));
			DBObject sort = new BasicDBObject();
			sort.put("$sort", sortFields);
			
			DBObject project = new BasicDBObject();
			project.put("$project", projectFields);	
			
			DBObject consultationPriceWithRebate = new BasicDBObject();
			BasicDBList multiplyList = new BasicDBList();
			multiplyList.add("$consultationPrice");
			multiplyList.add("$ratio");
			consultationPriceWithRebate.put("$multiply", multiplyList);
			
			
			DBObject groupFields = new BasicDBObject();
			groupFields.put("_id", "$key");
			groupFields.put("consultationPrice", new BasicDBObject("$sum", consultationPriceWithRebate));
			groupFields.put("materialPrice", new BasicDBObject("$sum", "$materialPrice"));
			groupFields.put("medicamentPrice", new BasicDBObject("$sum", "$medicamentPrice"));

			DBObject group = new BasicDBObject();
			group.put("$group", groupFields);
			
			AggregationOutput aggOutput = collection.aggregate(project, sort, group);
			//  db.consult.aggregate( [ 
//				{ $project : { 
//					key: {$month : "$dateConsult"},
//					consultationPrice : "$consultationPrice"
//					}
//				}, { $group : {
//					_id : "$key", 
//					consultationPrice : {$sum : "$consultationPrice"}
//					}
//				}])
			
			for (DBObject result : aggOutput.results()) {
				resultList.add(MonthResumeConverter.getMonthResume(result));
			}
//			collection.aggregate(firstOp, additionalOps)
//			DBObject mongoConsult = collection.findOne(new BasicDBObject("_id",
//					new ObjectId(id)));
//			if (mongoConsult != null) {
//				consult = ConsultConverter.getConsultFromMongo(mongoConsult);
//			}
		} finally {
			if (client != null) {
				client.close();
			}
		}

		return resultList;
	}
}
