package by.bsuir.vechorko.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {
    
    private String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuilder sb = new StringBuilder();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (NoSuchAlgorithmException e) {}
         return "";
     }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String serviceType = request.getParameter("serviceType");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String userCaptcha = request.getParameter("captcha");
        String realCaptcha = request.getSession().getAttribute("real_captcha").toString();
        
        if(login == null) login = "";
        if(serviceType == null) serviceType = "";
        if(password == null) password = "";
        if(userCaptcha == null) password = "";
        
        password = MD5(password);
        
        if(!userCaptcha.equals(realCaptcha)) {
                request.setAttribute("auth_error", "Неверно введены символы с картинки");
                request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            Boolean validation = RPCServiceClient.getInstance().getPort().checkUser(login, password);
            if(validation) {
                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("service_type", serviceType);
                if(serviceType.equals("rpc")) {
                    request.getRequestDispatcher("rpc.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("doc.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("auth_error", "Неверные логин или пароль");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
