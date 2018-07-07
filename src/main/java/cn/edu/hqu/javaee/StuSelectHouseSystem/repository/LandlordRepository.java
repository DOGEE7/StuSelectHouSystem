package cn.edu.hqu.javaee.StuSelectHouseSystem.repository;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Landlord;

public interface LandlordRepository {

	public Landlord findByLanName(String lanName);

	public void save(Landlord landlord);


}
