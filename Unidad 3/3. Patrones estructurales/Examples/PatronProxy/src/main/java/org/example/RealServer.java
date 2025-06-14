package org.example;

public class RealServer implements IServer{

    private String host;
    private int port;

    public RealServer(String host, int port) {
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
        System.out.println("Descargando: " + url + ", desde host: " + this.host + " y puerto: " + this.port);
    }
}
