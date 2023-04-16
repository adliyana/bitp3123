
package my.edu.utem.ftmk.dad.restoredrapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.restoredrapp.model.OrderType;
import my.edu.utem.ftmk.dad.restoredrapp.repository.OrderTypeRepository;

@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController {
	@Autowired
private OrderTypeRepository orderTypeRepository;
	@GetMapping
	public List<OrderType> getOrderTypes(){
		return orderTypeRepository.findAll();
		
	}
	@GetMapping("{orderTypeId}")
	public OrderType getOrderType(@PathVariable long orderTypeId) {
		OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
		return orderType;
	}
	
	@PostMapping()
	public OrderType insertOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
	}
	
	@PutMapping()
	public OrderType updateOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
	}
	
	@DeleteMapping("{orderTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId){
		orderTypeRepository.deleteById(orderTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
