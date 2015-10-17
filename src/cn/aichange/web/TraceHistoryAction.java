package cn.aichange.web;

import java.util.List;

import cn.aichange.bean.Customer;
import cn.aichange.bean.TraceHistory;
import cn.aichange.service.ICustomerService;
import cn.aichange.service.ITraceHistoryService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TraceHistoryAction extends ActionSupport{
	//封装数据
	private Customer customer;
	private TraceHistory traceHistory;
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setTraceHistory(TraceHistory traceHistory) {
		this.traceHistory = traceHistory;
	}
	public TraceHistory getTraceHistory() {
		return traceHistory;
	}
	
	
	//注入service
	private ICustomerService customerService;
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	private ITraceHistoryService traceHistoryService;
	public void setTraceHistoryService(ITraceHistoryService traceHistoryService) {
		this.traceHistoryService = traceHistoryService;
	}
	
	
	//前往添加跟进记录页面
	public String toEdit(){
		//（查询）封装客户
		if(customer == null){
			List<Customer> customerList = customerService.findAll();
			ActionContext.getContext().put("customerList", customerList);
		}else{
			customer = customerService.findById(customer.getId());
		}
		return "toEdit";
	}
	
	//保存跟进记录
	public String save(){
		//Map<String, Object> session = ActionContext.getContext().getSession();
		//Employee employee = (Employee)session.get("loginInfo");
		//traceHistory.setEmployee(employee);
		System.out.println(traceHistory);
		traceHistoryService.save(traceHistory);
		return "toList";
	}
	
	//列表展示跟进记录
	public String list(){
		customer = null;
		traceHistory = null;
		List<TraceHistory> list = traceHistoryService.findAll();
		ActionContext.getContext().put("traceHistoryList", list);
		return "list";
	}
	
	
	
}
