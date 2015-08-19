package cn.buaa.dao;

import org.springframework.stereotype.Repository;

import cn.buaa.model.User;

@Repository("userHibernateDao")
public class UserHibernateDao extends BaseDao<User> implements IUserDao {

	@Override
	public Long countUserByGroup(int gid) {
		
		Long count = (Long) this.getSession().createQuery("select count(*) from User where group.id=?")
			.setParameter(0, gid).uniqueResult();
		
		return count;
	}

	@Override
	public void deleteByGroup(int gid) {
		this.getSession().createQuery("delete from User u where u.group.id=?")
		.setParameter(0, gid).executeUpdate();
		
	}

	

}
