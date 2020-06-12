package pizzaprojectapi.user.db;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.user.datamodels.address;
import pizzaprojectapi.user.datamodels.admin;
import pizzaprojectapi.user.datamodels.logintoken;
import pizzaprojectapi.user.datamodels.normaluser;
import pizzaprojectapi.user.datamodels.user;
import pizzaprojectapi.user.datamodels.usertypes;
import pizzaprojectapi.user.datamodels.worker;
import pizzaprojectapi.util.database.maindb;

public class userdb extends maindb{

	
	public boolean userexists(String email) {
		user user = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		user = session.createQuery("from user use where use.email='"+email+"'",user.class).getSingleResult();
		}catch(NoResultException e) {
			
		}finally {
			session.getTransaction().commit();
		}
		if(user!=null) return true;		
		return false;
	}
	
	
	public user getuserbyemail(String email) {
		user user = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		user = session.createQuery("from user use where use.email='"+email+"'",user.class).getSingleResult();
		}catch(NoResultException e) {
			
		}finally {
			session.getTransaction().commit();
		}		
		return user;
	}
	
	public normaluser loginnormaluser(String email,String password) {
		System.out.println("login normaluser  " + email + "  " + password);
		normaluser user = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		user = session.createQuery("from normaluser u where u.email='"+email+"' and u.password='"+password+"'",normaluser.class).getSingleResult();
		Hibernate.initialize(user.getAddress());
		user.setAddress((address) Hibernate.unproxy(user.getAddress()));
		}catch(NoResultException e) {
		
		}finally {
			session.getTransaction().commit();
		}
		return user;		
	}
	
	public normaluser readuserbyid(int id) {		
		normaluser user = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		user = session.createQuery("from normaluser u where u.userid="+id,normaluser.class).getSingleResult();
		Hibernate.initialize(user.getAddress());
		user.setAddress((address) Hibernate.unproxy(user.getAddress()));
		}catch(NoResultException e) {
		
		}finally {
			session.getTransaction().commit();
		}
		return user;
	}
	
	
	
	public worker loginworker(String email,String password) {
		worker user = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		user = session.createQuery("from worker use where use.email='"+email+"' and use.password='"+password+"'",worker.class).getSingleResult();
		}catch(NoResultException e) {
		
		}finally {
			session.getTransaction().commit();
		}
		return user;	
	}
	
	
	
	public admin loginadmin(String email,String password) {
		admin user = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		user = session.createQuery("from admin use where use.email='"+email+"' and use.password='"+password+"'",admin.class).getSingleResult();
		}catch(NoResultException e) {
		
		}finally {
			session.getTransaction().commit();
		}
		return user;	
	}
	
	public void savenormaluser(normaluser user) {
		 Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(user.getAddress());
			session.saveOrUpdate(user);
			session.getTransaction().commit();
	}
	
	
	public void savelogintoken(logintoken lt) {
		 Session session = sf.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete logintoken lt where lt.userid="+lt.getUserid()).executeUpdate();
			session.saveOrUpdate(lt);
			session.getTransaction().commit();
	}
	
	public logintoken readtoken(String token) {
		logintoken lt = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
		lt = session.createQuery("from logintoken lt where lt.token='"+token+"'",logintoken.class).getSingleResult();
		}catch(NoResultException e) {
		
		}finally {
			session.getTransaction().commit();
		}
		return lt;			
	}
	
	
	public void updatepassword(user user) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.createQuery("update user use set use.password='"+user.getPassword()+"' where use.userid="+user.getUserid()).executeUpdate();
		session.getTransaction().commit();
	}
	
	
	
}
