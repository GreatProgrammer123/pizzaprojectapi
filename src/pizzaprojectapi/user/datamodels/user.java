package pizzaprojectapi.user.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="user", schema = "pizzaprojectdb")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class user {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "userid", updatable = false, nullable = false)	
private int userid;
@Column(name="email")
private String email;
@Column(name="password")
private String password;
public user(int userid, String email, String password) {
	super();
	this.userid = userid;
	this.email = email;
	this.password = password;
}
public user() {
	super();
	// TODO Auto-generated constructor stub
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
