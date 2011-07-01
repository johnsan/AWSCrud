package com.awscrud.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.awscrud.domain.Snowboard;
import com.awscrud.service.SnowboardService;
import com.awscrud.service.SnowboardServiceImpl;

@Controller
@RequestMapping("/snowboard")
public class SnowboardController {
	
	private SnowboardService snowboardService = new SnowboardServiceImpl();
	
	@RequestMapping(value = "/createSnowboard.do", method = RequestMethod.POST)
	public String processCreateSnowboard(@ModelAttribute("snowboard")
							Snowboard snowboard, BindingResult result) throws Exception {
		
		snowboardService.createSnowboard(snowboard);
		
		return "redirect:manageSnowboard.do";
	}
/*	
	@RequestMapping(value = "/deleteSnowboard/{id}")
	public String processDeleteSnowboard(@PathVariable ("id") Long id) {
		
		snowboardManager.deleteSnowboard(id);

		return "redirect:/snowboard/manageSnowboard";
	}
	
	@RequestMapping(value = "/ajaxUpdate/{id}/{fieldModified}/{newValue}", 
			method = RequestMethod.POST)
	public String ajaxUpdate(@PathVariable ("id") Long id, 
			@PathVariable ("fieldModified") String fieldModified, 
			@PathVariable ("newValue") String newValue){
		
		snowboardManager.updateSnowboard(id, fieldModified, newValue);

		return null;
	}
*/	
	@RequestMapping("/manageSnowboard.do")
	public ModelAndView showSnowboards() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("snowboard/manageSnowboard");
		modelAndView.addObject("command", new Snowboard());
		modelAndView.addObject("snowboardList", snowboardService.getAllSnowboards());
		
		return modelAndView;
		
	}
}
