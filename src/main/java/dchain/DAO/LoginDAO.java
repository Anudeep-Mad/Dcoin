package dchain.DAO;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.Mongo;

import dchain.Login;
import dchain.SignUp;

public class LoginDAO {
	public ModelAndView loginUser(Login login) throws UnknownHostException{


		@SuppressWarnings("deprecation")
		MongoTemplate mongoTemplate = new MongoTemplate(new Mongo(), "test");
		/*@SuppressWarnings("deprecation")
	MongoOperations mongoOps = new MongoTemplate(new Mongo(), "test");
	mongoOps.findOne(new Query(where("username").is(login.getUsername())), SignUp.class);
        // Now connect to your databases
		 */ //	MongoTemplate mongoTemplate;
		System.out.println(login.getUsername());
		/*SignUp find_user = mongoTemplate.findOne(new Query(Criteria.where("username").is(login.getUsername())),
				SignUp.class);*/
		SignUp find_user = mongoTemplate.findOne(new Query(Criteria.where("username").is(login.getUsername())), SignUp.class,"signUp");
		System.out.println("test");
		System.out.println(find_user.getPassword());
		if(login.getPassword().equals(find_user.getPassword())){
			System.out.println("sucess");
			return new ModelAndView("redirect:/create");
		}
		else {
			return new ModelAndView("redrect:/login");
		}

	}


}
