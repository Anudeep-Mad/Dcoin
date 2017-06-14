package dchain.DAO;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import dchain.SignUp;

public class SignUpDAO {
	@SuppressWarnings("deprecation")
	MongoTemplate mongoTemplate = new MongoTemplate(new Mongo(), "test");
	public void createUser(SignUp signup) throws UnknownHostException{
		
		//MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
		if (!mongoTemplate.collectionExists(SignUp.class)) {
			mongoTemplate.createCollection(SignUp.class);
		}
		//mongoTemplate.insert(signup, "DcoinUsers");
		mongoTemplate.insert(signup);
        // Now connect to your databases
        /*@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB( "test" );
        System.out.println("Connect to database successfully");
			
        DBCollection coll = db.getCollection("DcoinUsers");
        System.out.println("Collection trans selected successfully");
			
        BasicDBObject doc = new BasicDBObject("title", "Dcoin").
                append("From", signup.getFullname()).
                append("To", signup.getUsername()).
                append("Amount", signup.getPassword());
				
        coll.insert(doc);
        System.out.println("Document inserted successfully");
        mongoClient.close();*/
	}

}
