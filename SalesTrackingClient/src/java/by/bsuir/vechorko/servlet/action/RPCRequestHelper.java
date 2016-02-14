package by.bsuir.vechorko.servlet.action;

import by.bsuir.vechorko.servlet.action.rpc.AddNewCategoryAction;
import by.bsuir.vechorko.servlet.action.rpc.AddNewGoodAction;
import by.bsuir.vechorko.servlet.action.rpc.AddNewSaleAction;
import by.bsuir.vechorko.servlet.action.rpc.AddNewShopAction;
import by.bsuir.vechorko.servlet.action.rpc.AddNewUserAction;
import by.bsuir.vechorko.servlet.action.rpc.EditCategoryAction;
import by.bsuir.vechorko.servlet.action.rpc.EditShopAction;
import by.bsuir.vechorko.servlet.action.rpc.EditGoodAction;
import by.bsuir.vechorko.servlet.action.rpc.EditSaleAction;
import by.bsuir.vechorko.servlet.action.rpc.EditUserAction;
import by.bsuir.vechorko.servlet.action.rpc.GetAllCategoriesContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetAllGoodsContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetAllSalesContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetAllShopsContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetAllUsersContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetCategoryContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetCurrentLoginAction;
import by.bsuir.vechorko.servlet.action.rpc.GetGoodContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetSaleContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetSalesStatisticAction;
import by.bsuir.vechorko.servlet.action.rpc.GetShopContentAction;
import by.bsuir.vechorko.servlet.action.rpc.GetUserContentAction;
import by.bsuir.vechorko.servlet.action.rpc.LogoutAction;
import by.bsuir.vechorko.servlet.action.rpc.NoAction;
import by.bsuir.vechorko.servlet.action.rpc.RemoveCategoryAction;
import by.bsuir.vechorko.servlet.action.rpc.RemoveGoodAction;
import by.bsuir.vechorko.servlet.action.rpc.RemoveSaleAction;
import by.bsuir.vechorko.servlet.action.rpc.RemoveShopAction;
import by.bsuir.vechorko.servlet.action.rpc.RemoveUserAction;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public class RPCRequestHelper {
    
    private static RPCRequestHelper instance = null;
    HashMap<String, Action> actions;
    
    public static RPCRequestHelper getInstance() {
        if (instance == null) {
           instance = new RPCRequestHelper();
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
        
    private RPCRequestHelper() {
        actions = new HashMap<>();
        actions.put("get_all_shops_content", new GetAllShopsContentAction());
        actions.put("get_all_users_content", new GetAllUsersContentAction());
        actions.put("get_all_goods_content", new GetAllGoodsContentAction());
        actions.put("get_all_categories_content", new GetAllCategoriesContentAction());
        actions.put("get_all_sales_content", new GetAllSalesContentAction());
        actions.put("edit_user", new EditUserAction());
        actions.put("edit_shop", new EditShopAction());
        actions.put("edit_good", new EditGoodAction());
        actions.put("edit_sale", new EditSaleAction());
        actions.put("edit_category", new EditCategoryAction());
        actions.put("remove_user", new RemoveUserAction());
        actions.put("remove_category", new RemoveCategoryAction());
        actions.put("remove_shop", new RemoveShopAction());
        actions.put("remove_sale", new RemoveSaleAction());
        actions.put("remove_good", new RemoveGoodAction());
        actions.put("add_new_user", new AddNewUserAction());
        actions.put("add_new_category", new AddNewCategoryAction());
        actions.put("add_new_shop", new AddNewShopAction());
        actions.put("add_new_sale", new AddNewSaleAction());
        actions.put("add_new_good", new AddNewGoodAction());
        actions.put("get_user_content", new GetUserContentAction());
        actions.put("get_category_content", new GetCategoryContentAction());
        actions.put("get_shop_content", new GetShopContentAction());
        actions.put("get_sale_content", new GetSaleContentAction());
        actions.put("get_good_content", new GetGoodContentAction());
        actions.put("logout", new LogoutAction());
        actions.put("get_current_login", new GetCurrentLoginAction());
        actions.put("get_sales_statistic_content", new GetSalesStatisticAction());
    }
}
