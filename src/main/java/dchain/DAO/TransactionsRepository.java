package dchain.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dchain.Transactions;

public interface TransactionsRepository extends MongoRepository<Transactions, String> {

    public Transactions findByfromName(String fromName);
    public List<Transactions> findBytoName(String toName);
    

}
