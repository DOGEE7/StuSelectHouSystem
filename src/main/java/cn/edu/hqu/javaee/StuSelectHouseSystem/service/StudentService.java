package cn.edu.hqu.javaee.StuSelectHouseSystem.service;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Student;

public interface StudentService {
	public Student login(String stuName,String password);
	public boolean register(Student student);
	public Student getStudentDetail(String stuName);
//	public void save(Student student);

}
