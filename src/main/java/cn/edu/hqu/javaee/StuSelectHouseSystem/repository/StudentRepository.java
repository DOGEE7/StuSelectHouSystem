package cn.edu.hqu.javaee.StuSelectHouseSystem.repository;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Student;

public interface StudentRepository {
	public void save(Student student);
	public Student findByStuName(String stuName);

}
