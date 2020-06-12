package pizzaprojectapi.clientorder.datamodels.orders;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment", schema = "pizzaprojectdb")
public class payment {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "paymentid", updatable = false, nullable = false)	
private int paymentid;
@Column(name="amount")
private double amount;
@Column(name="completed")
private boolean completed;
@Column(name="idfrompayu")
private String idfrompayu;
@Column(name="url")
private String url;
@OneToOne(mappedBy = "payment")
private anorder anorder;
public payment(int paymentid, double amount, boolean completed, String idfrompayu,
		pizzaprojectapi.clientorder.datamodels.orders.anorder anorder) {
	super();
	this.paymentid = paymentid;
	this.amount = amount;
	this.completed = completed;
	this.idfrompayu = idfrompayu;
	this.anorder = anorder;
}
public payment() {
	super();
	// TODO Auto-generated constructor stub
}
public int getPaymentid() {
	return paymentid;
}
public void setPaymentid(int paymentid) {
	this.paymentid = paymentid;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public boolean isCompleted() {
	return completed;
}
public void setCompleted(boolean completed) {
	this.completed = completed;
}
public String getIdfrompayu() {
	return idfrompayu;
}
public void setIdfrompayu(String idfrompayu) {
	this.idfrompayu = idfrompayu;
}
public anorder getAnorder() {
	return anorder;
}
public void setAnorder(anorder anorder) {
	this.anorder = anorder;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}


}
