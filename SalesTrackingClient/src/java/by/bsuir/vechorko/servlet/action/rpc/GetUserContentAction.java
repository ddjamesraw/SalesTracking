package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserContentAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                String user_id = request.getParameter("user_id");
                String user = RPCServiceClient.getInstance().getPort().getUser(Integer.parseInt(user_id));
                writer.write(user);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
