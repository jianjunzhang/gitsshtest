package cn.buaa.dao;

import org.springframework.stereotype.Repository;

import cn.buaa.model.Group;
@Repository("groupHibernateDao")
public class GroupHibernateDao extends BaseDao<Group> implements IGroupDao {


}
