package cn.aichange.web;

import java.util.List;

import cn.aichange.bean.Dept;
import cn.aichange.service.IDeptService;
import cn.aichange.service.IEmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class DeptAction extends ActionSupport{
	//封装数据
	private Dept dept;
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Dept getDept() {
		return dept;
	}
	
	//注入service
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	//列表查看
	public String list(){
		//这一点很重要，可保证dept为空，这样直接点击添加按钮时才会没有dept对象
		dept = null;
		List<Dept> list = deptService.findAll();
		ActionContext.getContext().put("deptList", list);
		return "list";
	}
	
	//前往编辑
	public String toEdit(){
		if(dept != null){
			dept = deptService.findById(dept.getId());
		}
		return "toEdit";
	}
	
	//添加
	public String save(){
		deptService.save(dept);
		return "toList";
	}
	
	//更改
	public String update(){
		deptService.update(dept);
		return "toList";
	}
	
	//删除
	public String delete(){
		boolean result = employeeService.findByDeptId(dept.getId());
		if(result){
			ActionContext.getContext().put("msg", "该部门下存在员工，禁止删除！");
			return "error";
		}else{
			deptService.delete(dept.getId());
			return "toList";
		}
	}
	
}
