package cn.nyc.study.db.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.nyc.study.db.mybatis.Student;
import cn.nyc.study.db.mybatis.StudentMapper;

//@Component
@Service(value = "goodStudentService")
public class GoodStudentServiceImpl implements StudentService{
	
	private Logger logger = LogManager.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentMapper studentMapper;
	

	public void addMoreStudent() {
		// TODO Auto-generated method stub
		if(logger.isDebugEnabled()) {
			logger.debug("this is my test");
		}
		
		studentMapper.insertByUser(new Student("AAA", 10));
		studentMapper.insertByUser(new Student("AAB", 11));
		studentMapper.insertByUser(new Student("AAC", 11));
		
	}

}
