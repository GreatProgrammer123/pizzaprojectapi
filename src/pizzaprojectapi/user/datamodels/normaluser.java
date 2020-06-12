package pizzaprojectapi.user.datamodels;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pizzaprojectapi.clientorder.datamodels.orders.anorder;
@Entity
@Table(name="normaluser", schema = "pizzaprojectdb")
public class normaluser extends user {
@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "addressid")
private address address;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "userid")
private List<anorder>myorders;
public normaluser(int userid, String email, String password,address address) {
	super(userid, email, password);
	this.address = address;
	
}
public normaluser() {
	super();
	// TODO Auto-generated constructor stub
}
public address getAddress() {
	return address;
}
public void setAddress(address address) {
	this.address = address;
}
public List<anorder> getMyorders() {
	return myorders;
}
public void setMyorders(List<anorder> myorders) {
	this.myorders = myorders;
}


}
