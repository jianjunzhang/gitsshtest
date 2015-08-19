package cn.buaa.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.buaa.dao.IGroupDao;
import cn.buaa.dao.IUserDao;
import cn.buaa.model.Group;
import cn.buaa.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestHibernate {
	
	@Resource
	private IUserDao userHibernateDao;
	@Resource
	private IGroupDao groupHibernateDao;
	
	@Test
	public void test01(){
		Group g = new Group();
		g.setName("呵呵呵");
		groupHibernateDao.add(g);
		System.out.println(g.getId());
		User user = new User("hehe","123","呵呵");
		//userHibernateDao.add(user, g.getId());
	}
	@Test
	public void test02(){
		Group group = groupHibernateDao.load(2);
		System.out.println(group);
	}
	@Test
	public void test03(){
		Group g = new Group();
		g.setName("呵呵小组123");
		groupHibernateDao.add(g);
		for(int i=1;i<=20;i++){
			User user = new User("hehe"+i,"123","呵呵"+i);
			user.setGroup(g);
			userHibernateDao.add(user);
		}
	}
	
}
