package com.report.demo.service;

import com.google.gson.JsonObject;
import com.report.demo.response.CampaignRequest;
import com.report.demo.response.Items;

import java.util.List;

public interface CampaignService {
    String addAll(Items items);
    String saveAggregatedByDay(Items items);

}
