package pizzaprojectapi.menu.datamodels;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="pizza", schema = "pizzaprojectdb")
public class pizza {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "pizzaid", updatable = false, nullable = false)	
private int pizzaid;
@Column(name="name")
private String name;
@Column(name="description")
private String description;
@Column(name="ingredients")
private String ingredients;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "pizzaid")
protected List<sizeprice> availablesizes;
@Column(name="active")
private boolean active;
public pizza(int pizzaid, String name, String description, String ingredients, List<sizeprice> availablesizes,boolean active) {
	super();
	this.pizzaid = pizzaid;
	this.name = name;
	this.description = description;
	this.ingredients = ingredients;
	this.availablesizes = availablesizes;
	this.active = active;
}

public pizza() {
	super();
	// TODO Auto-generated constructor stub
}


public int getPizzaid() {
	return pizzaid;
}
public void setPizzaid(int pizzaid) {
	this.pizzaid = pizzaid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getIngredients() {
	return ingredients;
}
public void setIngredients(String ingredients) {
	this.ingredients = ingredients;
}
public List<sizeprice> getAvailablesizes() {
	return availablesizes;
}
public void setAvailablesizes(List<sizeprice> availablesizes) {
	this.availablesizes = availablesizes;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

}
