package cn.edu.hqu.javaee.StuSelectHouseSystem.repository.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.HouseList;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.HouseRepository;

@Repository
@Transactional
public class HouseRepositoryImpl implements HouseRepository{

	@PersistenceContext
	private EntityManager em;
	@Override
	public void save(House house) {
		// TODO Auto-generated method stub
		em.persist(house);
		
	}

	@Override
	public House findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(House.class, id);
	}



	@Override
	public HouseList getALl() {
		// TODO Auto-generated method stub
		return (HouseList) em.getProperties();
	}

	
	@Override
	public House updateHouse(House house) {
		String update=
				"UPDATE house set"+
		"houAddress"+"'"+house.getHouAddress()+"'"+
		",type="+"'"+house.getType()+"'"+
		",population="+"'"+house.getPopulation()+"'"+
		",rentPrice="+"'"+house.getRentPrice()+"'"+
		",ownerId="+"'"+house.getLandlord().getLanId()+"'"+
		",rentOrNot="+"'"+house.getRentOrNot()+"'"+
		",updateCost="+"'"+house.getUpdateCost()+"'"+
		"where id="+"'"+house.getHouId()+"'";
		return (House) em.createQuery(update);
	}
/*
	@Override
	public HouseList findByLandlordId(Landlord landlord) {
		// TODO Auto-generated method stub
		HouseList houseList=((House) em).findByLandlordId(House.class, landlord.getId());
		return houseList;
	}*/
}
