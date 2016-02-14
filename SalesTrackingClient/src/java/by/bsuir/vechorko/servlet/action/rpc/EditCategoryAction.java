package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditCategoryAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                Integer id = Integer.parseInt(request.getParameter("edit_category_id"));
                String name = request.getParameter("edit_category_name");
                String description = request.getParameter("edit_category_description");
                String resp = RPCServiceClient.getInstance().getPort().editCategory(id, name, description);
                writer.write(resp);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
