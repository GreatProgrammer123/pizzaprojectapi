package pizzaprojectapi.user.authfilters;

import java.time.LocalDateTime;

import pizzaprojectapi.user.datamodels.logintoken;
import pizzaprojectapi.user.datamodels.usertypes;
import pizzaprojectapi.user.db.userdb;

public class workerauth implements permissioncheck{
	private userdb udb = new userdb();
	@Override
	public boolean haspermission(String token) {
		logintoken lt = udb.readtoken(token);
		if(lt==null)return false;
		if(Enum.valueOf(usertypes.class, lt.getUsertype())==usertypes.worker&&LocalDateTime.now().isBefore(lt.getExpirydate()))return true;
		return false;
	}

}
