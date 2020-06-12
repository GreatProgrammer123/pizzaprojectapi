package pizzaprojectapi.clientorder.datamodels.product;

import java.util.List;
import java.util.stream.Collectors;

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

import pizzaprojectapi.menu.datamodels.drink;
import pizzaprojectapi.menu.datamodels.pizza;
import pizzaprojectapi.menu.datamodels.sizeprice;
@Entity
@Table(name="pizzaorder", schema = "pizzaprojectdb")
public class pizzaorder{
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "pizzaorderid", updatable = false, nullable = false)	
private int pizzaorderid;	
@Column(name="count")	
private int count;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "pizzaid")
private List<topingorder>topings;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "sizepriceid")
private sizeprice sizep;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "pizzaid")
private pizza pizza;
@Transient
private int pizzaid;
@Transient
private double cost;

public pizzaorder() {
	super();
	// TODO Auto-generated constructor stub
}

public pizzaorder(int pizzaorderid, int count, List<topingorder> topings, sizeprice sizep,int pizzaid) {
	super();
	this.pizzaorderid = pizzaorderid;
	this.count = count;
	this.topings = topings;
	this.sizep = sizep;
	this.pizzaid = pizzaid;
}

public double calccost() {
	cost = sizep.getPrice()*count;
	for(topingorder topo:topings)cost+=topo.calccost();
	return cost;
}

public int getPizzaorderid() {
	return pizzaorderid;
}

public void setPizzaorderid(int pizzaorderid) {
	this.pizzaorderid = pizzaorderid;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public List<topingorder> getTopings() {
	return topings;
}

public void setTopings(List<topingorder> topings) {
	this.topings = topings;
}

public sizeprice getSizep() {
	return sizep;
}

public void setSizep(sizeprice sizep) {
	this.sizep = sizep;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public pizza getPizza() {
	return pizza;
}

public void setPizza(pizza pizza) {
	this.pizza = pizza;
}

public int getPizzaid() {
	return pizzaid;
}

public void setPizzaid(int pizzaid) {
	this.pizzaid = pizzaid;
}







}
