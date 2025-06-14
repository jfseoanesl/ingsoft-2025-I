package com.design_patterns.prototype.model;

import com.design_patterns.prototype.model.prototype.IPrototype;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarketingCampaign implements IPrototype {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> channels;

    public MarketingCampaign(String name, LocalDate startDate, LocalDate endDate, List<String> channels) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.channels = channels;
    }

    public MarketingCampaign(MarketingCampaign origin){
        this.name = origin.name;
        this.startDate = origin.startDate;
        this.endDate = origin.endDate;
        this.channels = new ArrayList<>(origin.getChannels());
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "MarketingCampaign{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", channels=" + channels +
                '}';
    }

    @Override
    public MarketingCampaign clone() {
        try {
            return  (MarketingCampaign)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MarketingCampaign deepClone() {
        return new MarketingCampaign(this);
    }
}
