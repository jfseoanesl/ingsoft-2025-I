package com.design_patterns.prototype.service;

import com.design_patterns.prototype.model.MarketingCampaign;
import com.design_patterns.prototype.model.prototype.PrototypeRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private PrototypeRegistry provider;

    public MarketingCampaign createSummerCampaign() {

        MarketingCampaign summer = provider.deepGet("baseCampaign");
        summer.setName("Campaña Verano 2025");
        provider.create("summerCampaign", summer);
        return summer;

    }

    public MarketingCampaign createChristmasCampaign() {

        MarketingCampaign christmas = provider.simpleGet("summerCampaign");
        christmas.setName("Campaña de navidad 2025");
        provider.create("christmasCampaign", christmas);
        return christmas;
    }

    public MarketingCampaign createNewYearCampaign() {

        MarketingCampaign newYear = provider.deepGet("christmasCampaign");
        newYear.setName("Camapañ de Año Nuevo 2026");
        provider.create("newYearCampaign", newYear);
        return newYear;

    }
}
