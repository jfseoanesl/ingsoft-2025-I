package org.example;

public class FactoryServer {

    public static IServer createServer(String host, int port){

        return new ProxyServer(host,port);

    }

}
