package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveGoodAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                String id = request.getParameter("good_id");
                String resp = RPCServiceClient.getInstance().getPort().removeGood(Integer.parseInt(id));
                writer.write(resp);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
