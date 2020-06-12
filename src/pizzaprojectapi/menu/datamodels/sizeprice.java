package pizzaprojectapi.menu.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sizeprice", schema = "pizzaprojectdb")
public class sizeprice {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "sizepriceid", updatable = false, nullable = false)	
private int sizepriceid;
@Column(name="name")
private String name;
@Column(name="size")
private int size;
@Column(name="price")
private double price;


public sizeprice(int sizepriceid, String name, int size, double price) {
	super();
	this.sizepriceid = sizepriceid;
	this.name = name;
	this.size = size;
	this.price = price;
}
public sizeprice() {
	super();
	// TODO Auto-generated constructor stub
}
public int getSizepriceid() {
	return sizepriceid;
}
public void setSizepriceid(int sizepriceid) {
	this.sizepriceid = sizepriceid;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
