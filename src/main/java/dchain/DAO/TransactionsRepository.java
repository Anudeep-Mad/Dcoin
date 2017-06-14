package dchain.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dchain.Transactions;

public interface TransactionsRepository extends CrudRepository<Transactions, String> {

    public Transactions findByfromName(String fromName);
    public List<Transactions> findBytoName(String toName);
    

}
