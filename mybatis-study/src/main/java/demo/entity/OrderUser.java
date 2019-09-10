package demo.entity;

import java.util.Date;

public class OrderUser extends Order {
	private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date created;
    private Date updated;
    
	public String toString() {
		return "OrderUser [userName=" + userName + ", password=" + password
				+ ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", birthday=" + birthday + ", created=" + created
				+ ", updated=" + updated + "]";
	}
    
   

}
