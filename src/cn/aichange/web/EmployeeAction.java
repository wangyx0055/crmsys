package cn.aichange.web;

import java.util.List;

import cn.aichange.bean.Dept;
import cn.aichange.bean.Employee;
import cn.aichange.service.IDeptService;
import cn.aichange.service.IEmployeeService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport{
	//封装数据
	private Employee employee;
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	
	//与分页有关
	private int currentPage;
	private int pageSize;
	private Condition condition;
	private PageBean<Employee> pageBean;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public PageBean<Employee> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Employee> pageBean) {
		this.pageBean = pageBean;
	}

	
	//注入service
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	//列表查看
	@Deprecated
	public String listAll(){
		employee = null;
		List<Employee> list = employeeService.findAll();
		ActionContext.getContext().put("employeeList", list);
		return "list";
	}
	
	public String list(){
		employee = null;
		pageBean = employeeService.findPageByCondition(condition, currentPage, pageSize);
		//需要将currentPage和pageSize赋值。
		currentPage = pageBean.getCurrentPage();
		pageSize = pageBean.getPageSize();
		
		//部门查找出来
		List<Dept> deptList = deptService.findAll();
		ActionContext.getContext().put("deptList", deptList);
		return "list";
	}
	
	//前往编辑
	public String toEdit(){
		if(employee != null){
			employee = employeeService.findById(employee.getId());
		}
		List<Dept> list = deptService.findAll();
		ActionContext.getContext().put("deptList", list);
		return "toEdit";
	}
	
	//添加
	public String save(){
		employeeService.save(employee);
		return "toList";
	}
	
	//更改
	public String update(){
		employeeService.update(employee);
		return "toList";
	}
	
	//删除
	public String delete(){
		employeeService.delete(employee.getId());
		return "toList";
	}
	
	
}
