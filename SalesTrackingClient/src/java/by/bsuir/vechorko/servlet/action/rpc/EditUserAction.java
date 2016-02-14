package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUserAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                Integer id = Integer.parseInt(request.getParameter("edit_user_id"));
                String login = request.getParameter("edit_user_login");
                String password = request.getParameter("edit_user_password");
                String fio = request.getParameter("edit_user_fio");
                String resp = RPCServiceClient.getInstance().getPort().editUser(id, login, password, fio);
                writer.write(resp);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
