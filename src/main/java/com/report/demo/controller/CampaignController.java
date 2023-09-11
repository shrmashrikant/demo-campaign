package com.report.demo.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.report.demo.response.Items;
import com.report.demo.service.CampaignService;
import com.report.demo.utils.ApiBasicConfig;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping(value = ApiBasicConfig.CAMPAIGN)
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;

    @GetMapping("/get")
    public ResponseEntity<String> campaignsModels() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://app.redtrack.io/api/campaigns?api_key=gLdSPzCc0desNUYeC5fG&date_from=2023-08-01&date_to=2023-08-31&time_interval=&tracks_view=true&title=&sources=&status=1&with_clicks=false&tags=&page=1&per=300&sortby=clicks&direction=desc&timezone=America%2FLos_Angeles&total=true")
                .method("GET", null)
                .addHeader("Accept", "*/*")
                .addHeader("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Connection", "keep-alive")
                .addHeader("Cookie", "_gcl_au=1.1.699580073.1694086437; rtkclickid-store=64f9b52599ce4e00018df5e9; _cq_duid=1.1694086440.2idvTXAyNOH5bGD7; _fbp=fb.1.1694086440415.652523550; rtClientId=2116613850.1694086440; _uetvid=556c96104e2f11ee9ad45fc72b7600d0; _rdt_uuid=1694167569881.0ad10c69-690f-4891-a21f-e21ae2eb9745; _hjSessionUser_2681237=eyJpZCI6IjBiOThlMDZhLTQ0ZmEtNWM3My1iYWFlLWZjYmY4ZDY0ZTlmNCIsImNyZWF0ZWQiOjE2OTQxNjc1NzAyNDAsImV4aXN0aW5nIjpmYWxzZX0=; messagesUtk=fb809727bea64ffb8a1ee04866e5c1ce; __hstc=120102935.84a454ccf0c0a825bea51ec6debf64c0.1694167573326.1694167573326.1694167573326.1; hubspotutk=84a454ccf0c0a825bea51ec6debf64c0; _cq_suid=1.1694412262.nQJhDZXGvXKrgss2; _gid=GA1.2.1252141278.1694412262; _ga=GA1.1.2116613850.1694086440; _ga_P81GL2C1LL=GS1.1.1694412262.5.1.1694412278.44.0.0; crisp-client%2Fsession%2Fb6bfa52f-1aa5-4ede-a021-b3b13a88a929=session_67051b73-5e7c-4674-9170-261d978f0dbe")
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
        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        ResponseBody responseBody = client.newCall(request).execute().body();
        JsonObject entity = gson.fromJson(responseBody.string(), JsonObject.class);
        //campaignService.saveAggregatedByDay(gson.fromJson(entity, Items.class));
            return new ResponseEntity<>(campaignService.saveAggregatedByDay(gson.fromJson(entity, Items.class)), HttpStatus.OK);
    }
}
