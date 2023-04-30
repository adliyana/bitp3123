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

import my.edu.utem.ftmk.dad.restoredrapp.model.ProductType;

import my.edu.utem.ftmk.dad.restoredrapp.repository.ProductTypeRepository;

@RestController
@RequestMapping("/api/producttype")
public class ProductTypeController {
@Autowired
	private ProductTypeRepository productTypeRepository;
	@GetMapping
	public List<ProductType> getProductTypes(){
		return productTypeRepository.findAll();
		
	}
	@GetMapping("{productTypeId}")
	public ProductType getproductType(@PathVariable long productTypeId) {
		ProductType productType = productTypeRepository.findById(productTypeId).get();
		return productType;
	}
	
	@PostMapping()
	public ProductType insertProductType(@RequestBody ProductType ProductType) {
		return productTypeRepository.save(ProductType);
	}
	
	@PutMapping()
	public ProductType updateProductType(@RequestBody ProductType ProductType) {
		return productTypeRepository.save(ProductType);
	}
	
	@DeleteMapping("{productTypeId}")
	public ResponseEntity<HttpStatus> deleteProductType(@PathVariable long productTypeId){
		productTypeRepository.deleteById(productTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
