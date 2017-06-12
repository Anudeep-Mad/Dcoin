package hello.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.Transactions;

public interface TransactionsRepository extends MongoRepository<Transactions, String> {

    public Transactions findByfromName(String fromName);
    public List<Transactions> findBytoName(String toName);
    

}
