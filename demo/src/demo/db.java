package demo;

import org.apache.commons.lang.RandomStringUtils;
import org.bson.Document;

/*import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;*/
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import static com.mongodb.client.model.Filters.*;

public class db { 
   
	static MongoDatabase db;
	static MongoClient client;
	static String generatedString;
	
	public db() { 
		
		MongoClientURI uri  = new MongoClientURI("mongodb://user:users1@ds111244.mlab.com:11244/disaster-mangement-sys"); 
	    client = new MongoClient(uri);
	    db = client.getDatabase(uri.getDatabase());
	    generatedString = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
        System.out.println(""+generatedString);
	    System.out.println("DB Connection made");
	    
	} 
   
	public void insert(Document doc) {        
	    MongoCollection<Document> donations = db.getCollection("donations");
	    donations.insertOne(doc);
	    System.out.println("Inserted");
	    client.close();
	}
   
	public String fetch(String trackingId) { 
		
	    MongoCollection<Document> donations = db.getCollection("donations");
	    String myDoc = donations.find((eq("id", trackingId))).projection(Projections.include("status")).first().getString("status");
	    System.out.println("Fetched");
	    client.close();
	    
	    return myDoc;
	}
   
}
