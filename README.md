# Java EE框架程序——Fisher

## 这仅仅是一个简单的Java EE框架程序。程序模拟了一个简单的工作流系统，系统包含两个角色：

### 1. 普通员工：

· 打卡：程序自动在7点和12点为员工插入旷工状态，并会自动显示上班打卡/下班打卡按钮。当员工在9点之前进行上班打卡时，程序会将员工状态更改为正常，9到11点之间程序会将员工状态更改为迟到，11点之后程序不作更改，即员工状态为旷工；当员工在17点之后进行下班打卡时，程序会将员工状态更改为正常，16到17点之间程序会将员工状态更改为早退，其他时间程序不作更改，即员工状态为旷工。

· 查看打卡异动：员工可以查看自己最近七天的非正常打卡，包括打卡日期，异动名称，打卡时间，选择。如有异议，员工可以对特定非正常打卡状态申请改变。填写异动申请时，可以选择申请类别，填写申请理由，提交成功后，即可等待BOSS的审核。

· 修改密码：验证现有密码成功时可以更改为新密码。

· 上传文件：支持添加文件队列上传，可以单独取消特定文件，也可以取消全部上传，实现了每个文件的上传进度条显示。

· 查看文件：可以查看全部文件，实现了下载及删除功能。

· 退出系统：退出登录状态。

### 2. BOSS：

· 查看打卡：可以查看全部员工最近七天的非正常打卡情况，包括员工用户名、姓名、打卡日期、异动名称、打卡时间。

· 签核申请：可以对员工提出的打卡异动申请进行审核，包括员工用户名、姓名、缺勤类型、申请类型、理由、操作，选择通过即更改员工打卡状态，选择拒绝则不改变。

· 管理成员：可以查看所有员工的用户名、姓名、密码、电话，并可以删除特定成员。

· 修改密码：验证现有密码成功时可以更改为新密码。

· 上传文件：支持添加文件队列上传，可以单独取消特定文件，也可以取消全部上传，实现了每个文件的上传进度条显示。

· 查看文件：可以查看全部文件，实现了下载及删除功能。

· 退出系统：退出登录状态。

## 应用使用轻量级Java EE架构，使用的技术包括：Struts 2.3、Spring 4.0、Hibernate 4.3、Quartz 2.2、Jquery·Uploadify。

### JSP：

本系统使用JSP作为表现层，负责收集用户请求数据，以及业务数据的表示。

### MVC框架：

使用Struts2.3作为MVC框架，负责控制所有请求的处理和转发，并使用了基于Struts2.3拦截器的权限控制，整个应用有普通员工和BOSS两种权限检查。

### Spring框架：

Spring框架是系统的核心部分，Spring提供的IoC容器是业务逻辑组件和DAO组件的工厂，它负责生成及管理这些实例。借助于Spring的依赖注入，各组件以松耦合的方式组合在一起。应用事务采用Spring的声明式事务框架，使业务逻辑组件可以专注于业务的实现，简化开发，同时降低了不同事务策略的切换代价。

### Hibernate：

Hibernate作为O/R Mapping框架使用，简化了数据库的访问，在JDBC层提供了更好的封装，并且程序利用了Hibernate的分页查询功能。

### Quartz：

程序利用Quartz框架进行自动考勤，框架使用Cron表达式触发来调度作业，从而完成任务自动化。

### Jquery·Uploadify：

程序利用Jquery·Uploadify框架实现文件的批量上传及进度条显示。
