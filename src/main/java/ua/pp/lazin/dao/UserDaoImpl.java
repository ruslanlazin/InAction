package ua.pp.lazin.dao;

import org.springframework.stereotype.Component;
import ua.pp.lazin.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceUnit(name = "entityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Override
    public User findUserByLogin(String login) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login =:user_login", User.class);
            query.setParameter("user_login", login);
            List<User> users = query.getResultList();
            if (users.isEmpty()) {
                return null;
            } else {
                User user = users.get(0);
                user.getThoughts().stream().forEach(System.out::println);      //todo remove println
                return user;
            }
        } finally {
            em.close();
        }
    }

    @Override
    public User update(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            User updatedUser = em.merge(user);
            em.getTransaction().commit();
            return updatedUser;
        } finally {
            em.close();
        }
    }

    @Override
    public void persist(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}