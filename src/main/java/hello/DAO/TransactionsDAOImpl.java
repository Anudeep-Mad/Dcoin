package hello.DAO;

import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import hello.Transactions;

public class TransactionsDAOImpl implements TransactionsDAO{
	@Autowired
	public TransactionsDAOImpl(){
	}

	@Override
	public List<Transactions> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transactions get() {
		
		return null;
	}

	@Override
	public void newTransactions(Transactions transactions) throws NoSuchAlgorithmException, UnknownHostException {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
        // Now connect to your databases
        DB db = mongoClient.getDB( "test" );
        System.out.println("Connect to database successfully");
			
        DBCollection coll = db.getCollection("trans");
        System.out.println("Collection trans selected successfully");
			
        BasicDBObject doc = new BasicDBObject("title", "Dcoin").
                append("From", transactions.getFrom_name()).
                append("To", transactions.getTo_name()).
                append("Amount", transactions.getAmount()).
                append("Hash", generateHash(transactions.getFrom_name(),transactions.getTo_name(),transactions.getAmount()));
				
        coll.insert(doc);
        System.out.println("Document inserted successfully");
		}
	

	private String generateHash(String from_name, String to_name, String amount) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String concat_trans = from_name+to_name+amount;
		byte[] hash = digest.digest(concat_trans.getBytes(StandardCharsets.UTF_8));
		return hash.toString();
	}

	

}
