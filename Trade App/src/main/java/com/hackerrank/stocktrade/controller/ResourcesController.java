package com.hackerrank.stocktrade.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.exception.EmployeeNotFoundException;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepo;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
	
	@Autowired
	TradeRepo traderepo;
	
	@GetMapping(path = "getAll")
	private List<Trade> getAllTrades(){
		List <Trade> tradelist = new ArrayList();
		tradelist=traderepo.findAll();
		return tradelist;
		
	}
//	@PutMapping(path ="trade/{id}")
//	private boolean AddTradeForUser(int id){
//		traderepo.save(id);
//		return true;
//		
//	}
	
	  @GetMapping("/employees/{id}")
	  Trade one(@PathVariable Long id) {

	    return traderepo.findById(id)
	      .orElseThrow(() -> new EmployeeNotFoundException(id));
	  }
	
	@DeleteMapping(path ="delete-all-trades")
	private void deleteAllTrades(){
		traderepo.deleteAll();
		
	}
	
//	@GetMapping
//	private Trade getTradeByUser(Trade id) {
//		traderepo.findById(id);
//		return null;
//		
//	}
    
}
