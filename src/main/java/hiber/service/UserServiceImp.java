package hiber.service;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    public User getCar(String model, int series) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("select user from Car where(model=:model)and(series=:series)")
                .setParameter("model", model)
                .setParameter("series", series).getSingleResult();
        System.out.println(user);
        return user;
    }
}
