package ServerProgramming.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ServerProgramming.Card.Card;
import ServerProgramming.Card.CardRepository;
import ServerProgramming.Card.CategoryRepository;

@Controller
public class CardController {
		
	@Autowired
	private CardRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
    	// Show all cards
		@RequestMapping(value="/cardlist")
		public String cardList(Model model) {
			model.addAttribute("cards", repository.findAll());
			return "cardlist";
		}
		
	  
		// RESTful service to get all cards
	    @RequestMapping(value="/cards", method = RequestMethod.GET)
	    public @ResponseBody List<Card> CardListRest() {	
	        return (List<Card>) repository.findAll();
	        
	    }
	    	// RESTful service to get card by id
	        @RequestMapping(value="/card/{id}", method = RequestMethod.GET)
	        public @ResponseBody Card findCardRest(@PathVariable("id") Long CardId) {	
	        	return repository.findOne(CardId);
	        }  
		
		// add new card
		@RequestMapping(value ="/add")
		public String addCard(Model model){
			model.addAttribute("card", new Card());
			model.addAttribute("categories", crepository.findAll());
			return "addcard";
		}
		
		//Save new card
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Card card) {
			repository.save(card);
			return "redirect:cardlist";
		}

		//Delete card
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteCard(@PathVariable("id") Long cardId, Model model) {
			repository.delete(cardId);
			return "redirect:../cardlist";
		}
}