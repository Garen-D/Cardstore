package ServerProgramming.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping(value="/hello")
	public String helloWorld() {
		return "index";
	}
}
