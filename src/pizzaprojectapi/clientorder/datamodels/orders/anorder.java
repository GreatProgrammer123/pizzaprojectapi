package pizzaprojectapi.clientorder.datamodels.orders;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import pizzaprojectapi.clientorder.datamodels.product.drinkorder;
import pizzaprojectapi.clientorder.datamodels.product.pizzaorder;
import pizzaprojectapi.clientorder.datamodels.product.topingorder;
import pizzaprojectapi.user.datamodels.address;

@Entity
@Table(name="anorder", schema = "pizzaprojectdb")
public class anorder {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "orderid", updatable = false, nullable = false)	
private int orderid;
//1 oczekuj¹ce 2 w realizacji 3 zrealizowane
@Column(name="state")
private int state;
@Column(name="date")
private LocalDateTime date;
@Column(name="updatedate")
private LocalDateTime updatedate;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "orderid")
private List<pizzaorder>pizzas;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "orderid")
private List<topingorder>othertopings;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "orderid")
private List<drinkorder>drinks;
@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "addressid")
private address deliveryaddres;
@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinColumn(name = "paymentid")
private payment payment;
@Column(name="userid")
private int userid;
@Column(name="eathere")
private boolean eathere;
@Transient
private double cost;
public anorder(int orderid, int state, LocalDateTime date, LocalDateTime updatedate,int userid,boolean eathere) {
	super();
	this.orderid = orderid;
	this.state = state;
	this.date = date;
	this.updatedate = updatedate;
	this.userid = userid;
	this.eathere=eathere;
}
public anorder() {
	super();
	// TODO Auto-generated constructor stub
}

public double calccost() {
	cost = 0;
	for(pizzaorder pizza:pizzas)cost+=pizza.calccost();
	for(drinkorder drink:drinks)cost+=drink.calccost();
	for(topingorder pt:othertopings)cost+=pt.calccost();
	return cost;
	
}


public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}
public LocalDateTime getUpdatedate() {
	return updatedate;
}
public void setUpdatedate(LocalDateTime updatedate) {
	this.updatedate = updatedate;
}
public List<pizzaorder> getPizzas() {
	return pizzas;
}
public void setPizzas(List<pizzaorder> pizzas) {
	this.pizzas = pizzas;
}
public List<drinkorder> getDrinks() {
	return drinks;
}
public void setDrinks(List<drinkorder> drinks) {
	this.drinks = drinks;
}
public address getDeliveryaddres() {
	return deliveryaddres;
}
public void setDeliveryaddres(address deliveryaddres) {
	this.deliveryaddres = deliveryaddres;
}
public payment getPayment() {
	return payment;
}
public void setPayment(payment payment) {
	this.payment = payment;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}

public boolean isEathere() {
	return eathere;
}
public void setEathere(boolean eathere) {
	this.eathere = eathere;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public List<topingorder> getOthertopings() {
	return othertopings;
}
public void setOthertopings(List<topingorder> othertopings) {
	this.othertopings = othertopings;
}






}
