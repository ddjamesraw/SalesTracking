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
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class AddNewSaleAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
         try {
            ServiceStyleDoc port = DocServiceClient.getInstance().getPort();
            PrintWriter writer = response.getWriter();
            
            if(writer != null) {
                Integer good = Integer.parseInt(request.getParameter("new_sale_good"));
                Integer shop = Integer.parseInt(request.getParameter("new_sale_shop"));
                Integer count = Integer.parseInt(request.getParameter("new_sale_count"));
                String date = request.getParameter("new_sale_date");

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();
                Element rootElement = doc.createElement("sale");
                
                Element countElement = doc.createElement("count");
                countElement.setTextContent(count.toString());
                Element dateElement = doc.createElement("date");
                dateElement.setTextContent(date);
                ///
                String goodResp = port.getGood(good);
                DocumentBuilderFactory factoryTmp = DocumentBuilderFactory.newInstance();
                DocumentBuilder builderTmp = factoryTmp.newDocumentBuilder();
                Document docTmp = builderTmp.parse(new InputSource(new StringReader(goodResp)));
                Node goodElement = doc.importNode(docTmp.getFirstChild(), true);
                ///
                String shopResp = port.getShop(shop);
                DocumentBuilderFactory factoryTmp2 = DocumentBuilderFactory.newInstance();
                DocumentBuilder builderTmp2 = factoryTmp2.newDocumentBuilder();
                Document docTmp2 = builderTmp2.parse(new InputSource(new StringReader(shopResp)));
                Node shopElement = doc.importNode(docTmp2.getFirstChild(), true);
                ///
                rootElement.appendChild(goodElement);
                rootElement.appendChild(shopElement);
                rootElement.appendChild(countElement);
                rootElement.appendChild(dateElement);
                
          	doc.appendChild(rootElement);
                
                DOMSource domSource = new DOMSource(doc);
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                ByteOutputStream bos = new ByteOutputStream();
                StreamResult result = new StreamResult(bos);
                transformer.transform(domSource, result); 

                String resp = port.addNewSale(bos.toString());

                doc = builder.parse(new InputSource(new StringReader(resp)));                
                writer.write(doc.getElementsByTagName("result").item(0).getTextContent());
            }
         } catch(Exception e) {
             e.printStackTrace();
         }    
    }    
}
