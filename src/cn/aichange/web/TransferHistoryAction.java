package cn.aichange.web;

import java.util.List;

import cn.aichange.bean.Customer;
import cn.aichange.bean.Employee;
import cn.aichange.bean.TransferHistory;
import cn.aichange.service.ICustomerService;
import cn.aichange.service.IEmployeeService;
import cn.aichange.service.ITransferHistoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TransferHistoryAction extends ActionSupport{
	//封装数据
	private Customer customer;
	private TransferHistory transferHistory; 
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setTransferHistory(TransferHistory transferHistory) {
		this.transferHistory = transferHistory;
	}
	public TransferHistory getTransferHistory() {
		return transferHistory;
	}
	
	
	//注入service
	private ITransferHistoryService transferHistoryService;
	public void setTransferHistoryService(
			ITransferHistoryService transferHistoryService) {
		this.transferHistoryService = transferHistoryService;
	}
	
	private ICustomerService customerService;
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	//列表展示
	public String list(){
		customer = null;
		transferHistory = null;
		List<TransferHistory> list = transferHistoryService.findAll();
		ActionContext.getContext().put("tansferHistoryList", list);
		return "list";
	}
	
	//前往添加移交记录页面
	public String toEdit(){
		//（查询）封装客户
		if(customer == null){
			List<Customer> customerList = customerService.findAll();
			ActionContext.getContext().put("customerList", customerList);
		}else{
			customer = customerService.findById(customer.getId());
		}
		//查询封装接收者
		Employee employee = (Employee)ActionContext.getContext().getSession().get("loginInfo");
		Integer id = employee.getId();
		List<Employee> empList = employeeService.findByNotId(id);
		ActionContext.getContext().put("empList", empList);
		return "toEdit";
	}
	
	//保存移交记录
	public String save(){
		System.out.println(transferHistory);
		transferHistoryService.save(transferHistory);
		return "toList";
	}
}
