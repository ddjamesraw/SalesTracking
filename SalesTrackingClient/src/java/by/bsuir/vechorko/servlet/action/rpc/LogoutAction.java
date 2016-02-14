package by.bsuir.vechorko.servlet.action.rpc;

import by.bsuir.vechorko.servlet.action.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {}
    }    
}
