package pizzaprojectapi.admin.openhours;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

import pizzaprojectapi.util.requestparser.parseprimitivetypes;

public class parsepostopenhours extends parseprimitivetypes{
	public parsepostopenhours(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	public openhours parseopenhours() {
		openhours oph = new openhours(getInt("openhoursid"), getString("day"), LocalTime.parse(getString("open")), LocalTime.parse(getString("close")), getBoolean("closed"));
		return oph;
	}

}
