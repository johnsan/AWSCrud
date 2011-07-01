package com.awscrud.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/deleteSnowboard.do")
	public String processDeleteSnowboard(@RequestParam("id") long id) throws Exception {
		
		snowboardService.deleteSnowboardById(id);

		return "redirect:/snowboard/manageSnowboard.do";
	}
	
	@RequestMapping(value = "/ajaxUpdate.do", 
			method = RequestMethod.POST)
	public String ajaxUpdate(@RequestParam("id") long id, 
			@RequestParam("fieldModified") String fieldModified, 
			@RequestParam("newValue") String newValue) throws Exception{
		
		System.out.println("here id: " + id);
		snowboardService.updateSnowboard(id, fieldModified, newValue);

		return null;
	}
	
	@RequestMapping("/manageSnowboard.do")
	public ModelAndView showSnowboards() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("snowboard/manageSnowboard");
		modelAndView.addObject("command", new Snowboard());
		modelAndView.addObject("snowboardList", snowboardService.getAllSnowboards());
		
		return modelAndView;
		
	}
}
