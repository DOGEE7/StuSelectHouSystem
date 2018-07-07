package cn.edu.hqu.javaee.StuSelectHouseSystem.service;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.HouseList;

public interface HouseService {
	public void save(House house);
	public House findById(Long id);
	//public HouseList findByLandlordId(Long id);
	public void updateHouse(HouseList houseList);
	public HouseList getAll(String string);
	public HouseList checkBooking(HouseList houseList);
	public HouseList getHouseById(String houseId);
	public HouseList getAll(Long id);
	
	
}
