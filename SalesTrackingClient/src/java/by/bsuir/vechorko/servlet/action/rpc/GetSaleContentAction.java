package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSaleContentAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                String sale_id = request.getParameter("sale_id");
                String sale = RPCServiceClient.getInstance().getPort().getSale(Integer.parseInt(sale_id));
                writer.write(sale);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
