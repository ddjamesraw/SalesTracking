package by.bsuir.vechorko.ws;

import by.bsuir.vechorko.dao.entity.Category;
import by.bsuir.vechorko.dao.entity.Good;
import by.bsuir.vechorko.dao.entity.Sale;
import by.bsuir.vechorko.dao.entity.Shop;
import by.bsuir.vechorko.dao.entity.User;
import by.bsuir.vechorko.dao.entity.array.Categories;
import by.bsuir.vechorko.dao.entity.array.Goods;
import by.bsuir.vechorko.dao.entity.array.Sales;
import by.bsuir.vechorko.dao.entity.array.Shops;
import by.bsuir.vechorko.dao.entity.array.Users;
import by.bsuir.vechorko.logic.Logic;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@WebService(serviceName = "ServiceStyleDoc", endpointInterface = "by.bsuir.vechorko.ws.ServiceStyleDoc")
public class ServiceStyleDocImpl implements ServiceStyleDoc {

   @EJB Logic logic;
   
   public Boolean validate(Document xml, String xsd) {
       try {
            URL schemaFile = new URL(xsd);
            Source xmlFile = new StreamSource(new StringReader(getStringFromDoc(xml)));
            SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            return true;
       } catch (SAXException | IOException e) {
           return false;
       }        
    }
    
    private String getStringFromDoc(Document doc)    {
        DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
        LSSerializer lsSerializer = domImplementation.createLSSerializer();
        return lsSerializer.writeToString(doc);   
    }

    @Override
    public String getAllShops() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shops.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            Shops shops = new Shops();
            shops.setShops(logic.getAllShops());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(shops, os);
            String xmlDoc = os.toString("UTF-8");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
            Element root = doc.getDocumentElement();
            Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/shops.xsl\"");
            Node pi2 = doc.createProcessingInstruction("xml-schema", "type=\"text/xsd\" href=\"http://localhost:8080/SalesTrackingWS-war/shops.xsd\"");
            doc.insertBefore(pi, root);
            doc.insertBefore(pi2, root);
            Boolean res = validate(doc, "http://localhost:8080/SalesTrackingWS-war/shops.xsd");
            if(res) {
                return getStringFromDoc(doc);
            } else {
                return "";
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getAllCategories() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            Categories categories = new Categories();
            categories.setCategories(logic.getAllCategories());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(categories, os);
            String xmlDoc = os.toString("UTF-8");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
            Element root = doc.getDocumentElement();
            Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/categories.xsl\"");
            Node pi2 = doc.createProcessingInstruction("xml-schema", "type=\"text/xsd\" href=\"http://localhost:8080/SalesTrackingWS-war/categories.xsd\"");
            doc.insertBefore(pi, root);
            doc.insertBefore(pi2, root);
            Boolean res = validate(doc, "http://localhost:8080/SalesTrackingWS-war/categories.xsd");
            if(res) {
                return getStringFromDoc(doc);
            } else {
                return "";
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getAllUsers() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            Users users = new Users();
            users.setUsers(logic.getAllUsers());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(users, os);
            String xmlDoc = os.toString("UTF-8");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
            Element root = doc.getDocumentElement();
            Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/users.xsl\"");
            Node pi2 = doc.createProcessingInstruction("xml-schema", "type=\"text/xsd\" href=\"http://localhost:8080/SalesTrackingWS-war/users.xsd\"");
            doc.insertBefore(pi, root);
            doc.insertBefore(pi2, root);
            Boolean res = validate(doc, "http://localhost:8080/SalesTrackingWS-war/users.xsd");
            if(res) {
                return getStringFromDoc(doc);
            } else {
                return "";
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    } 

    @Override
    public String getAllSales() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sales.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            Sales sales = new Sales();
            sales.setSales(logic.getAllSales());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(sales, os);
            String xmlDoc = os.toString("UTF-8");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
            Element root = doc.getDocumentElement();
            Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/sales.xsl\"");
            Node pi2 = doc.createProcessingInstruction("xml-schema", "type=\"text/xsd\" href=\"http://localhost:8080/SalesTrackingWS-war/sales.xsd\"");
            doc.insertBefore(pi, root);
            doc.insertBefore(pi2, root);
            Boolean res = validate(doc, "http://localhost:8080/SalesTrackingWS-war/sales.xsd");
            if(res) {
                return getStringFromDoc(doc);
            } else {
                return "";
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getAllGoods() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Goods.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            Goods goods = new Goods();
            goods.setGoods(logic.getAllGoods());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(goods, os);
            String xmlDoc = os.toString("UTF-8");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
            Element root = doc.getDocumentElement();
            Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/goods.xsl\"");
            Node pi2 = doc.createProcessingInstruction("xml-schema", "type=\"text/xsd\" href=\"http://localhost:8080/SalesTrackingWS-war/goods.xsd\"");
            doc.insertBefore(pi, root);
            doc.insertBefore(pi2, root);
            Boolean res = validate(doc, "http://localhost:8080/SalesTrackingWS-war/goods.xsd");
            if(res) {
                return getStringFromDoc(doc);
            } else {
                return "";
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String addNewSale(String data) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sale.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Sale sale = (Sale)unmarshaller.unmarshal(new ByteArrayInputStream(data.getBytes()));
            String resp = logic.addNewSale(sale);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("result");
            rootElement.setTextContent(resp);
            doc.appendChild(rootElement);
            DOMSource domSource = new DOMSource(doc);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            ByteOutputStream bos = new ByteOutputStream();
            StreamResult result = new StreamResult(bos);
            transformer.transform(domSource, result); 
            return bos.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";    
    }

    @Override
    public String addNewUser(String data) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            User user = (User)unmarshaller.unmarshal(new ByteArrayInputStream(data.getBytes()));
            String resp = logic.addNewUser(user);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("result");
            rootElement.setTextContent(resp);
            doc.appendChild(rootElement);
            DOMSource domSource = new DOMSource(doc);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            ByteOutputStream bos = new ByteOutputStream();
            StreamResult result = new StreamResult(bos);
            transformer.transform(domSource, result); 
            return bos.toString();
        } catch(Exception e) {}
        return "";
    }

    @Override
    public String addNewCategory(String data) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Category category = (Category)unmarshaller.unmarshal(new ByteArrayInputStream(data.getBytes()));
            String resp = logic.addNewCategory(category);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("result");
            rootElement.setTextContent(resp);
            doc.appendChild(rootElement);
            DOMSource domSource = new DOMSource(doc);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            ByteOutputStream bos = new ByteOutputStream();
            StreamResult result = new StreamResult(bos);
            transformer.transform(domSource, result); 
            return bos.toString();
        } catch(Exception e) {}
        return "";   
    }

    @Override
    public String addNewGood(String data) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Good.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Good good = (Good)unmarshaller.unmarshal(new ByteArrayInputStream(data.getBytes()));
            String resp = logic.addNewGood(good);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("result");
            rootElement.setTextContent(resp);
            doc.appendChild(rootElement);
            DOMSource domSource = new DOMSource(doc);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            ByteOutputStream bos = new ByteOutputStream();
            StreamResult result = new StreamResult(bos);
            transformer.transform(domSource, result); 
            return bos.toString();
        } catch(Exception e) {}
        return "";       
    }

    @Override
    public String addNewShop(String data) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Shop shop = (Shop)unmarshaller.unmarshal(new ByteArrayInputStream(data.getBytes()));
            String resp = logic.addNewShop(shop);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("result");
            rootElement.setTextContent(resp);
            doc.appendChild(rootElement);
            DOMSource domSource = new DOMSource(doc);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            ByteOutputStream bos = new ByteOutputStream();
            StreamResult result = new StreamResult(bos);
            transformer.transform(domSource, result); 
            return bos.toString();
        } catch(Exception e) {}
        return "";     
    }

    @Override
    public String getUser(Integer id) {
        try {
            User user = logic.getUser(id);
            if(user != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                jaxbMarshaller.marshal(user, os);
                String xmlDoc = os.toString("UTF-8");

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
                Element root = doc.getDocumentElement();
                Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/user.xsl\"");
                doc.insertBefore(pi, root);
                return getStringFromDoc(doc);
            } else {
               return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getShop(Integer id) {
        try {
            Shop shop = logic.getShop(id);
            if(shop != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                jaxbMarshaller.marshal(shop, os);
                String xmlDoc = os.toString("UTF-8");

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
                Element root = doc.getDocumentElement();
                Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/shop.xsl\"");
                doc.insertBefore(pi, root);
                return getStringFromDoc(doc);
            } else {
               return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getSale(Integer id) {
        try {
            Sale sale = logic.getSale(id);
            if(sale != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Sale.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                jaxbMarshaller.marshal(sale, os);
                String xmlDoc = os.toString("UTF-8");

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
                Element root = doc.getDocumentElement();
                Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/sale.xsl\"");
                doc.insertBefore(pi, root);
                return getStringFromDoc(doc);
            } else {
               return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getCategory(Integer id) {
        try {
            Category category = logic.getCategory(id);
            if(category != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                jaxbMarshaller.marshal(category, os);
                String xmlDoc = os.toString("UTF-8");

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
                Element root = doc.getDocumentElement();
                Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/category.xsl\"");
                doc.insertBefore(pi, root);
                return getStringFromDoc(doc);
            } else {
               return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getGood(Integer id) {
        try {
            Good good = logic.getGood(id);
            if(good != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Good.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                jaxbMarshaller.marshal(good, os);
                String xmlDoc = os.toString("UTF-8");

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(xmlDoc)));
                Element root = doc.getDocumentElement();
                Node pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"http://localhost:8080/SalesTrackingWS-war/good.xsl\"");
                doc.insertBefore(pi, root);
                return getStringFromDoc(doc);
            } else {
               return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }    
    }

    @Override
    public String getSalesStatistic() {
        List<Sale> sales = logic.getAllSales();
        JSONObject result = new JSONObject();
        JSONArray countResponse = new JSONArray();
        JSONArray sumResponse = new JSONArray();
        JSONArray shopSumResponse = new JSONArray();
        List<Integer> dateSumArray= new ArrayList<>();
        
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> shopSum = new HashMap<>();
        Map<Integer, Integer> dateSum = new HashMap<>();
        for(Sale sale: sales) {
           if(counts.containsKey(sale.getGoodId().getName())) {
               Integer count = counts.get(sale.getGoodId().getName());
               Integer summ = sum.get(sale.getGoodId().getName());
               
               counts.remove(sale.getGoodId().getName());
               sum.remove(sale.getGoodId().getName());
               
               count += sale.getQt();
               summ += sale.getQt() * sale.getGoodId().getPrice();
               
               counts.put(sale.getGoodId().getName(), count);
               sum.put(sale.getGoodId().getName(), summ);
           } else {
               counts.put(sale.getGoodId().getName(), sale.getQt());
               sum.put(sale.getGoodId().getName(), sale.getQt() * sale.getGoodId().getPrice());
           }
           if(shopSum.containsKey(sale.getShopId().getName())) {
               Integer saleSumm = shopSum.get(sale.getShopId().getName());
               shopSum.remove(sale.getShopId().getName());
               saleSumm += sale.getGoodId().getPrice() * sale.getQt();
               shopSum.put(sale.getShopId().getName(), saleSumm);
           } else {
               shopSum.put(sale.getShopId().getName(), sale.getGoodId().getPrice() * sale.getQt());
           }
           Calendar cal = Calendar.getInstance();
           cal.setTime(sale.getSaleDate());
           if(cal.get(Calendar.YEAR) == 2015) {
            int month = cal.get(Calendar.MONTH);
            if(dateSum.containsKey(month)) {
                int tmpSum = dateSum.get(month);
                dateSum.remove(month);
                tmpSum += sale.getQt() * sale.getGoodId().getPrice();
                dateSum.put(month, tmpSum);
            } else {
                dateSum.put(month, sale.getQt() * sale.getGoodId().getPrice());
            }
           }
        }   
        for (Map.Entry<String, Integer> entrySet : counts.entrySet()) {
            try {
                String key = entrySet.getKey();
                Integer value = entrySet.getValue();
                JSONObject obj = new JSONObject();
                obj.put("label", key);
                obj.put("value", value);
                countResponse.put(obj);
            } catch (JSONException ex) {}
        }
        for (Map.Entry<String, Integer> entrySet : sum.entrySet()) {
            try {
                String key = entrySet.getKey();
                Integer value = entrySet.getValue();
                JSONObject obj = new JSONObject();
                obj.put("label", key);
                obj.put("value", value);
                sumResponse.put(obj);
            } catch (JSONException ex) {}
        }
        for (Map.Entry<String, Integer> entrySet : shopSum.entrySet()) {
            try {
                String key = entrySet.getKey();
                Integer value = entrySet.getValue();
                JSONObject obj = new JSONObject();
                obj.put("label", key);
                obj.put("value", value);
                shopSumResponse.put(obj);
            } catch (JSONException ex) {}
        }
        for(int i = 0; i < 5; i++) {
            if(dateSum.containsKey(i)) {
                dateSumArray.add(dateSum.get(i));
            } else {
                dateSumArray.add(0);
            }
        }
        try {
            result.put("count", countResponse);
            result.put("sum", sumResponse);
            result.put("shop_sum", shopSumResponse);
            result.put("date_sum", dateSumArray);
        } catch(Exception e) {}
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("statistic");
            rootElement.setTextContent(result.toString());
            doc.appendChild(rootElement);
            DOMSource domSource = new DOMSource(doc);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            ByteOutputStream bos = new ByteOutputStream();
            StreamResult resp = new StreamResult(bos);
            transformer.transform(domSource, resp); 
            return bos.toString();
        } catch (Exception e) {}
        return "";
    }
}
