package cn.edu.hqu.javaee.StuSelectHouseSystem.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.HouseList;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.HouseRepository;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService{

	@Autowired
	HouseRepository houseRepository;

	@Override
	public void updateHouse(HouseList houseList) {
		// TODO Auto-generated method stub
		for(int i=0;i<houseList.getList().size();i++) {
			House house=houseList.getList().get(i);
			houseRepository.updateHouse(house);
		}
	}

	@Override
	public HouseList getAll(Long id) {
		// TODO Auto-generated method stub
		return houseRepository.getALl();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public HouseList checkBooking(HouseList houseList) {
		// TODO Auto-generated method stub
		HouseList checkedList=new HouseList();
		int i=0;
		for(;i<houseList.getList().size();i++) {
			if(houseList.getList().get(i).getRentOrNot().equals("不可以"))
				continue;
			else
				checkedList.getList().add(houseList.getList().get(i));
		}
		return checkedList;
	}

	@Override
	public void save(House house) {
		// TODO Auto-generated method stub
		houseRepository.save(house);
		
	}

	@Override
	public House findById(Long id) {
		// TODO Auto-generated method stub
		return houseRepository.findById(id);
	}

	@Override
	public HouseList getAll(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HouseList getHouseById(String houseId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}
