package org.java.demo.pizzeria.api.controller;

import java.util.List;

import org.java.demo.pizzeria.pojo.Pizza;
import org.java.demo.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/pizzas")
public class PizzaApiController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public ResponseEntity<List<Pizza>> index(@RequestParam(required = false) String name){
		List<Pizza> pizzas;
		
		if (name == null || name.isEmpty()) {
			pizzas = pizzaService.findAll();
		} else {

			pizzas = pizzaService.findBySearch(name);
		}
		
		if (pizzas.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(pizzas, HttpStatus.OK);
	}
}
