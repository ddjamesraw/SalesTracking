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
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetAllCategoriesAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServiceStyleDoc port = DocServiceClient.getInstance().getPort();
            String resp = port.getAllCategories();
            PrintWriter writer = response.getWriter();
            
            if(writer != null) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(resp)));
                
                String xslPath = "";
                NodeList currentPageContent =  doc.getChildNodes();
                for (int i = 0; i < currentPageContent.getLength(); i++) {
                    Node node = currentPageContent.item(i);
                    if(node.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE) {
                        if(node.getNodeName().equals("xml-stylesheet")) {
                            xslPath = node.getTextContent().split(" ")[1];
                            xslPath = xslPath.substring(6, xslPath.length() - 1);
                        }
                    }
                }
                
                TransformerFactory tf = TransformerFactory.newInstance();
                StreamSource xslt = new StreamSource(xslPath);
                Transformer transformer = tf.newTransformer(xslt);
                
                Source source = new DOMSource(doc);
                StreamResult result = new StreamResult(writer);
                transformer.transform(source, result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
}
