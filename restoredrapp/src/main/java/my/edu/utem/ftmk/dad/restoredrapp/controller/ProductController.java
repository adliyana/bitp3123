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

import my.edu.utem.ftmk.dad.restoredrapp.model.Product;

import my.edu.utem.ftmk.dad.restoredrapp.repository.ProductRepository;


@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@GetMapping
	public List<Product> getProduct(){
		return productRepository.findAll();
		
	}
	@GetMapping("{productId}")
	public Product getproduct(@PathVariable long productId) {
		Product product = productRepository.findById(productId).get();
		return product;
	}
	
	@PostMapping()
	public Product insertProduct(@RequestBody Product Product) {
		return productRepository.save(Product);
	}
	
	@PutMapping()
	public Product updateProduct(@RequestBody Product Product) {
		return productRepository.save(Product);
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<HttpStatus> deleteProductType(@PathVariable long productId){
		productRepository.deleteById(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
