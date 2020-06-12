package pizzaprojectapi.user.loginregister.restorepassword;

import java.util.Random;

import pizzaprojectapi.user.datamodels.user;
import pizzaprojectapi.user.db.userdb;
import pizzaprojectapi.user.loginregister.util.hashpas.hashpas;

public class passwordgenerator {
private userdb udb = new userdb();
private Random random = new Random();
private hashpas hpas = new hashpas();
char[] alphabet = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m','1','2','3','4','5','6','7','8','9','0'};



public String restorepassword(String email) {
 user user = udb.getuserbyemail(email);
 if(user==null)return null;
 String npas =  generatenewpas();
 user.setPassword(hpas.hashpassword(npas));	
 udb.updatepassword(user);
return npas;
}


private String generatenewpas() {
StringBuilder sb = new StringBuilder("");
for(int i =0;i<10;i++)sb.append(alphabet[random.nextInt(alphabet.length)]);
return sb.toString();
}


}
