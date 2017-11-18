package net.asd.shopping.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import net.asd.shoppingbackend.dao.OrdersDAO;
import net.asd.shoppingbackend.dto.Orders;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired OrdersDAO orderDAO;
	private static final Logger logger  = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value="/orderproducts",method=RequestMethod.GET)
	public ModelAndView showOrderProducts(@RequestParam(name="operation",required=false)String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickOrderProducts",true);
		mv.addObject("title","Order Products");
		
		Orders nOrder = new Orders();
		
		nOrder.setActive(true);
		mv.addObject("order",nOrder);
		
		if(operation !=null) {
			if(operation.equals("order")) {
				mv.addObject("message","Order Submited Succesfuly");
				
			}
		}
		
		return mv;
		
		
	}
	
//handling order submission
	@RequestMapping(value="/orderproducts",method=RequestMethod.POST)
	public String handleOrderSubmission(@Valid @ModelAttribute("order")Orders morder,BindingResult results,Model model) {
		//check if there are errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickOrderProducts",true);
			model.addAttribute("title","Order Products");
			return "page";
		}
		logger.info(morder.toString());
		//create new order Record 
		orderDAO.add(morder);
		return "redirect:/order/orderproducts?operation=order";
	}
	
	//update
/*	@RequestMapping(value="/orderproducts",method=RequestMethod.POST)
	public String handleOrderUpdateSubmission(@Valid @ModelAttribute("order")Orders morder,BindingResult results,Model model) {
		//check if there are errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickOrderProducts",true);
			model.addAttribute("title","Order Products");
			return "page";
		}
		logger.info(morder.toString());
		//create new order Record 
		orderDAO.delete(morder);
		return "redirect:/order/orderproducts?operation=order";
	}*/
}
