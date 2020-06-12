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
@Table(name="drink", schema = "pizzaprojectdb")
public class drink {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "drinkid", updatable = false, nullable = false)	
private int drinkid;
@Column(name="name")
private String name;
@Column(name="volume")
private int volume;
@Column(name="price")
protected double price;
@Column(name="active")
private boolean active;
public drink() {
	super();
	// TODO Auto-generated constructor stub
}
public drink(int drinkid, String name, int volume, double price,boolean active) {
	super();
	this.drinkid = drinkid;
	this.name = name;
	this.volume = volume;
	this.price = price;
	this.active = active;
}
public int getDrinkid() {
	return drinkid;
}
public void setDrinkid(int drinkid) {
	this.drinkid = drinkid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getVolume() {
	return volume;
}
public void setVolume(int volume) {
	this.volume = volume;
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

}
