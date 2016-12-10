package com.ebay;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class yourCart {
	public Object removeYourBidAD(String product_id, String username) {

		System.out.println("INSIDE WEB SERVICE REMOVE YOUR BID ITEM");

		MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(connectionString);

		MongoDatabase database = mongoClient.getDatabase("EbayDatabaseMongoDB");

		MongoCollection<Document> collection = database.getCollection("bid");
		System.out.println("product_id" + product_id + "username" + username);

		collection.deleteOne( eq("product_id", product_id));
	
		System.out.println("YOUR BID ITEM HAS BEEN DELETED");
		return 1;

	}
}