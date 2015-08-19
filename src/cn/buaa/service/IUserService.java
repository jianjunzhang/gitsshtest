package cn.buaa.service;

import java.util.List;

import cn.buaa.model.Pager;
import cn.buaa.model.User;

public interface IUserService {
	
	public void add(User user,int gid);
	
	public void update(User user,int gid);
	
	public void delete(int id);
	
	public User load(int id);
	
	public List<User> listAllUser();
	
	public List<User> listUserByGroup(int gid);
	
	public Pager<User> findUser();
}
