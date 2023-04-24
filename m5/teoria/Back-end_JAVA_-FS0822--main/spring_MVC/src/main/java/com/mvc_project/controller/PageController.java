package com.mvc_project.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RestController
@RequestMapping("/homepage")
public class PageController {
	
	@GetMapping
	public @ResponseBody String getHomePage() {
		System.out.println("getHomePage");
		return "Prima pagina Spring Web MVC";
	}
	
	@GetMapping("/param")
	public @ResponseBody String getHomePageQueryString(@RequestParam String test) {
		// http://localhost:8080/homepage/param?test=ciao
		return "Prima pagina Spring Web MVC QueryString: " + test;
	}
	
	@GetMapping("/param/{test}")
	public @ResponseBody String getHomePagePathParam(@PathVariable String test) {
		// http://localhost:8080/homepage/param/ciao
		return "Prima pagina Spring Web MVC PathParam: " + test;
	}
	
	@GetMapping("/thymeleaf/page1/{test}")
	public String getHomePageThymeleaf(
								Map<String, Object> model , 
								@PathVariable String test) {
		model.put("testParam", test);
		return "pageTest";
	}
	
	@GetMapping("/thymeleaf/page2/{test}")
	public String getHomePageThymeleaf(
								ModelMap model , 
								@PathVariable String test) {
		model.addAttribute("testParam", test);
		return "pageTest";
	}
	
	@GetMapping("/thymeleaf/page3/{test}")
	public String getHomePageThymeleaf(
								Model model , 
								@PathVariable String test) {
		model.addAttribute("testParam", test);
		return "pageTest";
	}
	
	@GetMapping("/thymeleaf/page4/{test}")
	public ModelAndView getHomePageThymeleaf(
								@PathVariable String test) {
		ModelAndView model = new ModelAndView("pageTest");
		model.addObject("testParam", test);
		model.addObject("Mioparam", "abc");
		return model;
	}

}
