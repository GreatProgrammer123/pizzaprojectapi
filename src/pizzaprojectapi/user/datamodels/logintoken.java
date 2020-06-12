package pizzaprojectapi.user.datamodels;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logintoken", schema = "pizzaprojectdb")
public class logintoken {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "logintokenid", updatable = false, nullable = false)	
private int logintokenid;
@Column(name="token")
private String token;
@Column(name="usertype")
private String usertype;
@Column(name="expirytime")
private LocalDateTime expirydate;
@Column(name="userid")
private int userid;
public logintoken(int logintokenid, String token, String usertype, LocalDateTime expirydate,int userid) {
	super();
	this.logintokenid = logintokenid;
	this.token = token;
	this.usertype = usertype;
	this.expirydate = expirydate;
	this.userid = userid;
}
public logintoken() {
	super();
	// TODO Auto-generated constructor stub
}
public int getLogintokenid() {
	return logintokenid;
}
public void setLogintokenid(int logintokenid) {
	this.logintokenid = logintokenid;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}
public LocalDateTime getExpirydate() {
	return expirydate;
}
public void setExpirydate(LocalDateTime expirydate) {
	this.expirydate = expirydate;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public void generatetoken() {
	StringBuilder tokensb = new StringBuilder("");
	Random rand = new Random();
	for(int i=0;i<10;i++)tokensb.append(rand.nextInt(10));
	token = tokensb.toString();
	
}



}
