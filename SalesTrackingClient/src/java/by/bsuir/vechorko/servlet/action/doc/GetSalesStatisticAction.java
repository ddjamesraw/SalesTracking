package by.bsuir.vechorko.servlet.action.doc;

import by.bsuir.vechorko.servlet.DocServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import by.bsuir.vechorko.ws.ServiceStyleDoc;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class GetSalesStatisticAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServiceStyleDoc port = DocServiceClient.getInstance().getPort();
            PrintWriter writer = response.getWriter();
            
            if(writer != null) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                String resp = port.getSalesStatistic();
                Document doc = builder.parse(new InputSource(new StringReader(resp)));
                writer.write(doc.getElementsByTagName("statistic").item(0).getTextContent());
            }
        } catch(Exception e) {}
    }    
}
