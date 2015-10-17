create database crm_sys default character set utf8;
use crm_sys;

-- 创建dept表
create table dept(
	id int primary key auto_increment,
	deptName varchar(20),
	remarks varchar(20)
	);

insert into dept (deptName, remarks) values ('技术部', '技术是有利生产力');

-- 创建营销人员表
CREATE TABLE employee(
	  id INT PRIMARY KEY AUTO_INCREMENT,
	  empName VARCHAR(20),
	  pwd VARCHAR(20),
	  sex CHAR(1),
	  phone VARCHAR(20),
	  birth DATE,
	  email VARCHAR(50),
	  loginTime DATETIME,
	  lastLoginTime DATETIME,
	  loginIp VARCHAR(20),
	  lastLoginIp VARCHAR(20),
	  dept_id INT,
	  CONSTRAINT fk_emp_dept FOREIGN KEY (dept_id) REFERENCES dept(id)
);


-- 客户表
CREATE TABLE customer(
	id INT PRIMARY KEY AUTO_INCREMENT,		-- 编号
	NAME VARCHAR(20),						-- 姓名
	sex CHAR(1),							-- 性别
	telphone VARCHAR(20),					-- 电话
	address VARCHAR(200),					-- 地址
	birth DATE,								-- 生日
	email VARCHAR(50),						-- 邮箱
	trace_status INT DEFAULT 0				-- 客户状态（0跟进状态，-1资源池）
	);


-- 客户跟进
create table traceHistory(
	id int primary key auto_increment,	-- 编号
	customer_id int,					-- 外键，跟进的客户编号
	employee_id int,					-- 外键，跟进的公司员工，从当前登录用户取
	traceTime datetime,					-- 跟进时间
	traceMethod varchar(50),			-- 跟进方式
	content varchar(200),				-- 跟进内容
	result int,							-- 跟进效果，“优良差”：“123”
	constraint fk_traceHistory_customer foreign key (customer_id) references customer(id),
	constraint fk_traceHistory_employee foreign key (employee_id) references employee(id) 
	);


-- 客户移交记录
create table transferHistory(
	id int primary key auto_increment,	-- 编号
	customer_id int,					-- 外键，移交的客户
	employee_old int,					-- 外键，移交前的员工
	employee_new int,					-- 外键，移交后的员工
	reason varchar(500),				-- 移交原因
	transferTime datetime,				-- 移交时间
	constraint fk_transferHistory_customer foreign key (customer_id) references customer(id),
	constraint fk_transferHistory_employee_old foreign key (employee_old) references employee(id),
	constraint fk_transferHistory_employee_new foreign key (employee_new) references employee(id)
	);

	