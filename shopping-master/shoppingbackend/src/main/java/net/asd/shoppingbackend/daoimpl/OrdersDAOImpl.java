package net.asd.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.asd.shoppingbackend.dao.OrdersDAO;
import net.asd.shoppingbackend.dto.Orders;



@Repository("ordersDAO")
@Transactional
public class OrdersDAOImpl implements OrdersDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public Orders get(int orderId) {
		try {
			return sessionFactory.getCurrentSession().get(Orders.class, Integer.valueOf(orderId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Orders> list() {
		//return sessionFactory.getCurrentSession().createQuery("FROM Order", Order.class).getResultList();
		String selectActiveOrder = "FROM Orders WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveOrder);
		// parameter name is active
		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public boolean add(Orders order) {
		try {
			sessionFactory.getCurrentSession().persist(order);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Orders order) {
		try {
			sessionFactory.getCurrentSession().update(order);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Orders order) {
		try {
			order.setActive(false);
			// call update method
			return this.update(order);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Orders> listActiveProducts() {
		String selectActiveOrders = "FROM Orders WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveOrders, Orders.class)
				.setParameter("active", true).getResultList();
	}

}
