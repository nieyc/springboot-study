package cn.nyc.study.db.mybatis;

public class Student {
	
	public Student(String name,Integer age) {
		this.name=name;
		this.age=age;
	}
	
	private Long id;
	private String name;
	private Integer age;
	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}
