package cn.edu.hqu.javaee.StuSelectHouseSystem.service;

import java.sql.Date;
import java.util.List;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.HouseList;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Landlord;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Notice;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Student;

public interface NoticeService {
	public Notice getNoticeDetail(Date time);
	public void save(Notice notice);
	public List<Notice> getAllNotice();
	public static Notice createNotice(Notice notice, HouseList house, Landlord landlord, Student student) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Notice> stuCheckList(Notice notice, Student student);
}
