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

public class AddNewUserAction implements Action {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
         try {
            ServiceStyleDoc port = DocServiceClient.getInstance().getPort();
            PrintWriter writer = response.getWriter();
            
            if(writer != null) {
                String login = request.getParameter("new_user_login");
                String password = request.getParameter("new_user_password");
                String fio = request.getParameter("new_user_fio");
            
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();
                Element rootElement = doc.createElement("user");
                
                Element loginElement = doc.createElement("login");
                loginElement.setTextContent(login);
                Element passwordElement = doc.createElement("password");
                passwordElement.setTextContent(password);
                Element fioElement = doc.createElement("fio");
                fioElement.setTextContent(fio);
                
                rootElement.appendChild(loginElement);
                rootElement.appendChild(passwordElement);
                rootElement.appendChild(fioElement);
                
          	doc.appendChild(rootElement);
                DOMSource domSource = new DOMSource(doc);
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                ByteOutputStream bos = new ByteOutputStream();
                StreamResult result = new StreamResult(bos);
                transformer.transform(domSource, result); 

                String resp = port.addNewUser(bos.toString());

                doc = builder.parse(new InputSource(new StringReader(resp)));                
                writer.write(doc.getElementsByTagName("result").item(0).getTextContent());
            }
         } catch(Exception e) {}
    }    
}
