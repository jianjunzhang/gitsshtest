package cn.buaa.dao;

import cn.buaa.model.User;

public interface IUserDao extends IBaseDao<User> {
	/**
	 * 获取组中的用户数量
	 * @param gid  组的id
	 * @return 组中用户的数量
	 */
	public Long countUserByGroup(int gid);
	
	/**
	 * 删除组中的用户
	 * @param gid
	 */
	public void deleteByGroup(int gid);
	
}
