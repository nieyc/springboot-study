package cn.nyc.study.db.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;



import cn.nyc.study.db.mybatis.Student;
import cn.nyc.study.db.mybatis.StudentMapper;

//@Component
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

	private Logger logger = LogManager.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional// 默认事物级别，如需其他级别，可以指定
	//@Transactional(isolation = Isolation.DEFAULT)
	public void addMoreStudent() {
		logger.info("this is my test");
		studentMapper.insertByUser(new Student("AAA", 10));
		studentMapper.insertByUser(new Student("AAB", 11));
		//name 长度数据库为5，此处故意设置超过，测试事物
		studentMapper.insertByUser(new Student("AABCCCC", 11));
		
	}

}
