package net.asd.shoppingbackend.dao;

import java.util.List;


import net.asd.shoppingbackend.dto.Orders;


public interface OrdersDAO {

	Orders get(int orderId);
	List<Orders> list();
	boolean add(Orders order);
	boolean update(Orders order);
	boolean delete(Orders order);
	
	//business methods
	List<Orders> listActiveProducts();
	
}
