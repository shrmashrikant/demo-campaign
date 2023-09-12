package com.report.demo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CampaignRequest {

    @JsonIgnoreProperties(value = "id")
    private String id;
    @JsonIgnoreProperties(value = "serial_number")
    private Long serial_number;

    @JsonIgnoreProperties("user_id")
    private String userId;

    @JsonIgnoreProperties(value = "title")
    private String title;

    @JsonIgnoreProperties("source_id")
    private String sourceId;

    @JsonIgnoreProperties(value = "source_title")
    private String source_title;

    @JsonIgnoreProperties(value = "source_campaign_id")
    private String sourceCampaignId;

    @JsonIgnoreProperties(value = "domain_id")
    private String domainId;

    @JsonIgnoreProperties("trackback_url")
    private String trackbackUrl;

    @JsonIgnoreProperties(value = "impression_url")
    private String impressionUrl;

    @JsonIgnoreProperties(value = "stat")
    private StatsRequest stat;
    @JsonIgnoreProperties(value = "publisher_details")
    private PublisherDetailRequest publisher_details;

    @JsonIgnoreProperties(value = "addToCard")
    private String addToCart;

    @JsonIgnoreProperties(value = "purchase")
    private String purchase;

    @JsonIgnoreProperties(value = "created_at")
    private String created_at;

    @JsonIgnoreProperties(value = "updated_at")
    private String updated_at;

    @JsonIgnoreProperties(value = "cpc")
    private String cpc;

    @JsonIgnoreProperties("coupon")
    private String coupon;
}


