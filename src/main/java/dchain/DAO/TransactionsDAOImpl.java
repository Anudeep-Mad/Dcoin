package dchain.DAO;

import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

import dchain.Transactions;

public class TransactionsDAOImpl implements TransactionsDAO{
	@Autowired
	TransactionsRepository transactionsRepository;
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
		@SuppressWarnings("deprecation")
		MongoTemplate mongoTemplate = new MongoTemplate(new Mongo(), "test");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String blockid = generateHash(transactions.getFrom_name(),transactions.getTo_name(),transactions.getAmount(),timestamp.toString());
		transactions.setBlockId(blockid);
		if (!mongoTemplate.collectionExists("Transactions")) {
			mongoTemplate.createCollection("Transactions");
		}
		mongoTemplate.insert(transactions, "Transactions");
	}	

	private String generateHash(String from_name, String to_name, String amount,String timestamp) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String concat_trans = from_name+to_name+amount+timestamp;
		byte[] hash = digest.digest(concat_trans.getBytes(StandardCharsets.UTF_8));
		return hash.toString();
	}

	

}
