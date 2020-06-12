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

import pizzaprojectapi.menu.datamodels.pizzatopping;
@Entity
@Table(name="topingorder", schema = "pizzaprojectdb")
public class topingorder{
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "topingorderid", updatable = false, nullable = false)	
private int topingorderid;	
@Column(name="count")	
private int count;
@Column(name="price")	
private double price;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "pizzatoppingid")
private pizzatopping toping;
@Transient
private int pizzatoppingid;
@Transient
private double cost;
public topingorder() {
	super();
	// TODO Auto-generated constructor stub
}


public topingorder(int topingorderid,int count, double price, int pizzatoppingid) {
	super();
	this.topingorderid=topingorderid;
	this.count = count;
	this.price = price;
	this.pizzatoppingid = pizzatoppingid;
}


public double calccost() {
	cost = price*count;
	return cost;
}


public int getCount() {
	return count;
}


public int getTopingorderid() {
	return topingorderid;
}


public void setTopingorderid(int topingorderid) {
	this.topingorderid = topingorderid;
}


public void setCount(int count) {
	this.count = count;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public pizzatopping getToping() {
	return toping;
}


public void setToping(pizzatopping toping) {
	this.toping = toping;
}


public int getPizzatoppingid() {
	return pizzatoppingid;
}


public void setPizzatoppingid(int pizzatoppingid) {
	this.pizzatoppingid = pizzatoppingid;
}


public double getCost() {
	return cost;
}


public void setCost(double cost) {
	this.cost = cost;
}



}
