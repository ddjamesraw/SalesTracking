package by.bsuir.vechorko.servlet.action;

import by.bsuir.vechorko.servlet.action.doc.AddNewCategoryAction;
import by.bsuir.vechorko.servlet.action.doc.AddNewGoodAction;
import by.bsuir.vechorko.servlet.action.doc.AddNewSaleAction;
import by.bsuir.vechorko.servlet.action.doc.AddNewShopAction;
import by.bsuir.vechorko.servlet.action.doc.AddNewUserAction;
import by.bsuir.vechorko.servlet.action.doc.GetAllCategoriesAction;
import by.bsuir.vechorko.servlet.action.doc.GetAllGoodsAction;
import by.bsuir.vechorko.servlet.action.doc.GetAllSalesAction;
import by.bsuir.vechorko.servlet.action.doc.GetAllShopsAction;
import by.bsuir.vechorko.servlet.action.doc.GetAllUsersAction;
import by.bsuir.vechorko.servlet.action.doc.LogoutAction;
import by.bsuir.vechorko.servlet.action.doc.NoAction;
import by.bsuir.vechorko.servlet.action.rpc.GetSalesStatisticAction;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public class DocRequestHelper {
    
    private static DocRequestHelper instance = null;
    HashMap<String, Action> actions;
    
    public static DocRequestHelper getInstance() {
        if (instance == null) {
           instance = new DocRequestHelper();
        }
        return instance;
    }  
    
    public Action getAction(HttpServletRequest request) {
        Action action = actions.get(request.getParameter("action"));
        if (action == null) {
            action = new NoAction();
        }
        return action;
    }
        
    private DocRequestHelper() {
        actions = new HashMap<>();
        actions.put("logout", new LogoutAction());
        actions.put("get_all_users", new GetAllUsersAction());
        actions.put("get_all_categories", new GetAllCategoriesAction());
        actions.put("get_all_goods", new GetAllGoodsAction());
        actions.put("get_all_shops", new GetAllShopsAction());
        actions.put("get_all_sales", new GetAllSalesAction());
        actions.put("add_new_user", new AddNewUserAction());
        actions.put("add_new_sale", new AddNewSaleAction());
        actions.put("add_new_shop", new AddNewShopAction());
        actions.put("add_new_good", new AddNewGoodAction());
        actions.put("add_new_category", new AddNewCategoryAction());
        actions.put("get_sales_statistic_content", new GetSalesStatisticAction());
    }
}
