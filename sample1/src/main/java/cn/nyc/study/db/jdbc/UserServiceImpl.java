package cn.nyc.study.db.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void create(String name, int age) {
        jdbcTemplate.update("insert into user(name, age) values(?, ?)", name, age);
	}

    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where name = ?", name);
    }

    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user");
    }

}
