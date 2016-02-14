package by.bsuir.vechorko.dao;

import by.bsuir.vechorko.dao.entity.Category;
import by.bsuir.vechorko.dao.entity.Good;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GoodDao {
        
    @EJB
    SaleDao saleDao;
    
    @EJB
    CategoryDao categoryDao;
    
    @PersistenceContext
    private EntityManager entityManager;
 
    public List<Good> getAll() {
        return entityManager.createNamedQuery("Good.findAll").getResultList();
    }
    
    public Good getById(Integer id) {
        return (Good)entityManager.createNamedQuery("Good.findById").setParameter("id", id).getResultList().get(0);
    }

    
    public String remove(Integer id) {
        List<Good> goods = entityManager.createNamedQuery("Good.findById").setParameter("id", id).getResultList();
        if(goods != null && goods.size() > 0) {
            Good good = goods.get(0);
            if(good != null) {
                saleDao.removeWithGood(good);
                entityManager.remove(good);
                return "success";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }
    
    public void removeWithCategory(Category category) {
        List<Good> goods = entityManager.createNamedQuery("Good.findByCategoryId").setParameter("categoryId", category).getResultList();
        if(goods != null) {
            for(Good good: goods) {
                remove(good.getId());
            }
        }
    }

    public String addNewGood(String name, String description, Integer price, String category) {
        Good good = new Good();
        good.setName(name);
        good.setPrice(price);
        good.setDescription(description);
        Category cat = categoryDao.getById(Integer.parseInt(category));
        if(category != null) {
            good.setCategoryId(cat);
        }
        entityManager.persist(good);
        return "success";
    }
    
    public String editGood(Integer id, String name, String description, Integer price, String category) {
        Good good = getById(id);
        if(good == null) {
            return "error";
        } else {
            good.setName(name);
            good.setPrice(price);
            good.setDescription(description);
            Category cat = categoryDao.getById(Integer.parseInt(category));
            if(category != null) {
                good.setCategoryId(cat);
            }
            entityManager.merge(good);
            return "success";
        }
    }
    
    public String addNewGood(Good good) {
        entityManager.persist(good);
        return "success";
    }
}
