package by.bsuir.vechorko.dao;

import by.bsuir.vechorko.dao.entity.Good;
import by.bsuir.vechorko.dao.entity.Sale;
import by.bsuir.vechorko.dao.entity.Shop;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SaleDao {
    
    @EJB
    GoodDao goodDao;
    @EJB
    ShopDao shopDao;
    
    @PersistenceContext
    private EntityManager entityManager;
 
    public List<Sale> getAll() {
        return entityManager.createNamedQuery("Sale.findAll").getResultList();
    }
    
    public Sale getById(Integer id) {
        return (Sale)entityManager.createNamedQuery("Sale.findById").setParameter("id", id).getResultList().get(0);
    }

    public void removeWithGood(Good good) {
        List<Sale> sales = entityManager.createNamedQuery("Sale.findByGoodId").setParameter("goodId", good).getResultList();
        if(sales != null && sales.size() > 0) {
            for(Sale sale: sales) {
                remove(sale.getId());
            }
        }
    }

    public void removeWithShop(Shop shop) {
        List<Sale> sales = entityManager.createNamedQuery("Sale.findByShopId").setParameter("shopId", shop).getResultList();
        for(Sale sale: sales) {
            remove(sale.getId());
        }
    }

    public String remove(Integer id) {
        Sale sale = getById(id);
        entityManager.remove(sale);
        return "success";
    }
    
    public String addNewSale(Integer good_id, Integer shop_id, Integer count, String sale_date) {
        Sale sale = new Sale();
        Good good = goodDao.getById(good_id);
        Shop shop = shopDao.getById(shop_id);
        if(good == null || shop == null) {
            return "error";
        } else {
            sale.setGoodId(good);
            sale.setQt(count);
            sale.setShopId(shop);
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            try {
                Date date = formatter.parse(sale_date);
                sale.setSaleDate(date);
                entityManager.persist(sale);
                return "success";
            } catch (ParseException ex) {
                return "error";
            }
        }
    }
    
    public String editSale(Integer id, Integer good_id, Integer shop_id, Integer count, String sale_date) {
        Sale sale = getById(id);
        Good good = goodDao.getById(good_id);
        Shop shop = shopDao.getById(shop_id);
        if(sale == null || good == null || shop == null) {
            return "error";
        } else {
            sale.setGoodId(good);
            sale.setShopId(shop);
            sale.setQt(count);
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            try {
                Date date = formatter.parse(sale_date);
                sale.setSaleDate(date);
                entityManager.merge(sale);
                return "success";
            } catch(Exception e) {
                return "error";
            }
        }
    }
    
    public String addNewSale(Sale sale) {
        if(sale == null) {
            return "error";
        }
        entityManager.persist(sale);
        return "success";
    }
}
