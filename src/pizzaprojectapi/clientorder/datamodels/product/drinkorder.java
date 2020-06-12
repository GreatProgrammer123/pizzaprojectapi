package pizzaprojectapi.clientorder.datamodels.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import pizzaprojectapi.menu.datamodels.drink;
import pizzaprojectapi.user.datamodels.address;
@Entity
@Table(name="drinkorder", schema = "pizzaprojectdb")
public class drinkorder{
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "drinkorderid", updatable = false, nullable = false)	
private int drinkorderid;
@Column(name="count")	
private int count;
@Column(name="price")
private double price;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "drinkid")
private drink drink;
@Transient
private int drinkid;
@Transient
private double cost;

public drinkorder() {
	super();
	// TODO Auto-generated constructor stub
}

public drinkorder(int drinkorderid, int count, int drinkid, double price) {
	super();
	this.drinkorderid = drinkorderid;
	this.count = count;
	this.drinkid = drinkid;
	this.price = price;
}



public double calccost() {
	cost = count*price;
	return cost;
}
public int getDrinkorderid() {
	return drinkorderid;
}
public void setDrinkorderid(int drinkorderid) {
	this.drinkorderid = drinkorderid;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getDrinkid() {
	return drinkid;
}
public void setDrinkid(int drinkid) {
	this.drinkid = drinkid;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public drink getDrink() {
	return drink;
}
public void setDrink(drink drink) {
	this.drink = drink;
}





}
