package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewUserAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                String login = request.getParameter("new_user_login");
                String password = request.getParameter("new_user_password");
                String fio = request.getParameter("new_user_fio");
                String resp = RPCServiceClient.getInstance().getPort().addNewUser(login, password, fio);
                writer.write(resp);
            }
        } catch (Exception e) {}
    }    
}
