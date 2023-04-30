package my.edu.utem.ftmk.dad.restoredrapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.restoredrapp.model.OrderType;
import my.edu.utem.ftmk.dad.restoredrapp.model.ProductType;

@Controller
public class ProductTypeMenuController {

private String defaultURI = "http://localhost:8080/orderapp/api/producttype";
	
	@GetMapping("/producttype/list")
	public String getProductTypes(Model model)
	{
		String uri = "http://localhost:8080/orderapp/api/producttype";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProductType[]>response =
				restTemplate.getForEntity(uri, ProductType[].class);
		ProductType productType[] = response.getBody();
		List<ProductType>productTypeList = Arrays.asList(productType);
		model.addAttribute("ProductType",productTypeList);
		return "ProductType";
	}
	
	@RequestMapping("producttype/save")
	public String updateProductType (@ModelAttribute ProductType productType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <ProductType>request = new HttpEntity <ProductType>(productType);
		String productTypeResponse = "";
		
		if (productType.getProductTypeId()>0) {
			restTemplate.put(defaultURI, request,ProductType.class);
			
		}else {
			productTypeResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(productTypeResponse);
		return "redirect:/producttype/list";
	}
	
	@GetMapping("/producttype/{productTypeId}")
	public String getProductType(@PathVariable Integer productTypeId, Model model) {
		String pageTitle = "New Product Type";
		ProductType productType = new ProductType();
		if (productTypeId > 0) {
			String uri = defaultURI + "/" + productTypeId;
			RestTemplate restTemplate = new RestTemplate();
			productType = restTemplate.getForObject(uri, ProductType.class);
			pageTitle ="Edit Product Type";
			
		}
		model.addAttribute("ProductType",productType);
		model.addAttribute("pageTitle",pageTitle);
		return "producttypeinfo";
	}
	
	@RequestMapping("/producttype/delete/{productTypeId}")
	public String deleteProductType(@PathVariable Integer productTypeId) {
		String uri = defaultURI + "/{productTypeId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("productTypeId", Integer.toString(productTypeId)));
		return "redirect:/producttype/list";
	}
	
}
