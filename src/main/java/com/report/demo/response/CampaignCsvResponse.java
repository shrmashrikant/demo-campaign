package com.report.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.report.demo.request.PublisherDetailRequest;
import com.report.demo.request.StatsRequest;

public class CampaignCsvResponse {
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

    //public details
    @JsonIgnoreProperties(value = "description")
    private String description;

    @JsonIgnoreProperties(value = "preview")
    private String preview;

    @JsonIgnoreProperties(value = "preview_url")
    private String preview_url;

    @JsonIgnoreProperties(value = "advertiser")
    private String advertiser;

    @JsonIgnoreProperties(value = "domain")
    private String domain;

    //stat
    @JsonIgnoreProperties(value = "aov")
    private double aov;


    @JsonIgnoreProperties(value = "approved_cr")
    private int approved_cr;

    @JsonIgnoreProperties(value = "attribution")
    private int attribution;

    @JsonIgnoreProperties(value = "attribution_rate")
    private int attribution_rate;

    @JsonIgnoreProperties(value = "cost")
    private int cost;

    @JsonIgnoreProperties(value = "cpa")
    private int cpa;

    @JsonIgnoreProperties(value = "cpt")
    private int cpt;

    @JsonIgnoreProperties(value = "cr")
    private double cr;

    @JsonIgnoreProperties(value = "ctr")
    private int ctr;

    @JsonIgnoreProperties(value = "datacenter")
    private int datacenter;

    @JsonIgnoreProperties(value = "datacenter_rate")
    private int datacenter_rate;
    @JsonIgnoreProperties(value = "epc")
    private double epc;

    @JsonIgnoreProperties(value = "epc_lp")
    private double epc_lp;

    @JsonIgnoreProperties(value = "epc_roi")
    private int epcRoi;

    @JsonIgnoreProperties(value = "epuc")
    private int epuc;

    @JsonIgnoreProperties(value = "epv")
    private double epv;

    @JsonIgnoreProperties(value = "impressions")
    private int impressions;

    @JsonIgnoreProperties(value = "impressions_visible")
    private int impressions_visible;

    @JsonIgnoreProperties(value = "lp_clicks")
    private int lp_clicks;

    @JsonIgnoreProperties(value = "lp_clicks_cr")
    private double lp_clicks_cr;

    @JsonIgnoreProperties(value = "lp_clicks_ctr")
    private double lp_clicks_ctr;

    @JsonIgnoreProperties(value = "lp_ctr")
    private double lp_ctr;

    @JsonIgnoreProperties(value = "lp_views")
    private int lp_views;

    @JsonIgnoreProperties(value = "lp_views_cr")
    private double lp_views_cr;

    @JsonIgnoreProperties(value = "ok")
    private int ok;

    @JsonIgnoreProperties(value = "ok_rate")
    private int ok_rate;

    @JsonIgnoreProperties(value = "other")
    private int other;
    @JsonIgnoreProperties(value = "profit")
    private double profit;
    @JsonIgnoreProperties(value = "revenue")
    private double revenue;

    @JsonIgnoreProperties(value = "roas")
    private int roas;

    @JsonIgnoreProperties(value = "roi")
    private int roi;

    @JsonIgnoreProperties(value = "total_conversions")
    private int total_conversions;

    @JsonIgnoreProperties(value = "total_revenue")
    private double total_revenue;

    @JsonIgnoreProperties(value = "tr")
    private int tr;

    @JsonIgnoreProperties(value = "transactions")
    private int transactions;
    @JsonIgnoreProperties(value = "unique_clicks")
    private int uniqueClicks;
    //addtocart
    @JsonIgnoreProperties(value = "convtype5")
    private String convtype5;
}
