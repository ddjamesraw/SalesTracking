package by.bsuir.vechorko.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL)
public interface ServiceStyleDoc {

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
    
    @WebMethod(operationName = "addNewSale")
    public String addNewSale(@WebParam(name = "sale") String sale);

    @WebMethod(operationName = "addNewUser")
    public String addNewUser(@WebParam(name = "user") String user);

    @WebMethod(operationName = "addNewCategory")
    public String addNewCategory(@WebParam(name = "category") String category);

    @WebMethod(operationName = "addNewGood")
    public String addNewGood(@WebParam(name = "good") String good);

    @WebMethod(operationName = "addNewShop")
    public String addNewShop(@WebParam(name = "shop") String shop);

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

    @WebMethod(operationName = "getSalesStatistic")
    public String getSalesStatistic();
}
