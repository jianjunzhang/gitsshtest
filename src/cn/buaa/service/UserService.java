package cn.buaa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.buaa.dao.IGroupDao;
import cn.buaa.dao.IUserDao;
import cn.buaa.exception.UserException;
import cn.buaa.model.Group;
import cn.buaa.model.Pager;
import cn.buaa.model.User;
@Service("userService")
public class UserService implements IUserService {

	private IUserDao userHibernateDao;
	private IGroupDao groupHibernateDao;
	
	public IGroupDao getGroupHibernateDao() {
		return groupHibernateDao;
	}
	@Resource
	public void setGroupHibernateDao(IGroupDao groupHibernateDao) {
		this.groupHibernateDao = groupHibernateDao;
	}
	public IUserDao getUserHibernateDao() {
		return userHibernateDao;
	}
	@Resource
	public void setUserHibernateDao(IUserDao userHibernateDao) {
		this.userHibernateDao = userHibernateDao;
	}

	@Override
	public void add(User user, int gid) {
		Group group = groupHibernateDao.load(gid);
		if (group==null) {
			throw new UserException("添加用户的组不存在");
		}
		user.setGroup(group);
		userHibernateDao.add(user);

	}

	@Override
	public void update(User user,int gid) {
		Group group = groupHibernateDao.load(gid);
		if (group==null) {
			throw new UserException("更新用户的组不存在");
		}
		user.setGroup(group);
		userHibernateDao.update(user);

	}

	@Override
	public void delete(int id) {
		userHibernateDao.delete(id);
	}

	@Override
	public User load(int id) {
		return userHibernateDao.load(id);
	}

	@Override
	public List<User> listAllUser() {
		//抓取策略
		return userHibernateDao.list("from User u left join fetch u.group");
	}

	@Override
	public List<User> listUserByGroup(int gid) {
		return userHibernateDao.list("from User where group.id=?", gid);
	}
	@Override
	public Pager<User> findUser() {
		String hql = "from User u left join fetch u.group";
		//System.out.println(hql);
		return userHibernateDao.find(hql);
	}

	

}
