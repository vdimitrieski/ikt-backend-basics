package com.iktpreobuka.myfirstproject.controllers;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {
	
	@RequestMapping("/")
	public String hello() {
		return "Moja prva aplikacija";
	}

	// resenje zadatka 2.1
	@RequestMapping("/date")
	public String date() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// resenje zadatka 2.2
	@RequestMapping("/family")
	public List<String> family() {
		List<String> lst = new ArrayList<String>();
		lst.add("Vladimir");
		lst.add("Danka");
		return lst;
	}

	// resenje zadatka 2.3
	@RequestMapping("/myclass")
	public String myClass() {
		String html = "<html><h1>Moja grupa</h1><br></br><table><tr><td>Vladimir</td><td>Dimitrieski</td></tr><tr><td>Milan</td><td>Celikovic</td></tr></table></html>";
		return html;
	}

	
	
}
