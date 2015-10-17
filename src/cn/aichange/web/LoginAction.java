package cn.aichange.web;

import java.util.List;
import java.util.Map;

import cn.aichange.bean.Employee;
import cn.aichange.service.IEmployeeService;
import cn.aichange.util.Condition;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	//封装数据
	private Employee employee;
	private String code_image;
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	public String getCode_image() {
		return code_image;
	}
	public void setCode_image(String code_image) {
		this.code_image = code_image;
	}
	
	
	//注入service
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	//登录
	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		String checkcode = (String)session.get("checkcode");
		if(code_image.equalsIgnoreCase(checkcode)){
			Condition condition = new Condition();
			condition.setName(employee.getEmpName());
			condition.setPwd(employee.getPwd());
			List<Employee> list = employeeService.findByCondition(condition);
			if(list != null && list.size() == 1){
				ActionContext.getContext().getSession().put("loginInfo", list.get(0));
				return "success";
			}else{
				ActionContext.getContext().put("msg", "用户名或密码有错！");
				return "login";
			}
		}else{
			ActionContext.getContext().put("msg", "验证码错误！");
			return "login";
		}
	}
	
	//退出
	public String logout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object object = session.get("loginInfo");
		if(object != null){
			session.remove("loginInfo");
		}
		return "login";
	}

}
