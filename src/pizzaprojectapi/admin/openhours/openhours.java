package pizzaprojectapi.admin.openhours;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="openhours", schema = "pizzaprojectdb")
public class openhours {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "openhoursid", updatable = false, nullable = false)	
private int openhoursid;
@Column(name="day")
private String day;
@Column(name="open")
private LocalTime open;
@Column(name="close")
private LocalTime close;
@Column(name="closed")
private boolean closed;
public openhours(int openhoursid, String day, LocalTime open, LocalTime close, boolean closed) {
	super();
	this.openhoursid = openhoursid;
	this.day = day;
	this.open = open;
	this.close = close;
	this.closed = closed;
}
public openhours() {
	super();
	// TODO Auto-generated constructor stub
}
public int getOpenhoursid() {
	return openhoursid;
}
public void setOpenhoursid(int openhoursid) {
	this.openhoursid = openhoursid;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public LocalTime getOpen() {
	return open;
}
public void setOpen(LocalTime open) {
	this.open = open;
}
public LocalTime getClose() {
	return close;
}
public void setClose(LocalTime close) {
	this.close = close;
}
public boolean isClosed() {
	return closed;
}
public void setClosed(boolean closed) {
	this.closed = closed;
}

}
