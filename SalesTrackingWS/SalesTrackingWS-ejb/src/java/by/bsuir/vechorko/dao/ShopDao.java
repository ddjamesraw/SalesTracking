package by.bsuir.vechorko.dao;

import by.bsuir.vechorko.dao.entity.Shop;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ShopDao {
    
    @EJB
    SaleDao saleDao;
   
    @PersistenceContext
    private EntityManager entityManager;
 
    public List<Shop> getAll() {
        return entityManager.createNamedQuery("Shop.findAll").getResultList();
    }
    
    public Shop getById(Integer id) {
        return (Shop)entityManager.createNamedQuery("Shop.findById").setParameter("id", id).getResultList().get(0);
    }
    
    public String remove(Integer id) {
        Shop shop = getById(id);
        saleDao.removeWithShop(shop);
        entityManager.remove(shop);
        return "success";
    }
       
    public String addNewShop(String name, String address) {
        Shop shop = new Shop();
        shop.setName(name);
        shop.setAddress(address);
        entityManager.persist(shop);
        return "success";
    }
    
    public String editShop(Integer id, String name, String address) {
        Shop shop = getById(id);
        if(shop == null) {
            return "error";
        } else {
            shop.setName(name);
            shop.setAddress(address);
            entityManager.merge(shop);
            return "success";
        }
    }
    
    public String addNewShop(Shop shop) {
        entityManager.persist(shop);
        return "success";
    }
}
