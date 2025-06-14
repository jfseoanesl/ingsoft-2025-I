package org.example;

import org.example.urlaccesscomponent.UrlAccessService;

import java.util.HashMap;
import java.util.Map;

public class ProxyServer implements IServer {

    private String host;
    private int port;
    private RealServer server;
    private Map<String, String> downloadsCache = new HashMap<>();

    public ProxyServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void download(String url) {

        // pre-actions
        if(UrlAccessService.urlAccessValidate(url)){

            if(this.server==null){

                this.server = new RealServer(this.host, this.port);

            }
            if(this.downloadsCache.containsKey(url)){

                System.out.println("Descargando: " + url + ", desde cache ");

            }else{

                // actions
                this.server.download(url);

                // Post-actions
                this.addUrlCache(url);

            }
        }
        else{

            System.out.println("La descarga de " + url + " esta prohibida en el Pais");

        }


    }

    public void addUrlCache(String url){
         this.downloadsCache.put(url, url);
    }




}
