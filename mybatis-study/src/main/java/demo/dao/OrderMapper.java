package demo.dao;

import org.apache.ibatis.annotations.Param;

import demo.entity.OrderUser;

public interface OrderMapper {
	public OrderUser selectOrderUserByOrderNumber(@Param("number") String number);
}
