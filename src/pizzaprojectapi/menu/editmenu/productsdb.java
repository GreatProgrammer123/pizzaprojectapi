package pizzaprojectapi.menu.editmenu;

import org.hibernate.Session;

import pizzaprojectapi.admin.openhours.openhours;
import pizzaprojectapi.menu.datamodels.drink;
import pizzaprojectapi.menu.datamodels.pizza;
import pizzaprojectapi.menu.datamodels.pizzatopping;
import pizzaprojectapi.menu.readmenu.menu;
import pizzaprojectapi.util.database.maindb;

public class productsdb extends maindb{

	
	public menu readmenu() {
		menu menu = new menu();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
	    menu.setPizzas(session.createQuery("from pizza p where p.active=true",pizza.class).getResultList());
		menu.setToppings(session.createQuery("from pizzatopping pt where pt.active=true and pt.notpizzaintegrated=false",pizzatopping.class).getResultList());
		menu.setNotintegraltopings(session.createQuery("from pizzatopping pt where pt.active=true and pt.notpizzaintegrated=true",pizzatopping.class).getResultList());
		menu.setDrinks(session.createQuery("from drink dk where dk.active=true",drink.class).getResultList());
		menu.setOpenhours(session.createQuery("from openhours ophs",openhours.class).getResultList());
		session.getTransaction().commit();
		return menu;		
	}
	
	
	public pizza getpizzabyid(int id) {
		pizza p = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		p = session.createQuery("from pizza p where p.pizzaid="+id,pizza.class).getSingleResult();
		session.getTransaction().commit();
		return p;		
	}
	
	public pizzatopping getpizzatopingbyid(int id) {
		pizzatopping tp = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		tp = session.createQuery("from pizzatopping tp where tp.pizzatoppingid="+id,pizzatopping.class).getSingleResult();
		session.getTransaction().commit();
		return tp;		
	}
	
	public drink getdrinkbyid(int id) {
		drink d = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		d = session.createQuery("from drink d where d.drinkid="+id,drink.class).getSingleResult();
		session.getTransaction().commit();
		return d;		
	}
}
