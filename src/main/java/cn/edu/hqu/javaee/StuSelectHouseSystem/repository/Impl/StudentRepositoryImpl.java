package cn.edu.hqu.javaee.StuSelectHouseSystem.repository.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Student;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.StudentRepository;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository{
	@PersistenceContext
	private EntityManager em;
	@Override
	public void save(Student student) {
		em.persist(student);
	}
	
	@Override
	public Student findByStuName(String stuName) {
		return em.find(Student.class,stuName);
	}
	

}
