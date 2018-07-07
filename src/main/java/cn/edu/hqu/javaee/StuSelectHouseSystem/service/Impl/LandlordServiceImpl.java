package cn.edu.hqu.javaee.StuSelectHouseSystem.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Landlord;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.LandlordRepository;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.LandlordService;

@Service
public class LandlordServiceImpl implements LandlordService{
	@Autowired
	LandlordRepository landlordRepository;
	
	@Override
	public Landlord login(String lanName, String password) {
		// TODO Auto-generated method stub
		Landlord landlord;
		if((landlord=landlordRepository.findByLanName(lanName))!=null&&landlord.getPassword().equalsIgnoreCase(password)) {
			System.out.println(landlord.getLanName());
			return landlord;
		}
		return null;
	}

	@Override
	public boolean register(Landlord landlord) {
		// TODO Auto-generated method stub
		if((landlordRepository.findByLanName(landlord.getLanName()))==null) {
			landlordRepository.save(landlord);
			return true;
		}
		return false;
	}

	@Override
	public Landlord getLandlordDetail(String lanName) {
		// TODO Auto-generated method stub
		return landlordRepository.findByLanName(lanName);
	}

	@Override
	public Landlord getLandlordById(Object landlordId) {
		// TODO Auto-generated method stub
		return null;
	}

}
