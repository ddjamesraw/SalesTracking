package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCategoryContentAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                String category_id = request.getParameter("category_id");
                String category = RPCServiceClient.getInstance().getPort().getCategory(Integer.parseInt(category_id));
                writer.write(category);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
