package com.design_patterns.prototype.controller;

import com.design_patterns.prototype.model.MarketingCampaign;
import com.design_patterns.prototype.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping("/manual")
    public Map<String, MarketingCampaign> manualCampaigns() {
        MarketingCampaign summer = campaignService.createSummerCampaign();
        MarketingCampaign christmas = campaignService.createChristmasCampaign();
        MarketingCampaign newYear = campaignService.createNewYearCampaign();

        Map<String, MarketingCampaign> campaigns = new HashMap<>();
        campaigns.put("summer", summer);
        campaigns.put("christmas", christmas);
        campaigns.put("newYear", newYear);

        return campaigns;
    }
}
