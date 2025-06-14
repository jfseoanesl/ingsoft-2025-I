package com.design_patterns.prototype.model.prototype;

import com.design_patterns.prototype.model.MarketingCampaign;

public interface IPrototype extends Cloneable{

    MarketingCampaign clone();
    MarketingCampaign deepClone();

}
