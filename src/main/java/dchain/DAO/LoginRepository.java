package dchain.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dchain.Login;

public interface LoginRepository extends MongoRepository<Login, String> {
	
	public Login findByUsername(String username);
	public List<Login> findAll();

}
