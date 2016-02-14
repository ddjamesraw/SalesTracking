package by.bsuir.vechorko.dao;

import by.bsuir.vechorko.dao.entity.Category;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryDao {
    
    @EJB
    GoodDao goodDao;
 
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Category> getAll() {
        return entityManager.createNamedQuery("Category.findAll").getResultList();
    }
    
    public Category getById(Integer id) {
        return (Category)entityManager.createNamedQuery("Category.findById").setParameter("id", id).getResultList().get(0);
    }
    
    public String remove(Integer id) {
        Category category = getById(id);
        goodDao.removeWithCategory(category);
        entityManager.remove(category);
        return "success";
    }
    
    public String addNewCategory(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        entityManager.persist(category);
        return "success";
    }
    
    public String editCategory(Integer id, String name, String description) {
        Category category = getById(id);
        if(category == null) {
            return "error";
        } else {
            category.setName(name);
            category.setDescription(description);
            entityManager.merge(category);
            return "success";
        }
    }
    
    public String addNewCategory(Category category) {
        entityManager.merge(category);
        return "success";
    }
}
