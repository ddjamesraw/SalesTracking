package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.RPCServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetGoodContentAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                String good_id = request.getParameter("good_id");
                String good = RPCServiceClient.getInstance().getPort().getGood(Integer.parseInt(good_id));
                writer.write(good);
            }
        } catch (IOException | NumberFormatException e) {}
    }    
}
