package dchain.DAO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;

import dchain.Transactions;

public class MineTransactions {
	String minelist="";
	public void mineTransactions() throws NoSuchAlgorithmException{
		@SuppressWarnings("deprecation")
		MongoTemplate mongoTemplate = new MongoTemplate(new Mongo(), "test");
		List<Transactions> list = mongoTemplate.findAll(Transactions.class, "Transactions");
		System.out.println("Test point");
		long a = mongoTemplate.count(new Query(Criteria.where("mineStatus").is(false)), "Transactions");
		System.out.println(a);
		for(int i=0;i<a;i++){
			if(i!=0 && i%5==0){
				String alpha =  generateHash(minelist);
				minelist="";
				System.out.println(alpha);
			}
			else
				minelist = minelist+list.get(i).getBlockId();
				System.out.println(minelist);
		}
		
	}
	private String generateHash(String list) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(list.getBytes(StandardCharsets.UTF_8));
		System.out.println(hash.toString()+"hai");
		/*if(hash[0]!=0 || hash[1]!=0){
			return generateHash(hash.toString());
		}
		else*/
		System.out.println(hash.toString());
			return hash.toString();
	}

	

}
