package cn.edu.hqu.javaee.StuSelectHouseSystem.repository;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.HouseList;

public interface HouseRepository {
	public void save(House house);
	public House findById(Long id);
	public HouseList getALl();
	public House updateHouse(House house);
	//public HouseList findByLandlordId(Landlord landlord);
}
