package pizzaprojectapi.user.authfilters;

public class authfactory {

	
	public permissioncheck permissonbuilder(String url) {
		url =  geturl(url);
		System.out.println("url   " + url);
		permissioncheck pcheck = null;
		switch(url) {
		case "deleteopenhours":
			return new adminauth();
		case "saveopenhours":
			return new adminauth();
		case "addnewdrink":
			return new adminauth();
		case "addnewpizza":
			return new adminauth();
		case "addnewpizzatoping":
			return new adminauth();
		case "deletepizza":
			return new adminauth();
		case "deletetoping":
			return new adminauth();
		case "readorderbyid":
		//	return new adminworkerauth();
			break;
		case "updateorderstate":
			return new adminworkerauth();
		case "readorders":
			return new adminworkerauth();
		case "readordersforadmin":
			return new adminauth();
		}		
		return pcheck;
	}
	
	
	private String geturl(String url) {
		String parts[] = url.split("/");
		return parts[parts.length-1];
	}
}
