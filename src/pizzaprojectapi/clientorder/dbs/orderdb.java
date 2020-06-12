package pizzaprojectapi.clientorder.dbs;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.clientorder.datamodels.orders.payment;
import pizzaprojectapi.user.datamodels.address;
import pizzaprojectapi.util.database.maindb;

public class orderdb extends maindb{

	public void saveorder(anorder order) {
		System.out.println("saving order");
		order.getPizzas().forEach(p->System.out.println("size " + p.getSizep().getName()));
		
		
		 Session session = sf.getCurrentSession();
			session.beginTransaction();
		    order.getPizzas().forEach(px->{
		    	session.saveOrUpdate(px.getSizep());
		    });
			session.saveOrUpdate(order.getDeliveryaddres());
			session.saveOrUpdate(order.getPayment());
			 session.saveOrUpdate(order);
			 session.getTransaction().commit();
	}
	
	
	public List<anorder>readorders(String query){
		List<anorder> orders = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		orders = session.createQuery(query,anorder.class).getResultList();
		orders.forEach(ord->{
			Hibernate.initialize(ord.getPizzas());
			
		});
		session.getTransaction().commit();
		return orders;
	}
	
	public anorder getorderbyid(int id) {
		anorder order = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		order = session.createQuery("from anorder ord where ord.orderid="+id,anorder.class).getSingleResult();
		Hibernate.initialize(order.getPizzas());
		order.getPizzas().forEach(pz->{
			Hibernate.initialize(pz.getTopings());
		});
		Hibernate.initialize(order.getOthertopings());
		Hibernate.initialize(order.getDrinks());
		Hibernate.initialize(order.getDeliveryaddres());
		order.setDeliveryaddres((address) Hibernate.unproxy(order.getDeliveryaddres()));
		Hibernate.initialize(order.getPayment());
		order.setPayment((payment) Hibernate.unproxy(order.getPayment()));
		}catch(NoResultException e) {
			
		}finally {
			session.getTransaction().commit();
		}
		return order;
	}
	
	public void updateorderstate(int newstate,String updatedate,int id) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.createQuery("update anorder ord set ord.state="+newstate+", ord.updatedate='"+updatedate+"' where ord.orderid="+id).executeUpdate();
		session.getTransaction().commit();
	}
	
	
	public payment getpaymentbypayuid(String id) {
		payment p = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		session.createQuery("from payment pay where pay.idfrompayu='"+id+"'",payment.class).getSingleResult();
		}catch(NoResultException e) {
			
		}finally {
			session.getTransaction().commit();
		}
		return p;
	}
	
	
	
	
}
