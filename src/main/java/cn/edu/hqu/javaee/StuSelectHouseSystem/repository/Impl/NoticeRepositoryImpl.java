package cn.edu.hqu.javaee.StuSelectHouseSystem.repository.Impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.Notice;
import cn.edu.hqu.javaee.StuSelectHouseSystem.repository.NoticeRepository;

@Repository
@Transactional
public class NoticeRepositoryImpl implements NoticeRepository{

	@PersistenceContext
	private EntityManager em;
	@Override
	public Notice findByTime(Date time) {
		// TODO Auto-generated method stub
		return em.find(Notice.class, time);
	}
	
	@Override
	public void save(Notice notice) {
		// TODO Auto-generated method stub
		em.persist(notice);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub
		return (List<Notice>) em.getProperties();
	}

}
