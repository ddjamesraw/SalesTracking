package by.bsuir.vechorko.servlet;

import by.bsuir.vechorko.servlet.client.ServiceStyleRPC;
import by.bsuir.vechorko.servlet.client.ServiceStyleRPC_Service;

public class RPCServiceClient {

    private static ServiceStyleRPC_Service service;
    private static ServiceStyleRPC port;
    private static RPCServiceClient instance = null;

    private RPCServiceClient() {
        service = new ServiceStyleRPC_Service();
        port = service.getServiceStyleRPCImplPort();
    }
    
    public static RPCServiceClient getInstance() {
        if(instance == null) {
            instance = new RPCServiceClient();
        }
        return instance;
    }
    
    public ServiceStyleRPC getPort() {
        return port;
    }
}
