package com.report.demo.service;

import com.report.demo.request.Items;
import com.report.demo.response.CampaignCsvResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public interface CampaignService {
    String addAll(Items items);
    String saveAggregatedByDay(Items items);
    String saveDataByDateRenge(Items items);

    CampaignCsvResponse downloadCsv(LocalDate fromDate,LocalDate toDate);
    Map<String,Object> exportToExcelCampaignData(String fromDate,String toDate) throws IOException;

}
