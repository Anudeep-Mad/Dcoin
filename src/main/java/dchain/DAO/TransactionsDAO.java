package dchain.DAO;

import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import dchain.Transactions;

public interface TransactionsDAO {
	
	public List<Transactions> list();
	
	public Transactions get();
	

	
	public void newTransactions(Transactions transacions) throws NoSuchAlgorithmException, UnknownHostException;
}
