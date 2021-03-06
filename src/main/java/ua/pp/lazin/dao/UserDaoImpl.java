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
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login =:user_login", User.class);
            query.setParameter("user_login", login);
            List<User> users = query.getResultList();
            if (users.isEmpty()) {
                return null;
            } else {
                User user = users.get(0);
                intializeFields(user);
                return user;
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public User getUserbyId(Long id) {
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            User user = em.find(User.class, id);
            if (user != null) {
                intializeFields(user);
            }
            return user;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public User update(User user) {
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            User updatedUser = em.merge(user);
            em.getTransaction().commit();
            if (updatedUser != null) {
                intializeFields(updatedUser);
            }
            return updatedUser;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void persist(User user) {
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    private void intializeFields(User user) {
        user.getThoughts().forEach(System.out::println);      //todo remove println
        user.getFriends().forEach(friend -> friend.getThoughts().forEach(System.out::println)); //todo remove println
    }
}