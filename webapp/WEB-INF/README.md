# web.xml
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
  
# spring-servlet.xml
DispatcherServlet에 대한 설정 파일
```
<context:annotation-config />
```
 @Autowired, @Qualifier, @PostConstruct, @PreDestroy 등  나중에 활용할 어노테이션들을 사용하기 위해 사용
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
ViewResolver에 대한 셋팅으로 포워드를 할 때 path가 보통 "WEB-INF/.../index.jsp"가 되는데 여기서 공통된 부분을 미리 넣어주는 것으로 prefix는 공통된 부분 중 앞에 붙는 내용이고, suffix는 뒤에 붙는 내용입니다. 마지막으로 order는 View Resolver이 두개 이상일 때 우선순위를 정해주고 value가 낮을 수록 우선순위가 높습니다.