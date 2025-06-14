package org.example;

import org.example.urlaccesscomponent.UrlAccessService;

public class Main {
    public static void main(String[] args) {


        UrlAccessService.addRestrictedUrl("http://3x.com/*");
        UrlAccessService.addRestrictedUrl("http://facebook.com/*");
        UrlAccessService.addRestrictedUrl("http://youtube.com/*");

        IServer server = FactoryServer.createServer("127.0.0.0", 80);
        server.download("http://3x.com/");
        server.download("http://3x.com/");


    }
}