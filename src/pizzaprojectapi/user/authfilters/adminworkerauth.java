package pizzaprojectapi.user.authfilters;

import java.time.LocalDateTime;

import pizzaprojectapi.user.datamodels.logintoken;
import pizzaprojectapi.user.datamodels.usertypes;
import pizzaprojectapi.user.db.userdb;

public class adminworkerauth implements permissioncheck{
	private userdb udb = new userdb();
	@Override
	public boolean haspermission(String token) {
		logintoken lt = udb.readtoken(token);
		if(lt==null) {
		System.out.println("token nie istnieje");
			return false;
		}
		if(LocalDateTime.now().isAfter(lt.getExpirydate())){
		System.out.println("token ju¿ wygas³");
			return false;
		}
		if(Enum.valueOf(usertypes.class, lt.getUsertype())==usertypes.admin||Enum.valueOf(usertypes.class, lt.getUsertype())==usertypes.worker)return true;
		return false;
	}

}
