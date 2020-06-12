package pizzaprojectapi.menu.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="pizzatopping", schema = "pizzaprojectdb")
public class pizzatopping {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "pizzatoppingid", updatable = false, nullable = false)	
private int pizzatoppingid;	
@Column(name="name")
private String name;
@Column(name="description")
private String description;
@Column(name="price")
protected double price;
@Column(name="notpizzaintegrated")
private boolean notpizzaintegrated;
@Column(name="active")
private boolean active;
public pizzatopping() {
	super();
	// TODO Auto-generated constructor stub
}
public pizzatopping(int pizzatoppingid, String name, String description, double price,boolean notpizzaintegrated,boolean active) {
	super();
	this.pizzatoppingid = pizzatoppingid;
	this.name = name;
	this.description = description;
	this.price = price;
	this.notpizzaintegrated = notpizzaintegrated;
	this.active = active;
}
public int getPizzatoppingid() {
	return pizzatoppingid;
}
public void setPizzatoppingid(int pizzatoppingid) {
	this.pizzatoppingid = pizzatoppingid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public boolean isNotpizzaintegrated() {
	return notpizzaintegrated;
}
public void setNotpizzaintegrated(boolean notpizzaintegrated) {
	this.notpizzaintegrated = notpizzaintegrated;
}


}
