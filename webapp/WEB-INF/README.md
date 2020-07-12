# [web.xml](https://github.com/ttuseong/SpringStudy/blob/master/webapp/WEB-INF/web.xml)


스프링 이전에 필요한 셋팅을 하는 구간  
```  
<servlet>
	<servlet-name>spring</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>spring</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```
DispatcherServlet를 설정하는 구간으로 servlet 태그에서 DispatcherServlet을 사용하겠다는 의미를 가지고 있고, servlet-mapping 태그에서 DispatcherServlet의 설정 파일 위치를 지정합니다.  
url-pattern 태그에 /가 있기 때문에 같은 디렉터리에 있는 파일을 찾습니다. 그리고 두 태그 안에 있는 servlet-name 태그는 설정 파일의 이름과 일치해야하기 때문에 같은 이름을 사용합니다.  
```
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/applicationContext.xml</param-value>
</context-param>
```
ContextLoaderListener는 특정 내용을 미리 생성해주는 역할을 합니다. 그 다음에 나타다는 name과 value를 통해 이름을 지정하고, 초기화할 대상의 위치와 파일 이름을 넣습니다.
# [spring-servlet.xml](https://github.com/ttuseong/SpringStudy/blob/master/webapp/WEB-INF/spring-servlet.xml)
DispatcherServlet에 대한 설정 파일
```
<context:annotation-config />
```
 @Autowired, @Qualifier, @PostConstruct, @PreDestroy 등  나중에 활용할 어노테이션들을 사용하기 위해 사용
 >어노테이션은 @가 붙어서 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속한 형식으로 포함시킨 것이다
```
<context:component-scan  base-package="com.javaex.controller" />
```
DispatcherServlet가 개발자가 만든 controller을 쉽게 찾기 위해 controller을 모아둔 패키지 위치를 미리 지정해둠
```
<bean id="viewResolver"
	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="viewClass"
		value="org.springframework.web.servlet.view.JstlView" />
	<property name="prefix" value="/WEB-INF/views/" />
	<property name="suffix" value=".jsp" />
	<property name="order" value="1" />
</bean>
```
ViewResolver에 대한 셋팅으로 포워드를 할 때 path가 보통 "WEB-INF/.../index.jsp"가 되는데 여기서 공통된 부분을 미리 넣어주는 것으로 prefix는 공통된 부분 중 앞에 붙는 내용이고, suffix는 뒤에 붙는 내용입니다. 마지막으로 order는 View Resolver이 두개 이상일 때 우선순위를 정해주고 value가 낮을 수록 우선순위가 높습니다.([사용 예시, 55번 줄 부터 확인 ](https://github.com/ttuseong/SpringStudy/blob/master/src/main/java/com/javaex/controller/Base.java))  
```
<mvc:default-servlet-handler />
<mvc:annotation-driven />
```
CSS나 JS, 이미지 등 html이 추가적인 파일을 서버에 요청할 때 사용한 URL이 개발자가 만든 Controller에 없어서 발생하는 문제를 해결하기 위해 추가된 설정입니다.
  
<mvc:default-servlet-handler />을 통해 DefaultServletHttpRequestHandler가 생성되고 이 객체를 통해 개발자가 작성한 Controller에 없는 URL을 요청할 경우 기본 서블릿에 전달하여 처리합니다.
  
<mvc:annotation-driven />
### [applicationContext.xml](https://github.com/ttuseong/SpringStudy/blob/master/webapp/WEB-INF/applicationContext.xml)
web.xml에서 지정한 이름과 같아야하고, spring-servlet.xml이 Spring에 대한 설정 파일이면 applicationContext.xml은 Spring을 제외한 세부 controller에 대한 설정 파일입니다.
   
```
<bean id="oracleDatasource"
	class="oracle.jdbc.pool.OracleDataSource" destroy-method="close">
	<property name="URL"
		value="jdbc:oracle:thin:@localhost:1521:xe" />
	<property name="user" value="phonedb" />
	<property name="password" value="phonedb" />
	<property name="connectionCachingEnabled" value="true" />
	<qualifier value="main-db" />
</bean>
```
ContextLoaderListener를 통해 생성되는 내용 중  DataSource가 생성되는 부분입니다.
  
DataSource는 일정량의 Connection을 미리 생성시켜 저장소에 저장했다가 프로그램에서 요청이 있으면 Connection을 꺼내 제공하는 것으로 앞에서 설명한 pool에 해당됩니다.
  
property 부분을 확인하면 그동안 [JDBC](https://github.com/ttuseong/SpringStudy/blob/master/src/main/java/com/javaex/dao/PhoneDao.java)만을 사용하여 코딩했을 때 필드 부분에 해당되는 부분이 정의되어 있습니다. 
  
이 부분은 작업하는 환경에 맞게 설정을 바꾸는 부분으로 추가적으로 property에 maxActive(커넥션풀이 제공할 최대 커넥션개수), initialSize(초기에 생성될 커넥션개수) 등 추가적인 셋팅이 가능합니다.
  
[현재 설정을 적용한 모습](https://github.com/ttuseong/SpringStudy/blob/master/src/main/java/com/javaex/dao/PhoneDaoConnectionPool.java)을 확인하면 필드와 getConnection 부분이 줄어든 것을 확인할 수 있습니다.
  
또한 DAO는 미리 저장소에 저장해야하기 때문에 Repository 어노테이션을 추가하고, DataSource를 통해 자동으로 Connection을 받야하기 때문에 Autowired 어노테이션이 추가된 것을 확인할 수 있습니다. 


[컨트롤러로 이동](https://github.com/ttuseong/SpringStudy/tree/master/src/main/java/com/javaex/controller)