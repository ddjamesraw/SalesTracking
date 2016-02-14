package by.bsuir.vechorko.servlet;

import by.bsuir.vechorko.ws.ServiceStyleDoc;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class DocServiceClient {
    
    private static DocServiceClient instance = null;
    private static ServiceStyleDoc port = null;
    
    private DocServiceClient() {
        try {
            URL url = new URL("http://localhost:8080/SalesTrackingWS-war/ServiceStyleDoc?wsdl");
            QName qname = new QName("http://ws.vechorko.bsuir.by/", "ServiceStyleDoc");
            Service service = Service.create(url, qname);
            port = service.getPort(ServiceStyleDoc.class);
        } catch (Exception e) {}
    }
    
    public static DocServiceClient getInstance() {
        if(instance == null) {
            instance = new DocServiceClient();
        }
        return instance;
    }
    
    public ServiceStyleDoc getPort() {
        return port;
    }
}
