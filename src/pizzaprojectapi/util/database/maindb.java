package pizzaprojectapi.util.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sun.jna.platform.win32.Netapi32Util.User;
import com.sun.jndi.cosnaming.IiopUrl.Address;

import io.reactivex.Scheduler.Worker;
import pizzaprojectapi.admin.openhours.openhours;
import pizzaprojectapi.clientorder.datamodels.orders.anorder;
import pizzaprojectapi.clientorder.datamodels.orders.payment;
import pizzaprojectapi.clientorder.datamodels.product.drinkorder;
import pizzaprojectapi.clientorder.datamodels.product.pizzaorder;
import pizzaprojectapi.clientorder.datamodels.product.topingorder;
import pizzaprojectapi.menu.datamodels.drink;
import pizzaprojectapi.menu.datamodels.pizza;
import pizzaprojectapi.menu.datamodels.pizzatopping;
import pizzaprojectapi.menu.datamodels.sizeprice;
import pizzaprojectapi.user.datamodels.address;
import pizzaprojectapi.user.datamodels.admin;
import pizzaprojectapi.user.datamodels.logintoken;
import pizzaprojectapi.user.datamodels.normaluser;
import pizzaprojectapi.user.datamodels.worker;



public class maindb {
	public static SessionFactory sf;
	static {
		sf =new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(pizza.class)
				.addAnnotatedClass(drink.class)
				.addAnnotatedClass(sizeprice.class)
				.addAnnotatedClass(pizzatopping.class)
				.addAnnotatedClass(pizzaorder.class)
				.addAnnotatedClass(topingorder.class)
				.addAnnotatedClass(drinkorder.class)
				.addAnnotatedClass(anorder.class)
				.addAnnotatedClass(payment.class)
				.addAnnotatedClass(address.class)
				.addAnnotatedClass(openhours.class)
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(normaluser.class)
				.addAnnotatedClass(admin.class)
				.addAnnotatedClass(worker.class)
				.addAnnotatedClass(logintoken.class)
				.buildSessionFactory();
      }
	
	public void saveobject(Object o) {
		 Session session = sf.getCurrentSession();
		session.beginTransaction();
		 session.saveOrUpdate(o);
		 session.getTransaction().commit();
	}
	
	public void execupdateordelete(String query) {
		 Session session = sf.getCurrentSession();
			session.beginTransaction();
			 session.createQuery(query).executeUpdate();
			 session.getTransaction().commit();
	}
}
