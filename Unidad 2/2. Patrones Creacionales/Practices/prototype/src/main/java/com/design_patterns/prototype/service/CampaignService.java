package com.design_patterns.prototype.service;

import com.design_patterns.prototype.model.MarketingCampaign;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

@Service
public class CampaignService {

    public MarketingCampaign createSummerCampaign() {
        return new MarketingCampaign(
                "Campaña Verano 2025",
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 8, 30),
                List.of("Email", "Facebook Ads", "Google Ads")
        );
    }

    public MarketingCampaign createChristmasCampaign() {
        // 👇 Código repetido innecesariamente (excepto por nombre y fechas)
        return new MarketingCampaign(
                "Campaña Navidad 2025",
                LocalDate.of(2025, 11, 20),
                LocalDate.of(2026, 1, 5),
                List.of("Email", "Facebook Ads", "Google Ads")
        );
    }

    public MarketingCampaign createNewYearCampaign() {
        return new MarketingCampaign(
                "Campaña Año Nuevo 2026",
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 1, 31),
                List.of("Email", "Facebook Ads", "Google Ads")
        );
    }
}
