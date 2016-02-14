package by.bsuir.vechorko.ws;

import by.bsuir.vechorko.dao.entity.Shop;
import by.bsuir.vechorko.dao.entity.User;
import by.bsuir.vechorko.dao.entity.Good;
import by.bsuir.vechorko.dao.entity.Category;
import by.bsuir.vechorko.dao.entity.Sale;
import by.bsuir.vechorko.logic.Logic;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebService(serviceName = "ServiceStyleRPC", endpointInterface = "by.bsuir.vechorko.ws.ServiceStyleRPC")
public class ServiceStyleRPCImpl implements ServiceStyleRPC {

    @EJB Logic logic;
    
    @Override
    public String getAllShops() {
        JSONArray response = new JSONArray();
        
        List<Shop> shops = logic.getAllShops();
        for(Shop shop: shops) {
            try {
                JSONObject shopObject = new JSONObject();
                shopObject.put("id", shop.getId().toString());
                shopObject.put("name", shop.getName());
                shopObject.put("address", shop.getAddress());
                response.put(shopObject);
            } catch (Exception e) {} 
        }
        return response.toString();
    }

    @Override
    public String getAllCategories() {
        JSONArray response = new JSONArray();
        
        List<Category> categories = logic.getAllCategories();
        for(Category category: categories) {
            try {
                JSONObject categoryObject = new JSONObject();
                categoryObject.put("id", category.getId().toString());
                categoryObject.put("name", category.getName());
                categoryObject.put("description", category.getDescription());
                response.put(categoryObject);
            } catch (Exception e) {} 
        }
        return response.toString();
    }

    @Override
    public String getAllUsers() {
        JSONArray response = new JSONArray();
        
        List<User> users = logic.getAllUsers();
        for(User user: users) {
            try {
                JSONObject userObject = new JSONObject();
                userObject.put("id", user.getId().toString());
                userObject.put("login", user.getLogin());
                userObject.put("password", user.getPassword());
                userObject.put("fio", user.getFio());
                response.put(userObject);
            } catch (Exception e) {} 
        }
        return response.toString();
    }

    @Override
    public String getAllSales() {
        JSONArray response = new JSONArray();
        
        List<Sale> sales = logic.getAllSales();
        for(Sale sale: sales) {
            try {
                JSONObject saleObject = new JSONObject();
                saleObject.put("id", sale.getId().toString());
                saleObject.put("good", sale.getGoodId().getName());
                saleObject.put("count", sale.getQt());
                DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                String sale_date = formatter.format(sale.getSaleDate());
                saleObject.put("date", sale_date);
                saleObject.put("shop", sale.getShopId().getName());
                response.put(saleObject);
            } catch (Exception e) {} 
        }
        return response.toString();
    }

    @Override
    public String getAllGoods() {
        JSONArray response = new JSONArray();
        
        List<Good> goods = logic.getAllGoods();
        for(Good good: goods) {
            try {
                JSONObject goodObject = new JSONObject();
                goodObject.put("id", good.getId().toString());
                goodObject.put("category", good.getCategoryId().getName());
                goodObject.put("description", good.getDescription());
                goodObject.put("name", good.getName());
                goodObject.put("price", good.getPrice());
                response.put(goodObject);
            } catch (Exception e) {} 
        }
        return response.toString();
    }

    @Override
    public String removeUser(Integer userId) {
        return logic.removeUser(userId);
    }

    @Override
    public String removeGood(Integer goodId) {
        return logic.removeGood(goodId);
    }

    @Override
    public String removeCategory(Integer categoryId) {
        return logic.removeCategory(categoryId);
    }

    @Override
    public String removeSale(Integer saleId) {
        return logic.removeSale(saleId);
    }

    @Override
    public String removeShop(Integer shopId) {
        return logic.removeShop(shopId);
    }

    @Override
    public String addNewUser(String login, String password, String fio) {
        return logic.addNewUser(login, password, fio);
    }

    @Override
    public String addNewCategory(String name, String description) {
        return logic.addNewCategory(name, description);
    }

    @Override
    public String addNewGood(String name, String description, Integer price, String category) {
        return logic.addNewGood(name, description, price, category);
    }

    @Override
    public String addNewShop(String name, String address) {
        return logic.addNewShop(name, address);
    }

    @Override
    public String getUser(Integer id) {
        User user = logic.getUser(id);
        JSONObject userObject = new JSONObject();
        if(user != null) {
            try {
                userObject.put("id", user.getId());
                userObject.put("login", user.getLogin());
                userObject.put("password", user.getPassword());
                userObject.put("fio", user.getFio());
            } catch (Exception e) {}
        }
        return userObject.toString();
    }

    @Override
    public String getShop(Integer id) {
        Shop shop = logic.getShop(id);
        JSONObject shopObject = new JSONObject();
        if(shop != null) {
            try {
                shopObject.put("id", shop.getId());
                shopObject.put("name", shop.getName());
                shopObject.put("address", shop.getAddress());
            } catch (Exception e) {}
        }
        return shopObject.toString();
    }

    @Override
    public String getSale(Integer id) {
        Sale sale = logic.getSale(id);
        JSONObject saleObject = new JSONObject();
        if(sale != null) {
            try {
                saleObject.put("id", sale.getId());
                saleObject.put("good", sale.getGoodId().getId());
                saleObject.put("shop", sale.getShopId().getId());
                saleObject.put("count", sale.getQt());
                DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                String sale_date = formatter.format(sale.getSaleDate());
                saleObject.put("date", sale_date);
            } catch (Exception e) {}
        }
        return saleObject.toString();
    }

    @Override
    public String getCategory(Integer id) {
        Category category = logic.getCategory(id);
        JSONObject categoryObject = new JSONObject();
        if(category != null) {
            try {
                categoryObject.put("id", category.getId());
                categoryObject.put("name", category.getName());
                categoryObject.put("description", category.getDescription());
            } catch (Exception e) {}
        }
        return categoryObject.toString();
    }

    @Override
    public String getGood(Integer id) {
        Good good = logic.getGood(id);
        JSONObject goodObject = new JSONObject();
        if(good != null) {
            try {
                goodObject.put("id", good.getId());
                goodObject.put("name", good.getName());
                goodObject.put("price", good.getPrice());
                goodObject.put("description", good.getDescription());
                goodObject.put("category", good.getCategoryId().getId());
            } catch(Exception e){} 
        }
        return goodObject.toString();
    }

    @Override
    public String editUser(Integer id, String login, String password, String fio) {
        return logic.editUser(id, login, password, fio);
    }

    @Override
    public String editShop(Integer id, String name, String address) {
        return logic.editShop(id, name, address);
    }

    @Override
    public String editGood(Integer id, String name, String description, Integer price, String category) {
        return logic.editGood(id, name, description, price, category);
    }

    @Override
    public String editCategory(Integer id, String name, String description) {
        return logic.editCategory(id, name, description);
    }

    @Override
    public Boolean checkUser(String login, String password) {
        return logic.checkUser(login, password);
    }

    @Override
    public String addNewSale(Integer good, Integer shop, Integer count, String date) {
        return logic.addNewSale(good, shop, count, date);
    }

    @Override
    public String editSale(Integer id, Integer good, Integer shop, Integer count, String date) {
        return logic.editSale(id, good, shop, count, date);
    }

    @Override
    public String getSalesStatistic() {
        List<Sale> sales = logic.getAllSales();
        JSONObject result = new JSONObject();
        JSONArray countResponse = new JSONArray();
        JSONArray sumResponse = new JSONArray();
        JSONArray shopSumResponse = new JSONArray();
        List<Integer> dateSumArray= new ArrayList<>();
        
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> shopSum = new HashMap<>();
        Map<Integer, Integer> dateSum = new HashMap<>();
        for(Sale sale: sales) {
           if(counts.containsKey(sale.getGoodId().getName())) {
               Integer count = counts.get(sale.getGoodId().getName());
               Integer summ = sum.get(sale.getGoodId().getName());
               
               counts.remove(sale.getGoodId().getName());
               sum.remove(sale.getGoodId().getName());
               
               count += sale.getQt();
               summ += sale.getQt() * sale.getGoodId().getPrice();
               
               counts.put(sale.getGoodId().getName(), count);
               sum.put(sale.getGoodId().getName(), summ);
           } else {
               counts.put(sale.getGoodId().getName(), sale.getQt());
               sum.put(sale.getGoodId().getName(), sale.getQt() * sale.getGoodId().getPrice());
           }
           if(shopSum.containsKey(sale.getShopId().getName())) {
               Integer saleSumm = shopSum.get(sale.getShopId().getName());
               shopSum.remove(sale.getShopId().getName());
               saleSumm += sale.getGoodId().getPrice() * sale.getQt();
               shopSum.put(sale.getShopId().getName(), saleSumm);
           } else {
               shopSum.put(sale.getShopId().getName(), sale.getGoodId().getPrice() * sale.getQt());
           }
           Calendar cal = Calendar.getInstance();
           cal.setTime(sale.getSaleDate());
           if(cal.get(Calendar.YEAR) == 2015) {
            int month = cal.get(Calendar.MONTH);
            if(dateSum.containsKey(month)) {
                int tmpSum = dateSum.get(month);
                dateSum.remove(month);
                tmpSum += sale.getQt() * sale.getGoodId().getPrice();
                dateSum.put(month, tmpSum);
            } else {
                dateSum.put(month, sale.getQt() * sale.getGoodId().getPrice());
            }
           }
        }   
        for (Map.Entry<String, Integer> entrySet : counts.entrySet()) {
            try {
                String key = entrySet.getKey();
                Integer value = entrySet.getValue();
                JSONObject obj = new JSONObject();
                obj.put("label", key);
                obj.put("value", value);
                countResponse.put(obj);
            } catch (JSONException ex) {}
        }
        for (Map.Entry<String, Integer> entrySet : sum.entrySet()) {
            try {
                String key = entrySet.getKey();
                Integer value = entrySet.getValue();
                JSONObject obj = new JSONObject();
                obj.put("label", key);
                obj.put("value", value);
                sumResponse.put(obj);
            } catch (JSONException ex) {}
        }
        for (Map.Entry<String, Integer> entrySet : shopSum.entrySet()) {
            try {
                String key = entrySet.getKey();
                Integer value = entrySet.getValue();
                JSONObject obj = new JSONObject();
                obj.put("label", key);
                obj.put("value", value);
                shopSumResponse.put(obj);
            } catch (JSONException ex) {}
        }
        for(int i = 0; i < 5; i++) {
            if(dateSum.containsKey(i)) {
                dateSumArray.add(dateSum.get(i));
            } else {
                dateSumArray.add(0);
            }
        }
        try {
            result.put("count", countResponse);
            result.put("sum", sumResponse);
            result.put("shop_sum", shopSumResponse);
            result.put("date_sum", dateSumArray);
        } catch(Exception e) {}
        return result.toString();
    }
}
