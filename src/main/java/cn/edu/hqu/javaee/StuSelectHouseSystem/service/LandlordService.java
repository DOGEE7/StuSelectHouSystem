package cn.edu.hqu.javaee.StuSelectHouseSystem.service;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Landlord;

public interface LandlordService {
	public Landlord login(String lanName,String password);
	public boolean register(Landlord lanlord);
	public Landlord getLandlordDetail(String lanName);
	public Landlord getLandlordById(Object landlordId);

}
