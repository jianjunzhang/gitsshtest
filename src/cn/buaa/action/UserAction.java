package cn.buaa.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.buaa.model.User;
import cn.buaa.service.IGroupService;
import cn.buaa.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private User user;
	private IUserService userService;
	private IGroupService groupService;
	private int gid;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public IGroupService getGroupService() {
		return groupService;
	}
	@Resource
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		if (user==null) {
			user = new User();
		}
		return user;
	}

	public String addInput(){
		ActionContext.getContext().put("listAllGroup", groupService.listAllGroup());
		return SUCCESS;
	}
	
	public String add(){
		userService.add(user, gid);
		ActionContext.getContext().put("url", "/user_list.action");
		return "redirect";
	}
	
	public void validateAdd(){
		if (user.getUsername()==null||"".equals(user.getUsername().trim())) {
			this.addFieldError("username", "用户名不能为空");
		}
		if (user.getNickname()==null||"".equals(user.getNickname().trim())) {
			this.addFieldError("nickname", "用户昵称不能为空");
		}
		if (user.getPassword()==null||"".equals(user.getPassword().trim())) {
			this.addFieldError("password", "用户密码不能为空");
		}
		if (gid==-1) {
			this.addFieldError("gid", "组为必填项，请选择");
		}
		if (this.hasFieldErrors()) {
			addInput();
		}
	}
	
	public String list(){
		ActionContext.getContext().put("list", userService.findUser());
		return SUCCESS;
	}
	
	public String delete(){
		userService.delete(user.getId());
		ActionContext.getContext().put("url", "/user_list.action");
		return "redirect";
	}
	
	public String updateInput(){
		User load = userService.load(user.getId());
		user.setNickname(load.getNickname());
		user.setUsername(load.getUsername());
		user.setPassword(load.getPassword());
		this.setGid(load.getGroup().getId());
		//System.out.println(gid);
		ActionContext.getContext().put("list", groupService.listAllGroup());
		return SUCCESS;
	}
	
	public String update(){
		User load = userService.load(user.getId());
		load.setUsername(user.getUsername());
		load.setPassword(user.getPassword());
		load.setNickname(user.getNickname());
		userService.update(load, gid);
		ActionContext.getContext().put("url", "/user_list.action");
		return "redirect";
	}
}
