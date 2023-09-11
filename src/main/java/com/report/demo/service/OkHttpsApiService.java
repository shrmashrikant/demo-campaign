package com.report.demo.service;

import okhttp3.ResponseBody;

import java.io.IOException;

public interface OkHttpsApiService {
    ResponseBody getCampaignData(String url) throws IOException;
}
