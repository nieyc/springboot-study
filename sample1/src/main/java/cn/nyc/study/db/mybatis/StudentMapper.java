package cn.nyc.study.db.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
	
	
	@Select("SELECT * FROM student WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO student(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
    
    @Insert("INSERT INTO student(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(Student student);
    
    @Update("UPDATE student SET age=#{age} WHERE name=#{name}")
    void update(Student student);

    @Delete("DELETE FROM student WHERE id =#{id}")
    void delete(Long id);


}
