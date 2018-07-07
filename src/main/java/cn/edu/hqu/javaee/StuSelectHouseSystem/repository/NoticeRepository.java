package cn.edu.hqu.javaee.StuSelectHouseSystem.repository;

import java.util.Date;
import java.util.List;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Notice;

public interface NoticeRepository {
	public Notice findByTime(Date time);
	public List<Notice> getAllNotice();
	public void save(Notice notice);

}
