package cn.edu.hqu.javaee.StuSelectHouseSystem.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cn.edu.hqu.javaee.StuSelectHouseSystemApplication;
import cn.edu.hqu.javaee.StuSelectHouseSystem.controller.formEntity.LandlordLoginForm;
import cn.edu.hqu.javaee.StuSelectHouseSystem.controller.formEntity.LandlordRegisterForm;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.HouseList;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Landlord;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Notice;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.HouseService;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.LandlordService;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.NoticeService;

@Controller
@RequestMapping("/landlord")
public class LandlordController {
	@Autowired
	LandlordService landlordService;
	@Autowired
	HouseService houseService;
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new LandlordRegisterForm());
		return "landlord_register";
	}
	

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegister(@Valid LandlordRegisterForm landlordRegisterForm,Errors errors,RedirectAttributes model)throws IOException{
		if(errors.hasErrors())
			return "landlord_register";
		else {
			Landlord landlord=new Landlord();
			landlord.setLanName(landlordRegisterForm.getLanName());
			landlord.setLanAddress(landlordRegisterForm.getLanAddress());
			landlord.setHouse(landlordRegisterForm.getHouse());
			landlord.setLanPhoneNumber(landlordRegisterForm.getLanPhoneNumber());
			landlord.setPassword(landlordRegisterForm.getPassword());
			if(!landlordService.register(landlord)) {
				errors.rejectValue("lanName", "用户已存在");
				return "landlord_register";
			}else {
				Files.copy(landlordRegisterForm.getPicFile().getInputStream(),Paths.get(StuSelectHouseSystemApplication.ROOT,landlord.getLanName()+ ".jpeg"),
				StandardCopyOption.REPLACE_EXISTING);
				model.addFlashAttribute(landlord);
				return "redirect:'landlord/"+landlord.getLanName();
				
			}
		}
		
	}
	

	@RequestMapping(value="/{lanName}",method=RequestMethod.GET)
	public String lanProfile(@PathVariable String lanName,Model model) {
		if(!model.containsAttribute("landlord")) {
			Landlord landlord=landlordService.getLandlordDetail(lanName);
			model.addAttribute(landlord);
		}
		return "lanlord_profile";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLandlordLoginForm(Model model) {
		model.addAttribute(new LandlordLoginForm());
		return "landlord_login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String processLogin(@Valid LandlordLoginForm landlordLoginForm,Errors errors,RedirectAttributes model) {
		Landlord landlord;
		if((landlord=landlordService.login(landlordLoginForm.getLanName(), landlordLoginForm.getPassword()))==null)
			return "landlord_login";
		model.addFlashAttribute(landlord);
		return "redirect:/landlord/"+landlord.getLanName();
	}
	
	
	
	
	 @RequestMapping(value = "/{lanName}/increase",method = RequestMethod.GET)
	    public String showAddInfo(@PathVariable String lanName, Model model)
	    {
	        String name=String.valueOf(lanName);
	        model.addAttribute(name);
	        model.addAttribute("increase",new House());
	        return "house_increase";
	    }

	    @RequestMapping(value = "/{lanName}/increase",method = RequestMethod.POST)
	    public String addPayProfile(@Valid House house,
	                             @SessionAttribute("landlord") Landlord landlord,
	                             Model model,HttpSession session)
	    {
	        model.addAttribute(house);
	        model.addAttribute(landlord);
	        session.setAttribute("house",house);
	        return "pay_update";
	    }

	    @RequestMapping(value = "/{lanName}/afterpay",method = RequestMethod.GET)
	    public String processAdd(@SessionAttribute("landlord") Landlord landlord,
	                                 @SessionAttribute("noticeList")List<Notice> noticeList,
	                                 @PathVariable Long houId,
	                                 @SessionAttribute("house") House house,
	                                 Error error,Model model)
	    {
	        house.setHouId(houId);
	        houseService.save(house);
	        HouseList houseList=new HouseList();
	        houseList.setList(houseService.getAll(houId));
	        model.addAttribute(landlord);
	        model.addAttribute(houseList);
	        model.addAttribute(noticeList);
	        return "landlord_Profile";
	    }

	    @RequestMapping(value = "/{lanName}/modify",method = RequestMethod.GET)
	    public String showModify(@SessionAttribute("houseList") HouseList houseList,
	                               @SessionAttribute("landlord") Landlord landlord,
	                               Model model)
	    {
	        model.addAttribute(landlord);
	        model.addAttribute(houseList);
	        return "house_modify";
	    }

	    @RequestMapping(value ="/{lanName}/modify",method = RequestMethod.POST)
	    public String processModify(@Valid HouseList houseList,
	                                  @SessionAttribute("landlord") Landlord landlord,
	                                  @SessionAttribute("noticeList")List<Notice> noticeList,
	                                  @PathVariable Long lanId,
	                                  Model model)
	    {
	        houseService.updateHouse(houseList);
	        HouseList house=new HouseList();
	        house.setList(houseService.getAll(lanId));
	        model.addAttribute(houseList);
	        model.addAttribute(noticeList);
	        model.addAttribute(landlord);
	        return "owner_profile";
	    }
	
	
	
	
	

}
