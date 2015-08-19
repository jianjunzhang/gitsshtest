package cn.buaa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.buaa.dao.IGroupDao;
import cn.buaa.dao.IUserDao;
import cn.buaa.exception.UserException;
import cn.buaa.model.Group;
@Service("groupService")
public class GroupService implements IGroupService {

	private IGroupDao groupHibernateDao;
	
	private IUserDao userHibernateDao;
	
	public IUserDao getUserHibernateDao() {
		return userHibernateDao;
	}
	@Resource
	public void setUserHibernateDao(IUserDao userHibernateDao) {
		this.userHibernateDao = userHibernateDao;
	}
	
	public IGroupDao getGroupHibernateDao() {
		return groupHibernateDao;
	}
	@Resource
	public void setGroupHibernateDao(IGroupDao groupHibernateDao) {
		this.groupHibernateDao = groupHibernateDao;
	}

	@Override
	public void add(Group group) {
		groupHibernateDao.add(group);

	}

	@Override
	public void update(Group group) {
		groupHibernateDao.update(group);

	}

	@Override
	public void delete(int id) {
		Long count = userHibernateDao.countUserByGroup(id);
		if (count>0) {
			throw new UserException("添加的组里面还有用户");
		}
		userHibernateDao.deleteByGroup(id);
		/*int a=8;
		if (a>9) {
			throw new UserException();
		}*/
		groupHibernateDao.delete(id);

	}

	@Override
	public Group load(int id) {
		return groupHibernateDao.load(id);
	}

	@Override
	public List<Group> listAllGroup() {
		
		return groupHibernateDao.list("from Group");
	}

}
