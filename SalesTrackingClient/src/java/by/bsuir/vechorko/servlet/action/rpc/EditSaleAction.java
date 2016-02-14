package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditSaleAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                Integer id = Integer.parseInt(request.getParameter("edit_sale_id"));
                Integer shop = Integer.parseInt(request.getParameter("edit_sale_shop"));
                Integer good = Integer.parseInt(request.getParameter("edit_sale_good"));
                Integer count = Integer.parseInt(request.getParameter("edit_sale_count"));
                String date = request.getParameter("edit_sale_date");
                String resp = RPCServiceClient.getInstance().getPort().editSale(id, good, shop, count, date);
                writer.write(resp);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }  
    }    
}
