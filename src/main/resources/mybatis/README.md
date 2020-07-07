# [configuration.xml](https://github.com/ttuseong/SpringStudy/blob/master/src/main/resources/mybatis/configuration.xml)
SqlSessionFactory에서 SQL을 사용하기 위해 필요한 정보들이 들어간 파일로 SqlSessionFactory에서 설정한 위치와 파일 이름이 같아야 합니다.
  
```
<mappers>
	<mapper resource="mybatis/mappers/phonebook.xml" />
</mappers>
```
사용될 SQL에 대한 내용이 정리된 파일과 연결하는 내용으로 현재 하나만 연결했지만, mapper을 통해 더 많은 파일을 연결할 수 있습니다.

[phonebook.xml 확인하기](https://github.com/ttuseong/SpringStudy/blob/master/src/main/resources/mybatis/mappers/phonebook.xml)