package com.design_patterns.prototype.model.prototype;

import com.design_patterns.prototype.model.MarketingCampaign;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PrototypeRegistry {

    private Map<String, MarketingCampaign> prototypes = new HashMap<>();

    public PrototypeRegistry(){

        MarketingCampaign prototype = new MarketingCampaign(
                "Campaña Verano 2025",
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 8, 30),
                List.of("Email", "Facebook Ads", "Google Ads")
        );

        this.prototypes.put("baseCampaign", prototype);

    }

    public void create(String name, MarketingCampaign prototype){
        this.prototypes.put(name, prototype);
    }

    public MarketingCampaign simpleGet(String name){

        return this.prototypes.get(name).clone();

    }

    public MarketingCampaign deepGet(String name){

        return this.prototypes.get(name).deepClone();

    }

}
