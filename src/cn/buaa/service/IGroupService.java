package cn.buaa.service;

import java.util.List;

import cn.buaa.model.Group;

public interface IGroupService {
	
	public void add(Group group);
	
	public void update(Group group);
	
	public void delete(int id);
	
	public Group load(int id);
	
	public List<Group> listAllGroup();
	
}
