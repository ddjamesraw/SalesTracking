package by.bsuir.vechorko.servlet.action.doc;

import by.bsuir.vechorko.servlet.DocServiceClient;
import by.bsuir.vechorko.servlet.action.Action;
import by.bsuir.vechorko.ws.ServiceStyleDoc;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class AddNewShopAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
         try {
            ServiceStyleDoc port = DocServiceClient.getInstance().getPort();
            PrintWriter writer = response.getWriter();
            
            if(writer != null) {
                String name = request.getParameter("new_shop_name");
                String address = request.getParameter("new_shop_address");
            
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();
                Element rootElement = doc.createElement("shop");
                
                Element nameElement = doc.createElement("name");
                nameElement.setTextContent(name);
                Element addressElement = doc.createElement("address");
                addressElement.setTextContent(address);

                rootElement.appendChild(nameElement);
                rootElement.appendChild(addressElement);
                
          	doc.appendChild(rootElement);
                DOMSource domSource = new DOMSource(doc);
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                ByteOutputStream bos = new ByteOutputStream();
                StreamResult result = new StreamResult(bos);
                transformer.transform(domSource, result); 

                String resp = port.addNewShop(bos.toString());

                doc = builder.parse(new InputSource(new StringReader(resp)));                
                writer.write(doc.getElementsByTagName("result").item(0).getTextContent());
            }
         } catch(Exception e) {}
    }    
}
