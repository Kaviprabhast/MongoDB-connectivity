package com.example;

import com.mongodb.client.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // Create a MongoDB client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        
        // Get the database
        MongoDatabase database = mongoClient.getDatabase("blogpost");
        
        // Get the collection
        MongoCollection<Document> collection = database.getCollection("test");
        
        // Create documents to insert
        Document blog1 = new Document("title", "Water Blog Post")
            .append("content", "This blog is about Water")
            .append("tags", "Welcome");

        Document blog2 = new Document("title", "Agriculture Blog Post")
            .append("content", "This blog is about Agriculture")
            .append("tags", "Introduction");
        
        // Insert documents
        collection.insertOne(blog1);
        collection.insertOne(blog2);
        
        System.out.println("Documents inserted successfully!");

        // List the documents
        FindIterable<Document> documents = collection.find();
        for (Document doc : documents) {
            System.out.println(doc.toJson());
        }

        // Close the connection
        mongoClient.close();
    }
}