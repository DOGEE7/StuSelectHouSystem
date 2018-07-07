package cn.edu.hqu.javaee.StuSelectHouseSystem.repository.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Landlord;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.LandlordRepository;

@Repository
@Transactional
public class LandlordRepositoryImpl implements LandlordRepository{
	@PersistenceContext
	private EntityManager em;
	@Override
	public Landlord findByLanName(String lanName) {
		// TODO Auto-generated method stub
		return em.find(Landlord.class, lanName);
	}

	@Override
	public void save(Landlord landlord) {
		// TODO Auto-generated method stub
		em.persist(landlord);
		
	}

	

}
