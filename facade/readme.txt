1 该包不依赖任何第三方包
2 只是通讯时请求和返回的简单pojo
3 如果 Dto 能够直接到 infrastructure 层不重新创建 单独的和上游的通讯类(直接复用Dto) 不重新生成结构差不多的pojo
和正事的上游通讯(目前json的通讯协议是复用的，xml是有单独的pojo)

集成到groovy项目
1 在magicConf 中添加配置  	<property name="amex_frontend" value="http://localhost:8080/"/>
该配置是是和 配置前置相关的通讯接口

2 编译 facade-1.0-SNAPSHOT.jar 模块添加到 groovy项目lib下面
3 添加 在groovy.xml 中添加
	<service class="com.jucai.netpay.pay.service.AmexFacade" />
    <service class="com.jucai.netpay.pay.service.AmexAuthService" />
	<service class="com.jucai.netpay.pay.service.AmexMchService" />
 	<service class="com.jucai.netpay.pay.service.AmexDsService" />
4 业务方法写在 AmexAuthService  AmexMchService  AmexDsService
5 AmexFacade 只是简单的一个通讯接口
6 添加页面测试 amex_test.html
7 jucai8583 增加 com.gd.si.iso8583.RestInterceptor.java  //通讯相关
8 目前配置都在 application-devh.yaml中测试运行要加参数

