package com.report.demo.cron;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.report.demo.request.Items;
import com.report.demo.service.CampaignService;
import com.report.demo.service.OkHttpsApiService;
import com.report.demo.utils.ApiBasicConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@ConditionalOnProperty(value = {"app.scheduling.global.enable", "app.scheduling.campaignData.enable"}, havingValue = "true")
@Slf4j
@Component
@AllArgsConstructor
public class CampaignDataCron {
    private final CampaignService campaignService;
    private final OkHttpsApiService okHttpsApiService;

    @Scheduled(cron = "0 0/30 * * * ?")
    @SchedulerLock(name = "campaignData", lockAtLeastFor = "10m", lockAtMostFor = "30m")
    public void migrateLeanAnalystData() throws IOException {
        log.info("cron job for evey 30 mints per day");
        String timeZone = "America/Edmonton";
        log.info("Processing campaignData  by date and campaign title data!!");
        campaignDataModels();
        log.info("Successfully processed campaign data!!");
    }

    private void campaignDataModels() throws IOException {
        Gson gson = new Gson();
        JsonObject entity = gson.fromJson(okHttpsApiService.getCampaignData(String.format(ApiBasicConfig.CAMPAIGN_API_DATA_BY_FILTER, LocalDate.now(),LocalDate.now())).string(), JsonObject.class);
        campaignService.saveAggregatedByDay(gson.fromJson(entity, Items.class));

    }
}
