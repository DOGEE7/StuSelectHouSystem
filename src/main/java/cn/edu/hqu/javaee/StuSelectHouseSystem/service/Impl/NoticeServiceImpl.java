package cn.edu.hqu.javaee.StuSelectHouseSystem.service.Impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Notice;
import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Student;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.NoticeRepository;
import cn.edu.hqu.javaee.StuSelectHouseSystem.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeRepository noticeRepository;
	@Override
	public Notice getNoticeDetail(Date time) {
		// TODO Auto-generated method stub
		return noticeRepository.findByTime(time);
	}

	@Override
	public void save(Notice notice) {
		// TODO Auto-generated method stub
		noticeRepository.save(notice);
	}

	@Override
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub
		return noticeRepository.getAllNotice();
	}

	@Override
	public List<Notice> stuCheckList(Notice notice, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
