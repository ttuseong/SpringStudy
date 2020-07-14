# mapper
mapper 디렉토리에 있는 xml 파일들은 sql에 대한 내용이 들어가 있습니다.
  
```
<!DOCTYPE  mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
```
사용하기 위해 해당 부분을 추가합니다.
```
<mapper  namespace="접근할 때 사용할 이름">
	...
</mapper>
```
sql에서 접근하기 위해서 크게 mapper 태그로 감싸고 namespace를 통해 어떤 mapper에 접근할 지 결정됩니다.
  
- sql 사용 예시
```
<select id="getPerson" parameterType="int" resultType="com.javaex.vo.PersonVo">
	<![CDATA[
		select person_id personID,
		name,
		hp,
		company
		from person
		where person_id = #{no}
	]]>
</select>
``` 
1. id 값에는 mapper에 있는 sql 중 어떤 sql을 사용할 지 선택해주는 역할을 합니다.  
2. parameterType은 sql에 전달할 값으로 현재 int형을 사용하고 있고 값이 하나이기 때문에 #{}안에 이름을 지정해주면 됩니다.  
3. resultType은 결과 값을 저장할 데이터 타입입니다. 예시처럼 클래스로 저장할 경우 클래스의 패키지까지 함께 작성합니다.  
4. CDATA부분은 SQL을 작성할 때 where 절에 괄호(<, >)가 사용될 수 있고, 실제로 사용될 경우 해석하는데 문제가 발생할 수 있기 때문에 CDATA을 통해 SQL 부분을 표시해 줍니다.
5. 코드를 보면 select문 안에 person_id를 personID로 컬럼 명을 변경해서 넘겨주는데 그 이유는 저장할 데이터 타입인 PersonVo에 있는 필드에 personID로 이름이 정해졌기 때문이고, 클래스로 저장할 경우 클래스에 있는 필드에 있는 변수 이름과 일치해야 값을 정상적으로 저장할 수 있다.
```
<resultMap id="resultMapPersonVo" type="com.javaex.vo.PersonVo" >
	<result column="person_id" property="personId" />
	<result column="name" property="name" />
	<result column="hp" property="hp" />
	<result column="company" property="company" />
</resultMap>
<select id="getList" resultMap="resultMapPersonVo" >
	<![CDATA[
		select person_id,
		name,
		hp,
		company
		from person
		order by person_id desc
	]]>
</select>
```
이전 예시에서 클래스로 저장할 경우 클래스 필드명에 있는 이름과 일치해야 저장이 가능하다고 했는데 그러한 상황이 많은 경우 다음 예시와 같이 resultMap으로 미리 이름을 지정할 수 있습니다.
```
<select id="aliasTest" resultType="PersonVo">
	<![CDATA[
		select 
			person_id personId,
			name,
			hp,
			company
		from person
		order by person_id desc
	]]>
</select>
```
[앞에 설정 파일](https://github.com/ttuseong/SpringStudy/blob/master/src/main/resources/mybatis/configuration.xml)에서 typeAlias를 설정했다면, 클래스를 사용할 때 패키지 이름을 생략할 수 있습니다.
