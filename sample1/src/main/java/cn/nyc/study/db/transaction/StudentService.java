package cn.nyc.study.db.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.nyc.study.db.mybatis.Student;
import cn.nyc.study.db.mybatis.StudentMapper;

public interface StudentService {
	
	
	
	
    void addMoreStudent();

}
