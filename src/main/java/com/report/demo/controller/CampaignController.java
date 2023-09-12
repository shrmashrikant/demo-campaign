package com.report.demo.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.report.demo.request.Items;
import com.report.demo.service.CampaignService;
import com.report.demo.service.OkHttpsApiService;
import com.report.demo.utils.ApiBasicConfig;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping(value = ApiBasicConfig.CAMPAIGN)
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService campaignService;
    private final OkHttpsApiService okHttpsApiService;

    @GetMapping("/get")
    public ResponseEntity<String> campaignsModels() throws IOException {
        Gson gson = new Gson();
        JsonObject entity = gson.fromJson(okHttpsApiService.getCampaignData(String.format(ApiBasicConfig.CAMPAIGN_API_DATA_BY_FILTER, LocalDate.now(), LocalDate.now())).string(), JsonObject.class);
        return new ResponseEntity<>(campaignService.saveAggregatedByDay(gson.fromJson(entity, Items.class)), HttpStatus.OK);
    }

    @GetMapping("/get/detailsByDate")
    public ResponseEntity<String> campaignsByDateReange() throws IOException {
        Gson gson = new Gson();
        JsonObject entity = gson.fromJson(okHttpsApiService.getCampaignData(String.format(ApiBasicConfig.CAMPAIGN_API_DATA_BY_FILTER, "2023-07-01", "2023-08-31")).string(), JsonObject.class);
        return new ResponseEntity<>(campaignService.saveDataByDateRenge(gson.fromJson(entity, Items.class)), HttpStatus.OK);
    }

    @ApiOperation(value = "export Campaign Data report", httpMethod = "GET", tags = "Export To Excel")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "startDate", name = "startDate", paramType = "query", dataType = "String", example = "yyyy-MM-dd", required = true),
            @ApiImplicitParam(value = "endDate", name = "endDate", paramType = "query", dataType = "String", example = "yyyy-MM-dd", required = true),
    })
    @GetMapping(value = "/export", produces = "application/csv")
    public ResponseEntity<ByteArrayResource> exportCampaignToExcel(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws IOException {
        Map<String, Object> map = campaignService.exportToExcelCampaignData(startDate, endDate);
        if (!map.isEmpty()) {
            ByteArrayOutputStream stream = (ByteArrayOutputStream) map.get("stream");
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "octet-stream"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + map.get("fileName") + ";");
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()),
                    header, HttpStatus.CREATED);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error in exporting Signal data Report to excel");
    }

}
