package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditGoodAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                Integer id = Integer.parseInt(request.getParameter("edit_good_id"));
                String name = request.getParameter("edit_good_name");
                String description = request.getParameter("edit_good_description");
                int price = Integer.parseInt(request.getParameter("edit_good_price"));
                String category = request.getParameter("edit_good_category");
                String resp = RPCServiceClient.getInstance().getPort().editGood(id, name, description, price, category);
                writer.write(resp);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
