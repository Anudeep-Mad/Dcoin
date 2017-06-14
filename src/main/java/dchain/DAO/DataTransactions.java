package dchain.DAO;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import dchain.Transactions;

public class DataTransactions {
	public List<Transactions> view(){
		@SuppressWarnings("deprecation")
		MongoTemplate mongoTemplate = new MongoTemplate(new Mongo(), "test");
		return mongoTemplate.findAll(Transactions.class, "Transactions");
		
	}


}
