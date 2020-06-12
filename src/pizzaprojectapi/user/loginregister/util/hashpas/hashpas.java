package pizzaprojectapi.user.loginregister.util.hashpas;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class hashpas {
	private final String salt = "karasiejedzoguwno";
	public String hashpassword(String password) {	
	SecretKey key;
	 if (password == null || password.length() == 0)
         throw new IllegalArgumentException("Empty passwords are not supported.");
     SecretKeyFactory f;
	try {
		f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	} catch (NoSuchAlgorithmException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
        return null;  	
	}
   
	try {
		key = f.generateSecret(new PBEKeySpec(
		     password.toCharArray(), salt.getBytes(), 10000, 100));
	} catch (InvalidKeySpecException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
     return Base64.encodeBase64String(key.getEncoded());
	}
}
