package hello;

import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.DAO.TransactionsDAOImpl;



@Controller
public class IndexController {

	
	private TransactionsDAOImpl transactionsDAO=new TransactionsDAOImpl();
    @RequestMapping("/")
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
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Transactions transactions) throws NoSuchAlgorithmException, UnknownHostException{
		transactionsDAO.newTransactions(transactions);
		return new ModelAndView("redirect:/");
	}

}
