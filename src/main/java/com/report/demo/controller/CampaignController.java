package com.report.demo.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.report.demo.response.Items;
import com.report.demo.service.CampaignService;
import com.report.demo.service.OkHttpsApiService;
import com.report.demo.utils.ApiBasicConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = ApiBasicConfig.CAMPAIGN)
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;
    private final OkHttpsApiService okHttpsApiService;

    @GetMapping("/get")
    public ResponseEntity<String> campaignsModels() throws IOException {
        Gson gson = new Gson();
        JsonObject entity = gson.fromJson(okHttpsApiService.getCampaignData(ApiBasicConfig.CAMPAIGN_API_DATA_BY_FILTER).string(), JsonObject.class);
        return new ResponseEntity<>(campaignService.saveAggregatedByDay(gson.fromJson(entity, Items.class)), HttpStatus.OK);
    }
}
