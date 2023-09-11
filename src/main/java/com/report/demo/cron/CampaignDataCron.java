package com.report.demo.cron;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.report.demo.response.Items;
import com.report.demo.service.CampaignService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import okhttp3.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@ConditionalOnProperty(value = {"app.scheduling.global.enable", "app.scheduling.campaignData.enable"}, havingValue = "true")
@Slf4j
@Component
@AllArgsConstructor
public class CampaignDataCron {
    private final CampaignService campaignService;

    @Scheduled(cron = "0 0/30 * * * ?")
    @SchedulerLock(name = "campaignData", lockAtLeastFor = "10m", lockAtMostFor = "30m")
    public void migrateLeanAnalystData() throws IOException {
        log.info("cron job for evey 30 mints per day");
        String timeZone = "America/Edmonton";
        log.info("Processing campaignData  by date and campaign title data!!");
        signalDataModels();
        log.info("Successfully processed campaign data!!");
    }

    private void signalDataModels() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://app.redtrack.io/api/campaigns?api_key=gLdSPzCc0desNUYeC5fG&time_interval=&tracks_view=true&title=&sources=&status=1&with_clicks=false&tags=&page=1&per=100&sortby=convtype6&direction=desc&timezone=&total=true")
                .method("GET", null)
                .addHeader("Accept", "*/*")
                .addHeader("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Connection", "keep-alive")
                .addHeader("Cookie", "_gcl_au=1.1.699580073.1694086437; rtkclickid-store=64f9b52599ce4e00018df5e9; _cq_duid=1.1694086440.2idvTXAyNOH5bGD7; _cq_suid=1.1694086440.4Xad0hQCdFQv5lWB; _gid=GA1.2.1507014251.1694086440; _fbp=fb.1.1694086440415.652523550; _ga=GA1.1.2116613850.1694086440; crisp-client%2Fsession%2Fb6bfa52f-1aa5-4ede-a021-b3b13a88a929=session_05df54f3-5ac8-4e7c-b3ff-d631bcfc0a06; _ga_P81GL2C1LL=GS1.1.1694091435.3.0.1694091435.60.0.0")
                .addHeader("Pragma", "no-cache")
                .addHeader("Referer", "https://app.redtrack.io/campaigns")
                .addHeader("Sec-Fetch-Dest", "empty")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("sec-ch-ua", "\"Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Linux\"")
                .build();
        Gson gson = new Gson();
        ResponseBody responseBody = client.newCall(request).execute().body();
        JsonObject entity = gson.fromJson(responseBody.string(), JsonObject.class);
        campaignService.saveAggregatedByDay(gson.fromJson(entity, Items.class));


    }
}
