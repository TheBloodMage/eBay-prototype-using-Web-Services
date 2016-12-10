package com.ebay;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class submitBid {
	public Object submitBid(String username) {
		
		Block<Document> printBlock = new Block<Document>() {
		     @Override
		     public void apply(final Document document) {
		         System.out.println(document.toJson());
		     }
		};
		
		System.out.println("INSIDE WEB SERVICE TO SUBMIT BID ITEM");

		MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(connectionString);

		MongoDatabase database = mongoClient.getDatabase("EbayDatabaseMongoDB");

		MongoCollection<Document> collection = database.getCollection("bid");
		System.out.println("username" + username);

		collection.find(eq("username", username)).forEach(printBlock);
	
		System.out.println("YOUR BID ITEM HAS BEEN DELETED");
		return 1;

	}
}
