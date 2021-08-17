package hiber.dao;

import hiber.model.User;
import hiber.model.Car;
import javax.sql.rowset.CachedRowSet;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getCar(String model, int series);
}
