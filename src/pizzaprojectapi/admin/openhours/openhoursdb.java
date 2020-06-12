package pizzaprojectapi.admin.openhours;

import java.util.List;

import org.hibernate.Session;

import pizzaprojectapi.util.database.maindb;

public class openhoursdb extends maindb{

	
	public List<openhours>readopenhours(){
		List<openhours> list = null;
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		list= session.createQuery("from openhours ophs",openhours.class).getResultList();
		session.getTransaction().commit();
		return list;
	}
}
