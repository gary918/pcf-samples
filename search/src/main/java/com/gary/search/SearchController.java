package com.gary.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

@Controller
public class SearchController {

	@Autowired
	protected SearchService searchService;
	
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}


	// @RequestMapping(value="/search", method = RequestMethod.GET)
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("searchcriteria", new SearchCriteria());
		return "search";
	}

	public String byName(Model model, String accountName) {

		Account account = searchService.findByName(accountName);
		model.addAttribute("account", account);
		return "result";
	}

	@RequestMapping(value = "/dosearch")
	public String doSearch(Model model, SearchCriteria criteria) {
		
		System.out.println("search searching:"+criteria.getAccountName());
		String accountName = criteria.getAccountName();
		return byName(model, accountName);
	}

}
