package by.bsuir.vechorko.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int width = 100;
        int height = 40;

        SecureRandom random = new SecureRandom();
        
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        Font font = new Font("Georgia", Font.BOLD, 15);
        g2d.setFont(font);

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, height/2, Color.pink, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.RED);

        Random r = new Random();

        String captcha = new BigInteger(25, random).toString(32);
        request.getSession().setAttribute("real_captcha", captcha);

        int x = 0; 
        int y = 0;

        for (int i=0; i < captcha.length(); i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 10 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(captcha.toCharArray(), i, 1, x, y);
        }

        g2d.dispose();

        response.setContentType("image/png");
        try (OutputStream os = response.getOutputStream()) {
            ImageIO.write(bufferedImage, "png", os);
        }        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
