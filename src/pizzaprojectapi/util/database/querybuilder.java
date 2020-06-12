package pizzaprojectapi.util.database;

import java.time.LocalDateTime;



public class querybuilder {
private StringBuilder query;
private String prefix;


   private void newquery() {
	   query= new StringBuilder("");
	   query.append(" ");
   }

   public querybuilder setprefix(String prefix) {
	   this.prefix = prefix;
	   return this;
   }


   public querybuilder addgetquerystart(String objname) {
	newquery();
    query.append("from ").append(objname).append(" ").append(prefix).append(" where ");
	return this;
   }

   public querybuilder adddeletequerystart(String objname) {
		newquery();
	   query.append("delete ").append(objname).append(" ").append(prefix).append(" where ");
	   return this;
   }
   
   public querybuilder addupdatequerystart(String objname) {
		newquery();
	   query.append("update ").append(objname).append(" ").append(prefix).append(" set ");
	   return this;
  }
   
  public querybuilder addwhere() {
	  query.append(" where ");
	  return this;
  }
   
   
   public querybuilder removelastand() {
		if(query.toString().endsWith(" and "))query.delete(query.length()-5,query.length());
		if(query.toString().endsWith(" where "))query.delete(query.length()-7,query.length());
		return this;
    }

	public querybuilder addnumequlksto(String name,double val) {
		query.append(prefix).append(".").append(name).append("=").append(val).append(" and ");
		return this;
	}
	
	public querybuilder addnumbiggerthan(String name,double val) {
		query.append(prefix).append(".").append(name).append(">").append(val).append(" and ");
		return this;
	}
	
	public querybuilder addnumsmallerthan(String name,double val) {
		query.append(prefix).append(".").append(name).append("<").append(val).append(" and ");
		return this;
	}
	
	public querybuilder addstringwualsto(String name,String val) {
		query.append(prefix).append(".").append(name).append("='").append(val).append("'").append(" and ");
		return this;
	}
	
	public querybuilder addbooleanequlksto(String name,boolean val) {
		query.append(prefix).append(".").append(name).append("=").append(val).append(" and ");
		return this;
	}
	
	public querybuilder adddatelaterthan(String name,String val) {
		
		query.append(prefix).append(".").append(name).append(">= '").append(val).append("' and ");
		return this;
	}
	
	public querybuilder adddateearlierthan(String name,String val) {
		query.append(prefix).append(".").append(name).append("<= '").append(val).append("' and ");
		return this;
	}
	
   public querybuilder openquerytorealtion(String name) {
	   query.append(" exists (from ")
		.append(name).append(" ").append(prefix).append(" where ");	
		return this;
   }
   
   public querybuilder closequerytorealtion() {
	   	query.append(")").append(" and ");
		return this;
   }
   
   public querybuilder addspecialquery(String otherquery) {
	   query.append(" ").append(otherquery).append(" and ");
	   return this;
   }
   
	
	public String buildquery(){
		removelastand();
		System.out.println("query " + query.toString());
		return query.toString();
	}
	
	
}
