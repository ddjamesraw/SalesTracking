package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewShopAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                String name = request.getParameter("new_shop_name");
                String address = request.getParameter("new_shop_address");
                String resp = RPCServiceClient.getInstance().getPort().addNewShop(name, address);
                writer.write(resp);
            }
        } catch (Exception e) {}
    }    
}
