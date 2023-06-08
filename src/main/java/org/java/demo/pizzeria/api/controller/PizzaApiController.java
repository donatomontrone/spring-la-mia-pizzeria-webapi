package org.java.demo.pizzeria.api.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pizzeria.pojo.Pizza;
import org.java.demo.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

		return new ResponseEntity<>(pizzas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pizza> get(@PathVariable Integer id){
		
		Optional<Pizza> oPizza = pizzaService.findById(id);
		
		if (oPizza.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
			Pizza pizza = oPizza.get();
			return new ResponseEntity<>(pizza,HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Pizza> create(
			@RequestBody Pizza pizza){

		
		pizza = pizzaService.save(pizza);
		
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Pizza> update(
			@RequestBody Pizza pizza){

		
		pizza = pizzaService.save(pizza);
		
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		
		Optional<Pizza> oPizza = pizzaService.findById(id);
		
		if (!oPizza.isPresent()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
			Pizza pizza = oPizza.get();
			pizza.getIngredients().clear();
			pizzaService.delete(pizza);
			return new ResponseEntity<>("pizza deleted succesfully", HttpStatus.OK);
		
	}
	
}
