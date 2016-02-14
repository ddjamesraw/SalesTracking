package by.bsuir.vechorko.ws;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
@HandlerChain(file = "handler_chain.xml")
public interface ServiceStyleRPC {
    
    @WebMethod(operationName = "getAllShops")
    public String getAllShops();
    
    @WebMethod(operationName = "getAllCategories")
    public String getAllCategories();
    
    @WebMethod(operationName = "getAllUsers")
    public String getAllUsers();
    
    @WebMethod(operationName = "getAllSales")
    public String getAllSales();
    
    @WebMethod(operationName = "getAllGoods")
    public String getAllGoods();
    
    @WebMethod(operationName = "removeUser")
    public String removeUser(@WebParam(name = "userId") Integer userId);

    @WebMethod(operationName = "removeGood")
    public String removeGood(@WebParam(name = "goodId") Integer goodId);
    
    @WebMethod(operationName = "removeCategory")
    public String removeCategory(@WebParam(name = "categoryId") Integer categoryId);
    
    @WebMethod(operationName = "removeSale")
    public String removeSale(@WebParam(name = "saleId") Integer saleId);
    
    @WebMethod(operationName = "removeShop")
    public String removeShop(@WebParam(name = "shopId") Integer shopId);

    @WebMethod(operationName = "addNewSale")
    public String addNewSale(@WebParam(name = "good") Integer good, @WebParam(name = "shop") Integer shop, @WebParam(name = "count") Integer count, @WebParam(name = "date") String date);

    @WebMethod(operationName = "addNewUser")
    public String addNewUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password, @WebParam(name = "fio") String fio);

    @WebMethod(operationName = "addNewCategory")
    public String addNewCategory(@WebParam(name = "name") String name, @WebParam(name = "description") String description);

    @WebMethod(operationName = "addNewGood")
    public String addNewGood(@WebParam(name = "name") String name, @WebParam(name = "description") String description, @WebParam(name = "price") Integer price, @WebParam(name="category") String category);

    @WebMethod(operationName = "addNewShop")
    public String addNewShop(@WebParam(name = "name") String name, @WebParam(name = "address") String address);

    @WebMethod(operationName = "getUser")
    public String getUser(@WebParam(name = "id") Integer id);

    @WebMethod(operationName = "getShop")
    public String getShop(@WebParam(name = "id") Integer id);

    @WebMethod(operationName = "getSale")
    public String getSale(@WebParam(name = "id") Integer id);

    @WebMethod(operationName = "getCategory")
    public String getCategory(@WebParam(name = "id") Integer id);

    @WebMethod(operationName = "getGood")
    public String getGood(@WebParam(name = "id") Integer id);

    @WebMethod(operationName = "editUser")
    public String editUser(@WebParam(name = "id") Integer id, @WebParam(name = "login") String login, @WebParam(name = "password") String password, @WebParam(name = "fio") String fio);

    @WebMethod(operationName = "editShop")
    public String editShop(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name, @WebParam(name = "address") String address);

    @WebMethod(operationName = "editSale")
    public String editSale(@WebParam(name = "id") Integer id, @WebParam(name = "good") Integer good, @WebParam(name = "shop") Integer shop, @WebParam(name = "count") Integer count, @WebParam(name = "date") String date);

    @WebMethod(operationName = "editGood")
    public String editGood(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name, @WebParam(name = "description") String description, @WebParam(name = "price") Integer price, @WebParam(name="category") String category);

    @WebMethod(operationName = "editCategory")
    public String editCategory(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name, @WebParam(name = "description") String description);

    @WebMethod(operationName = "checkUser")
    public Boolean checkUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password);
            
    @WebMethod(operationName = "getSalesStatistic")
    public String getSalesStatistic();
}
