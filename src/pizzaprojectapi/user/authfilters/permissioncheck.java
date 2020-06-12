package pizzaprojectapi.user.authfilters;

import pizzaprojectapi.user.db.userdb;

public interface permissioncheck {
boolean haspermission(String token);
}
