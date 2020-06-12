package pizzaprojectapi.menu.readmenu;

import java.util.List;

import pizzaprojectapi.menu.datamodels.drink;
import pizzaprojectapi.menu.datamodels.pizza;
import pizzaprojectapi.menu.datamodels.pizzatopping;

public class menu {
private List<pizza>pizzas;
private List<pizzatopping>toppings;
private List<drink>drinks;
private List<pizzaprojectapi.admin.openhours.openhours>openhours;
private List<pizzatopping>notintegraltopings;
public menu() {
	super();
	// TODO Auto-generated constructor stub
}
public List<pizza> getPizzas() {
	return pizzas;
}
public void setPizzas(List<pizza> pizzas) {
	this.pizzas = pizzas;
}
public List<pizzatopping> getToppings() {
	return toppings;
}
public void setToppings(List<pizzatopping> toppings) {
	this.toppings = toppings;
}
public List<drink> getDrinks() {
	return drinks;
}
public void setDrinks(List<drink> drinks) {
	this.drinks = drinks;
}
public List<pizzaprojectapi.admin.openhours.openhours> getOpenhours() {
	return openhours;
}
public void setOpenhours(List<pizzaprojectapi.admin.openhours.openhours> openhours) {
	this.openhours = openhours;
}
public List<pizzatopping> getNotintegraltopings() {
	return notintegraltopings;
}
public void setNotintegraltopings(List<pizzatopping> notintegraltopings) {
	this.notintegraltopings = notintegraltopings;
}

}
