package ServerProgramming.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ServerProgramming.Book.*;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; 

	@RequestMapping(value="/hello")
	public String helloWorld() {
		return "index";
	}
		
	    @RequestMapping(value="/Booklist")
	    public String BookList(Model model) {	
	        model.addAttribute("books", repository.findAll());
	        return "Booklist";
	    }
	  
	    @RequestMapping(value = "/add")
	    public String addbook(Model model){
	    	model.addAttribute("book", new Book());
	        return "addbook";
	    }     
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:Booklist";
	    }    

	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long BookId, Model model) {
	    	repository.delete(BookId);
	        return "redirect:./Booklist";
	    }  
	}

