package pizzaprojectapi.user.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address", schema = "pizzaprojectdb")
public class address {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "addressid", updatable = false, nullable = false)	
private int addressid;
@Column(name="street")
private String street;
@Column(name="postcode")
private String postcode;
@Column(name="city")
private String city;
public address(int addressid, String street, String postcode, String city) {
	super();
	this.addressid = addressid;
	this.street = street;
	this.postcode = postcode;
	this.city = city;
}
public address() {
	super();
	// TODO Auto-generated constructor stub
}
public int getAddressid() {
	return addressid;
}
public void setAddressid(int addressid) {
	this.addressid = addressid;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getPostcode() {
	return postcode;
}
public void setPostcode(String postcode) {
	this.postcode = postcode;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}


}
