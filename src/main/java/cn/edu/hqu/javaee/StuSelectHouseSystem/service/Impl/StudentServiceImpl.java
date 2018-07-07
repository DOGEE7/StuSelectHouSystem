package cn.edu.hqu.javaee.StuSelectHouseSystem.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Student;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.StudentRepository;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student login(String stuName,String password) {
		Student student;
		
		if((student=studentRepository.findByStuName(stuName))!=null&&student.getPassword().equals(password)) {
			System.out.println(student.getStuName());
			return student;
		}
		return null;
	}
	
	@Override
	public boolean register(Student student) {
		if((studentRepository.findByStuName(student.getStuName()))==null) {
			studentRepository.save(student);
			return true;
		}
		return false;
	}
	
	@Override
	public Student getStudentDetail(String stuName) {
		return studentRepository.findByStuName(stuName);
	}

	
	
	
	
	
}
