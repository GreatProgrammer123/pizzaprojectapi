package pizzaprojectapi.user.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="worker", schema = "pizzaprojectdb")
public class worker extends user {
@Column(name="name")	
private String name;
@Column(name="surname")	
private String surname;
public worker(int userid, String email, String password, String name, String surname) {
	super(userid, email, password);
	this.name = name;
	this.surname = surname;
}
public worker() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}

}
