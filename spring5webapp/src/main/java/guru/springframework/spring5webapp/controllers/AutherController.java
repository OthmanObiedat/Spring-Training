package guru.springframework.spring5webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.repositries.AuthorRepo;

@Controller
public class AutherController {

	@Autowired
	private AuthorRepo authorRepo;
	
	@RequestMapping("/authers")
	public String getAuthers(Model model) {
	
		Iterable<Author> authers = authorRepo.findAll();
		model.addAttribute("authers", authers);
		return"authers";
	}
}
