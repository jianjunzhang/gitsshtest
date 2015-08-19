package cn.buaa.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.buaa.model.Group;
import cn.buaa.service.IGroupService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("groupAction")
@Scope("prototype")
public class GroupAction extends ActionSupport implements ModelDriven<Group>{
	
	private Group group;
	private int cid;
	private IGroupService groupService;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public IGroupService getGroupService() {
		return groupService;
	}
	@Resource
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	public Group getModel() {
		if (group==null) {
			group = new Group();
		}
		return group;
	}
	
	public String list(){
		ActionContext.getContext().put("list", groupService.listAllGroup());
		return SUCCESS;
	}

	public String show(){
		//System.out.println(cid);
		group = groupService.load(cid);
		//System.out.println(group);
		return SUCCESS;
	}
	
	public String delete(){
		groupService.delete(group.getId());
		ActionContext.getContext().put("url", "group_list.action");
		return "redirect";
	}
	
	public String addInput(){
		return SUCCESS;
	}
	public String add(){
		//System.out.println(group);
		groupService.add(group);
		ActionContext.getContext().put("url", "/group_list.action");
		return "redirect";
	}
	
	public void validateAdd(){
		if (group.getName()==null||"".equals(group.getName().trim())) {
			this.addFieldError("name", "组名称不能为空");
		}
	}
	
	public String updateInput(){
		Group load = groupService.load(group.getId());
		group.setName(load.getName());
		//System.out.println(group);
		return SUCCESS;
	}
	public String update(){
		//System.out.println(group);
		Group load = groupService.load(group.getId());
		load.setName(group.getName());
		groupService.update(load);
		ActionContext.getContext().put("url", "/group_list.action");
		return "redirect";
	}
}
