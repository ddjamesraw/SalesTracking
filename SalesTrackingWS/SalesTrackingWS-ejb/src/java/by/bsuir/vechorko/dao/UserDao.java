package by.bsuir.vechorko.dao;

import by.bsuir.vechorko.dao.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDao {
        
    @PersistenceContext
    private EntityManager entityManager;
 
    public List<User> getAll() {
        return entityManager.createNamedQuery("User.findAll").getResultList();
    }
    
    public User getById(Integer id) {
        List<User> users = entityManager.createNamedQuery("User.findById").setParameter("id", id).getResultList();
        if(users != null && users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public User getByLogin(String login) {
        List<User> users = entityManager.createNamedQuery("User.findByLogin").setParameter("login", login).getResultList();
        if(users != null && users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public String remove(Integer id) {
        User user = getById(id);
        entityManager.remove(user);
        return "success";
    }
    
    public String addNewUser(String login, String password, String fio) {
        if(getByLogin(login) != null) {
            return "busy";
        } else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setFio(fio);
            entityManager.persist(user);
            return "success";
        }
    }
    
    public String editUser(Integer id, String login, String password, String fio) {
        User user = getById(id);
        if(user == null) {
            return "error";
        } else {
            if(!user.getLogin().equals(login)) {
                if(getByLogin(login) != null) {
                    return "busy";
                } 
            }
            user.setFio(fio);
            user.setLogin(login);
            if(!password.equals("-")) {
                user.setPassword(password);
            }
            entityManager.merge(user);
            return "success";
        }
    }
    
    public Boolean checkUser(String login, String password) {
        User user = getByLogin(login);
        if(user == null) {
            return false;
        } else {
            if(user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String addNewUser(User user) {
        if(getByLogin(user.getLogin()) != null) {
            return "busy";
        } else {
            entityManager.persist(user);
            return "success";
        }
    }
    
}
