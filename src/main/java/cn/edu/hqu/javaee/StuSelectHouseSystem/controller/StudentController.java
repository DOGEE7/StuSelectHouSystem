package cn.edu.hqu.javaee.StuSelectHouseSystem.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

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
import cn.edu.hqu.javaee.StuSelectHouseSystem.controller.formEntity.StudentLoginForm;
import cn.edu.hqu.javaee.StuSelectHouseSystem.controller.formEntity.StudentRegisterForm;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.HouseList;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Landlord;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Notice;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Student;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.HouseService;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.LandlordService;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.NoticeService;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	HouseService houseService;
	@Autowired
	NoticeService noticeService;
	@Autowired
	LandlordService landlordService;
	

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new StudentRegisterForm());
		return "student_register";
	}
	

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegister(@Valid StudentRegisterForm studentRegisterForm,Errors errors,RedirectAttributes model)
			throws IOException{
		
		if(errors.hasErrors())
			return "student_register";
		else {
			Student student=new Student();
			student.setStuName(studentRegisterForm.getStuName());
			student.setStuAddress(studentRegisterForm.getStuAddress());
			student.setBirthDate(studentRegisterForm.getBirthDate());
			student.setStuPhoneNumber(studentRegisterForm.getStuPhoneNumber());
			student.setGender(studentRegisterForm.getGender());;
			student.setPassword(studentRegisterForm.getPassword());
			if(!studentService.register(student)) {
				errors.rejectValue("stuName","用户已存在");
				return "student_register";
			}else {
				Files.copy(studentRegisterForm.getPicFile().getInputStream(),
						Paths.get(StuSelectHouseSystemApplication.ROOT, student.getStuName()+".jpeg"),
						StandardCopyOption.REPLACE_EXISTING);
//				studentService.save(student);
				List<Notice> notice=noticeService.getAllNotice();
				model.addFlashAttribute(student);
				model.addFlashAttribute(notice);
				return "redirect:/student/"+student.getStuName();
			}
		}
	}
	
	@RequestMapping(value = "/{stuName}",method=RequestMethod.GET)
	public String stuProfile(@PathVariable String stuName,Model model) {
		if(!model.containsAttribute("student")) {
			Student student = studentService.getStudentDetail(stuName);
			List<Notice> notice= noticeService.getAllNotice();
			model.addAttribute(student);
			model.addAttribute(notice);
		}
		return "student_profile";
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showStudentLoginForm(Model model) {
		model.addAttribute(new StudentLoginForm());
		return "student_login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String proccessLogin(@Valid StudentLoginForm studentLoginForm,Errors errors,RedirectAttributes model) {
		Student student;
		if((student=studentService.login(studentLoginForm.getStuName(), studentLoginForm.getPassword()))==null)
			return "student_login";
		model.addFlashAttribute(student);
		return "redirect:/student/"+student.getStuName();
	}
	
	 @RequestMapping(value = "/{stuName}/book" ,method = RequestMethod.GET)
	    public String book(@SessionAttribute("houseList")HouseList houseList,
	                          @SessionAttribute("student")Student student,
	                          Model model)
	    {
	        House house=new House();
	        Notice notice=new Notice();
	        houseList.setList(houseService.checkBooking(houseList));
	        model.addAttribute(houseList);
	        model.addAttribute(house);
	        model.addAttribute(notice);
	        model.addAttribute(student);
	        return "house";
	    }

	    @RequestMapping(value = "/{stuName}/book",method = RequestMethod.POST)
	    public String bookProcess(Notice notice,
	                                 @SessionAttribute("student") Student student,
	                                 @SessionAttribute("houseList")HouseList houseList,
	                                 @PathVariable("stuName")String stuName,
	                                 Model model)
	    {
	        HouseList house=houseService.getHouseById(notice.getHouseId());
	        Landlord landlord=landlordService.getLandlordById(house.getLandlordId());
	        Notice notices=new Notice();
//	        List<Notice> noticeList=new List();

	        notices=NoticeService.createNotice(notice,house,landlord,student);
	        noticeService.save(notice);

	        notices.setList(noticeService.getAllNotice());
	        notices.setList(noticeService.stuCheckList(notice,student));

	        model.addAttribute("student",student);
	        model.addAttribute(houseList);
	        model.addAttribute(notice);
	        return "stu_profile";
	    }
	
	



}
