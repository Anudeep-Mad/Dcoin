package dchain;

import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dchain.DAO.DataTransactions;
import dchain.DAO.LoginDAO;
import dchain.DAO.SignUpDAO;
import dchain.DAO.TransactionsDAOImpl;
import dchain.DAO.TransactionsRepository;



@Controller
public class IndexController {

	private DataTransactions dataTransactions = new DataTransactions();
	@Autowired
	TransactionsRepository transactionsRepository;
	private TransactionsDAOImpl transactionsDAO=new TransactionsDAOImpl();
	private SignUpDAO signupDao = new SignUpDAO();
	private LoginDAO loginDao = new LoginDAO();
    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
    @RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView newTransaction(ModelAndView model) {
		Transactions create = new Transactions();
		model.addObject("transactions", create);
		model.setViewName("create");
		return model;
	}
    @RequestMapping(value="/signup", method = RequestMethod.GET)
   	public ModelAndView createUser(ModelAndView model) {
   		SignUp create = new SignUp();
   		model.addObject("signup", create);
   		model.setViewName("signup");
   		return model;
   	}
   
    @RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginUser(ModelAndView model) {
		Login create = new Login();
		model.addObject("login", create);
		model.setViewName("login");
		return model;
	}
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Transactions transactions) throws NoSuchAlgorithmException, UnknownHostException{
		transactionsDAO.newTransactions(transactions);
		return new ModelAndView("redirect:/");
	}
    @RequestMapping(value = "/view", method = RequestMethod.POST)
	public ModelAndView show(ModelAndView model) throws NoSuchAlgorithmException, UnknownHostException{
		List<Transactions> trans = dataTransactions.view();
		model.addObject("transactions",trans);
		return model;
	}
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute SignUp signup) throws NoSuchAlgorithmException, UnknownHostException{
		signupDao.createUser(signup);
    	return new ModelAndView("redirect:/");
	}
    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Login login) throws NoSuchAlgorithmException, UnknownHostException{
    	 return loginDao.loginUser(login);
    	//return new ModelAndView("create");
	}
  
}