package by.bsuir.vechorko.servlet.action.doc;

import by.bsuir.vechorko.servlet.action.Action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            if(writer != null) {
                writer.write("Unknown action");
            }
        } catch (Exception e) {}
    }    
}
