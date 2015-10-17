package cn.aichange.web;

import java.util.List;

import cn.aichange.bean.Customer;
import cn.aichange.service.ICustomerService;
import cn.aichange.util.Condition;
import cn.aichange.util.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{
	//封装数据
	private Customer customer;
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	
	//与搜索分页有关
	private int currentPage;
	private int pageSize;
	private Condition condition;
	private PageBean<Customer> pageBean;
	
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
	public PageBean<Customer> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Customer> pageBean) {
		this.pageBean = pageBean;
	}


	//注入service
	private ICustomerService customerService;
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	

	//列表查看
	@Deprecated
	public String listAll(){
		customer = null;
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().put("customerList", list);
		return "list";
	}
	
	//根据条件列表查看
	public String list(){
		customer = null;
		if(condition == null){
			condition = new Condition();
		}
		//只显示跟进中的客户，状态值为0
		//condition.setTraceStatus(0);
		pageBean = customerService.findPageByCondition(condition, currentPage, pageSize);
		//需要将currentPage和pageSize赋值。
		currentPage = pageBean.getCurrentPage();
		pageSize = pageBean.getPageSize();
		return "list";
	}
	
	//前往编辑
	public String toEdit(){
		//（查询）封装客户
		if(customer != null){
			customer = customerService.findById(customer.getId());
		}
		return "toEdit";
	}
	
	//添加
	public String save(){
		customerService.save(customer);
		return "toListTrace";
	}
	
	//更改
	public String update(){
		customerService.update(customer);
		return "toListTrace";
	}
	
	//删除
	public String delete(){
		customerService.delete(customer.getId());
		return "toListTrace";
	}
	
	//修改状态
	public String changeStatus(){
		String result = "";
		if(customer != null){
			if(customer.getId() != null){
				customer = customerService.findById(customer.getId());
				if(customer.getTraceStatus() == 0){
					customer.setTraceStatus(-1);
					result = "toListTrace";
				}else{
					customer.setTraceStatus(0);
					result = "toListPool";
				}
				customerService.update(customer);
			}
		}
		return result;
	}
	
}
