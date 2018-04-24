package com.gary.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	// For local page
	@GetMapping("/search")
	public String loginForm(Model model) {
        model.addAttribute("account", new Account());
		return "search";
	}
	
	// For local page do search
	@PostMapping("/search")
	public String loginSubmit(Model model, @ModelAttribute Account account) {
		if(account==null) 
			return "search";
		
		Account acc = accountRepository.findByName(account.getName());
		if(acc!=null) {
			//System.out.println("id:"+acc.getId().toString()+","+"balance:"+acc.getBalance().toString());
			model.addAttribute("account", acc);
			return "result";
		}
		else
			return "search";
	}
	
	// REST API
	@RequestMapping("/dosearch/{accountName}")
	public Account byName(@PathVariable("accountName") String accountName) {
		System.out.println("shop searching: " + accountName);
		return accountRepository.findByName(accountName);
	}

}
