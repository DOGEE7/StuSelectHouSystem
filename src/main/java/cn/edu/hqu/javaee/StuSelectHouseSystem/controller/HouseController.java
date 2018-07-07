package cn.edu.hqu.javaee.StuSelectHouseSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;

@Controller
@RequestMapping("/house")
public class HouseController {
	
		@RequestMapping(method=RequestMethod.GET)
		public String getHouseProfile(Model model) {
			model.addAttribute(new House());
			return "house";
		}
		
	

}
