package demo.entity;

import java.util.Date;

public class Order {
	private Integer id;
    private Long userId;
    private String orderNumber;
    private Date created;
    private Date updated;
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "id:" + id + "userId:" + userId + "orderNumber:" + orderNumber;
    }
}
