package my.edu.utem.ftmk.dad.restoredrapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.restoredrapp.model.OrderType;
import org.springframework.http.HttpEntity;
@Controller
public class OrderTypeMenuController {
	
	private String defaultURI = "http://localhost:8080/orderapp/api/ordertypes";
	
	@GetMapping("/ordertype/list")
	public String getOrderTypes(Model model)
	{
		String uri = "http://localhost:8080/orderapp/api/ordertypes";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OrderType[]>response =
				restTemplate.getForEntity(uri, OrderType[].class);
		OrderType orderTypes[] = response.getBody();
		List<OrderType>orderTypeList = Arrays.asList(orderTypes);
		model.addAttribute("orderTypes",orderTypeList);
		return "ordertypes";
		
	}
	
	@RequestMapping("ordertype/save")
	public String updateOrderType (@ModelAttribute OrderType orderType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <OrderType>request = new HttpEntity <OrderType>(orderType);
		String orderTypeResponse = "";
		
		if (orderType.getOrderTypeId()>0) {
			restTemplate.put(defaultURI, request,OrderType.class);
			
		}else {
			orderTypeResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(orderTypeResponse);
		return "redirect:/ordertype/list";
	}
	@GetMapping("/ordertype/{orderTypeId}")
	public String getOrderType(@PathVariable Integer orderTypeId, Model model) {
		String pageTitle = "New Order Type";
		OrderType orderType = new OrderType();
		if (orderTypeId > 0) {
			String uri = defaultURI + "/" + orderTypeId;
			RestTemplate restTemplate = new RestTemplate();
			orderType = restTemplate.getForObject(uri, OrderType.class);
			pageTitle ="Edit Order Type";
			
		}
		model.addAttribute("orderType",orderType);
		model.addAttribute("pageTitle",pageTitle);
		return "ordertypeinfo";
	}
	
	@RequestMapping("/ordertype/delete/{orderTypeId}")
	public String deleteOrderType(@PathVariable Integer orderTypeId) {
		String uri = defaultURI + "/{orderTypeId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("orderTypeId", Integer.toString(orderTypeId)));
		return "redirect:/ordertype/list";
	}
	
	
	
	
	
	
	
	/*@GetMapping("/ordertype/list")
	public ResponseEntity<String> getOrderTypes(){
		String uri = "http://localhost:8080/orderapp/api/ordertypes";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OrderType[]> response = 
				restTemplate.getForEntity(uri,OrderType[].class);
		
		OrderType orderTypes[] = response.getBody();
		
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Total record:"+ orderTypes.length + "\n");
		
		for (OrderType orderType:orderTypes) {
			System.out.print(orderType.getOrderTypeId() + "-");
			System.out.print(orderType.getCode() + "-");
			System.out.println(orderType.getCode());
			
		}
		String message = "Check out the message in the console";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}*/
}
