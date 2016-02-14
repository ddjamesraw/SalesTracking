package by.bsuir.vechorko.logic;

import by.bsuir.vechorko.dao.CategoryDao;
import by.bsuir.vechorko.dao.GoodDao;
import by.bsuir.vechorko.dao.SaleDao;
import by.bsuir.vechorko.dao.ShopDao;
import by.bsuir.vechorko.dao.UserDao;
import by.bsuir.vechorko.dao.entity.Category;
import by.bsuir.vechorko.dao.entity.Good;
import by.bsuir.vechorko.dao.entity.Sale;
import by.bsuir.vechorko.dao.entity.Shop;
import by.bsuir.vechorko.dao.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class Logic {
    
    @EJB ShopDao shopDao;
    
    @EJB CategoryDao categoryDao;
    
    @EJB UserDao userDao;
    
    @EJB  GoodDao goodDao;
    
    @EJB SaleDao saleDao;
    
    public Shop getShop(Integer id) {
        return shopDao.getById(id);
    }
    
    public User getUser(Integer id) {
        return userDao.getById(id);
    }
    
    public Category getCategory(Integer id) {
        return categoryDao.getById(id);
    }
    
    public Good getGood(Integer id) {
        return goodDao.getById(id);
    }
    
    public Sale getSale(Integer id) {
        return saleDao.getById(id);
    }
    
    public List<Shop> getAllShops() {
        return shopDao.getAll();
    }
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }
    public List<Sale> getAllSales() {
        return saleDao.getAll();
    }
    public List<Good> getAllGoods() {
        return goodDao.getAll();
    }
    
    public String removeUser(Integer id) {
        return userDao.remove(id);
    }
    
    public String removeShop(Integer id) {
        return shopDao.remove(id);
    }
    
    public String removeSale(Integer id) {
        return saleDao.remove(id);
    }
    
    public String removeGood(Integer id) {
        return goodDao.remove(id);
    }
    
    public String removeCategory(Integer id) {
        return categoryDao.remove(id);
    }
    
    public String addNewUser(User user) {
        return userDao.addNewUser(user);
    }
    
    public String addNewCategory(Category category) {
        return categoryDao.addNewCategory(category);
    }
    
    public String addNewShop(Shop shop) {
        return shopDao.addNewShop(shop);
    }
    
    public String addNewSale(Sale sale) {
        return saleDao.addNewSale(sale);
    }
    
    public String addNewGood(Good good) {
        return goodDao.addNewGood(good);
    }
    
    public String addNewUser(String login, String password, String fio) {
        return userDao.addNewUser(login, password, fio);
    }
    
    public String addNewCategory(String name, String description) {
        return categoryDao.addNewCategory(name, description);
    }
    
    public String addNewSale(Integer good_id, Integer shop_id, Integer count, String date) {
        return saleDao.addNewSale(good_id, shop_id, count, date);
    }
    
    public String addNewGood(String name, String description, Integer price, String category) {
        return goodDao.addNewGood(name, description, price, category);
    }

    public String addNewShop(String name, String address) {
        return shopDao.addNewShop(name, address);
    }
    
    public String editUser(Integer id, String login, String password, String fio) {
        return userDao.editUser(id, login, password, fio);
    }

    public String editSale(Integer id, Integer good_id, Integer shop_id, Integer count, String date) {
        return saleDao.editSale(id, good_id, shop_id, count, date);
    }
    
    public String editShop(Integer id, String name, String address) {
        return shopDao.editShop(id, name, address);
    }

    public String editGood(Integer id, String name, String description, Integer price, String category) {
        return goodDao.editGood(id, name, description, price, category);
    }
    
    public String editCategory(Integer id, String name, String description) {
        return categoryDao.editCategory(id, name, description);
    }
    
    public Boolean checkUser(String login, String password) {
        return userDao.checkUser(login, password);
    }
}
