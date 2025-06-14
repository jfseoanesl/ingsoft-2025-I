package org.example.urlaccesscomponent;

import java.util.HashMap;
import java.util.Map;

public class UrlAccessService {

    private static Map<String, String> urlsRestricted = new HashMap<>();

    public static void addRestrictedUrl(String url){
        UrlAccessService.urlsRestricted.put(url, url);
    }

    public static boolean urlAccessValidate(String url){

        return !UrlAccessService.urlsRestricted.containsKey(url);

    }


}
