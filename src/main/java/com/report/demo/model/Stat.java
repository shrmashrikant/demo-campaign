package com.report.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity(name = "stats")
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties("stats")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stats_generator")
    @SequenceGenerator(name = "stats_generator", sequenceName = "stats_seq", initialValue = 10)
    @Column(name = "stats_id")
    private Long id;

    @JsonIgnoreProperties(value = "aov")
    private double aov;

    @JsonIgnoreProperties(value = "approved")
    private int approved;

    @JsonIgnoreProperties(value = "approved_cr")
    private int approved_cr;

    @JsonIgnoreProperties(value = "attribution")
    private int attribution;

    @JsonIgnoreProperties(value = "attribution_rate")
    private int attribution_rate;

    @JsonIgnoreProperties(value = "baddevice")
    private int baddevice;

    @JsonIgnoreProperties(value = "baddevice_rate")
    private int baddevice_rate;

    @JsonIgnoreProperties(value = "blacklist")
    private int blacklist;

    @JsonIgnoreProperties(value = "blacklist_rate")
    private int blacklist_rate;

    @JsonIgnoreProperties(value = "clicks")
    private int clicks;

    @JsonIgnoreProperties(value = "conversions")
    private int conversions;

    @JsonIgnoreProperties(value = "convtype1")
    private int convtype1;


    @JsonIgnoreProperties(value = "cost")
    private int cost;

    @JsonIgnoreProperties(value = "cpa")
    private int cpa;

    @JsonIgnoreProperties(value = "cpc")
    private int cpc;

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

    @JsonIgnoreProperties(value = "declined")
    private int declined;

    @JsonIgnoreProperties(value = "declined_cr")
    private int declined_cr;

    @JsonIgnoreProperties(value = "default_aov")
    private double default_aov;

    @JsonIgnoreProperties(value = "default_cost")
    private int default_cost;

    @JsonIgnoreProperties(value = "default_cpa")
    private int default_cpa;

    @JsonIgnoreProperties(value = "default_cr")
    private double default_cr;

    @JsonIgnoreProperties(value = "default_profit")
    private double default_profit;

    @JsonIgnoreProperties(value = "default_roas")
    private int default_roas;

    @JsonIgnoreProperties(value = "default_roi")
    private int default_roi;

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

    @JsonIgnoreProperties(value = "other_cr")
    private int other_cr;

    @JsonIgnoreProperties(value = "pending")
    private int pending;

    @JsonIgnoreProperties(value = "pending_cr")
    private int pending_cr;

    @JsonIgnoreProperties(value = "prelp_clicks")
    private int prelp_clicks;

    @JsonIgnoreProperties(value = "prelp_clicks_cr")
    private int prelp_clicks_cr;

    @JsonIgnoreProperties(value = "prelp_clicks_ctr")
    private int prelp_clicks_ctr;

    @JsonIgnoreProperties(value = "prelp_views")
    private int prelp_views;

    @JsonIgnoreProperties(value = "prelp_views_cr")
    private int prelp_views_cr;

    @JsonIgnoreProperties(value = "profit")
    private double profit;

    @JsonIgnoreProperties(value = "pub_revenue")
    private int pub_revenue;

    @JsonIgnoreProperties(value = "pub_revenue_legacy")
    private int pub_revenue_legacy;

    @JsonIgnoreProperties(value = "revenue")
    private double revenue;

    @JsonIgnoreProperties(value = "revenuetype1")
    private int revenuetype1;

    @JsonIgnoreProperties(value = "revenuetype10")
    private int revenuetype10;

    @JsonIgnoreProperties(value = "revenuetype11")
    private int revenuetype11;

    @JsonIgnoreProperties(value = "revenuetype12")
    private int revenuetype12;

    @JsonIgnoreProperties(value = "revenuetype13")
    private int revenuetype13;

    @JsonIgnoreProperties(value = "revenuetype14")
    private int revenuetype14;

    @JsonIgnoreProperties(value = "revenuetype15")
    private int revenuetype15;

    @JsonIgnoreProperties(value = "revenuetype16")
    private int revenuetype16;

    @JsonIgnoreProperties(value = "revenuetype17")
    private int revenuetype17;

    @JsonIgnoreProperties(value = "revenuetype18")
    private int revenuetype18;

    @JsonIgnoreProperties(value = "revenuetype19")
    private int revenuetype19;

    @JsonIgnoreProperties(value = "revenuetype2")
    private int revenuetype2;

    @JsonIgnoreProperties(value = "revenuetype20")
    private int revenuetype20;

    @JsonIgnoreProperties(value = "revenuetype3")
    private int revenuetype3;

    @JsonIgnoreProperties(value = "revenuetype4")
    private int revenuetype4;

    @JsonIgnoreProperties(value = "revenuetype5")
    private int revenuetype5;

    @JsonIgnoreProperties(value = "revenuetype6")
    private int revenuetype6;

    @JsonIgnoreProperties(value = "revenuetype7")
    private int revenuetype7;

    @JsonIgnoreProperties(value = "revenuetype8")
    private int revenuetype8;

    @JsonIgnoreProperties(value = "revenuetype9")
    private int revenuetype9;

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

    @JsonIgnoreProperties(value = "type10_aov")
    private int type10_aov;

    @JsonIgnoreProperties(value = "type10_cost")
    private int type10_cost;

    @JsonIgnoreProperties(value = "type10_cpa")
    private int type10_cpa;

    @JsonIgnoreProperties(value = "type10_cr")
    private int type10_cr;

    @JsonIgnoreProperties(value = "type10_profit")
    private int type10_profit;

    @JsonIgnoreProperties(value = "type10_roas")
    private int type10_roas;

    @JsonIgnoreProperties(value = "type10_roi")
    private int type10_roi;

    @JsonIgnoreProperties(value = "type11_aov")
    private int type11_aov;

    @JsonIgnoreProperties(value = "type11_cost")
    private int type11_cost;

    @JsonIgnoreProperties(value = "type11_cpa")
    private int type11_cpa;

    @JsonIgnoreProperties(value = "type11_cr")
    private int type11_cr;

    @JsonIgnoreProperties(value = "type11_profit")
    private int type11_profit;

    @JsonIgnoreProperties(value = "type11_roas")
    private int type11_roas;

    @JsonIgnoreProperties(value = "type11_roi")
    private int type11_roi;

    @JsonIgnoreProperties(value = "type12_aov")
    private int type12_aov;

    @JsonIgnoreProperties(value = "type12_cost")
    private int type12_cost;

    @JsonIgnoreProperties(value = "type12_cpa")
    private int type12_cpa;

    @JsonIgnoreProperties(value = "type12_cr")
    private int type12_cr;

    @JsonIgnoreProperties(value = "type12_profit")
    private int type12_profit;

    @JsonIgnoreProperties(value = "type12_roas")
    private int type12_roas;

    @JsonIgnoreProperties(value = "type12_roi")
    private int type12_roi;

    @JsonIgnoreProperties(value = "type13_aov")
    private int type13_aov;

    @JsonIgnoreProperties(value = "type13_cost")
    private int type13_cost;

    @JsonIgnoreProperties(value = "type13_cpa")
    private int type13_cpa;

    @JsonIgnoreProperties(value = "type13_cr")
    private int type13_cr;

    @JsonIgnoreProperties(value = "type13_profit")
    private int type13_profit;

    @JsonIgnoreProperties(value = "type13_roas")
    private int type13_roas;

    @JsonIgnoreProperties(value = "type13_roi")
    private int type13_roi;

    @JsonIgnoreProperties(value = "type14_aov")
    private int type14_aov;

    @JsonIgnoreProperties(value = "type14_cost")
    private int type14_cost;

    @JsonIgnoreProperties(value = "type14_cpa")
    private int type14_cpa;

    @JsonIgnoreProperties(value = "type14_cr")
    private int type14_cr;

    @JsonIgnoreProperties(value = "type14_profit")
    private int type14_profit;

    @JsonIgnoreProperties(value = "type14_roas")
    private int type14_roas;

    @JsonIgnoreProperties(value = "type14_roi")
    private int type14_roi;

    @JsonIgnoreProperties(value = "type15_aov")
    private int type15_aov;

    @JsonIgnoreProperties(value = "type15_cost")
    private int type15_cost;

    @JsonIgnoreProperties(value = "type15_cpa")
    private int type15_cpa;

    @JsonIgnoreProperties(value = "type15_cr")
    private int type15_cr;

    @JsonIgnoreProperties(value = "type15_profit")
    private int type15_profit;

    @JsonIgnoreProperties(value = "type15_roas")
    private int type15_roas;

    @JsonIgnoreProperties(value = "type15_roi")
    private int type15_roi;

    @JsonIgnoreProperties(value = "type16_aov")
    private int type16_aov;

    @JsonIgnoreProperties(value = "type16_cost")
    private int type16_cost;

    @JsonIgnoreProperties(value = "type16_cpa")
    private int type16_cpa;

    @JsonIgnoreProperties(value = "type16_cr")
    private int type16_cr;

    @JsonIgnoreProperties(value = "type16_profit")
    private int type16_profit;

    @JsonIgnoreProperties(value = "type16_roas")
    private int type16_roas;

    @JsonIgnoreProperties(value = "type16_roi")
    private int type16_roi;

    @JsonIgnoreProperties(value = "type17_aov")
    private int type17_aov;

    @JsonIgnoreProperties(value = "type17_cost")
    private int type17_cost;

    @JsonIgnoreProperties(value = "type17_cpa")
    private int type17_cpa;

    @JsonIgnoreProperties(value = "type17_cr")
    private int type17_cr;

    @JsonIgnoreProperties(value = "type17_profit")
    private int type17_profit;

    @JsonIgnoreProperties(value = "type17_roas")
    private int type17_roas;

    @JsonIgnoreProperties(value = "type17_roi")
    private int type17_roi;

    @JsonIgnoreProperties(value = "type18_aov")
    private int type18_aov;

    @JsonIgnoreProperties(value = "type18_cost")
    private int type18_cost;

    @JsonIgnoreProperties(value = "type18_cpa")
    private int type18_cpa;

    @JsonIgnoreProperties(value = "type18_cr")
    private int type18_cr;

    @JsonIgnoreProperties(value = "type18_profit")
    private int type18_profit;

    @JsonIgnoreProperties(value = "type18_roas")
    private int type18_roas;

    @JsonIgnoreProperties(value = "type18_roi")
    private int type18_roi;

    @JsonIgnoreProperties(value = "type19_aov")
    private int type19_aov;

    @JsonIgnoreProperties(value = "type19_cost")
    private int type19_cost;

    @JsonIgnoreProperties(value = "type19_cpa")
    private int type19_cpa;

    @JsonIgnoreProperties(value = "type19_cr")
    private int type19_cr;

    @JsonIgnoreProperties(value = "type19_profit")
    private int type19_profit;

    @JsonIgnoreProperties(value = "type19_roas")
    private int type19_roas;

    @JsonIgnoreProperties(value = "type19_roi")
    private int type19_roi;

    @JsonIgnoreProperties(value = "type1_aov")
    private int type1_aov;

    @JsonIgnoreProperties(value = "type1_cost")
    private int type1_cost;

    @JsonIgnoreProperties(value = "type1_cpa")
    private int type1_cpa;

    @JsonIgnoreProperties(value = "type1_cr")
    private int type1_cr;

    @JsonIgnoreProperties(value = "type1_profit")
    private int type1_profit;

    @JsonIgnoreProperties(value = "type1_roas")
    private int type1_roas;

    @JsonIgnoreProperties(value = "type1_roi")
    private int type1_roi;

    @JsonIgnoreProperties(value = "type20_aov")
    private int type20_aov;

    @JsonIgnoreProperties(value = "type20_cost")
    private int type20_cost;

    @JsonIgnoreProperties(value = "type20_cpa")
    private int type20_cpa;

    @JsonIgnoreProperties(value = "type20_cr")
    private int type20_cr;

    @JsonIgnoreProperties(value = "type20_profit")
    private int type20_profit;

    @JsonIgnoreProperties(value = "type20_roas")
    private int type20_roas;

    @JsonIgnoreProperties(value = "type20_roi")
    private int type20_roi;

    @JsonIgnoreProperties(value = "type2_aov")
    private int type2_aov;

    @JsonIgnoreProperties(value = "type2_cost")
    private int type2_cost;

    @JsonIgnoreProperties(value = "type2_cpa")
    private int type2_cpa;

    @JsonIgnoreProperties(value = "type2_cr")
    private int type2_cr;

    @JsonIgnoreProperties(value = "type2_profit")
    private int type2_profit;

    @JsonIgnoreProperties(value = "type2_roas")
    private int type2_roas;

    @JsonIgnoreProperties(value = "type2_roi")
    private int type2_roi;

    @JsonIgnoreProperties(value = "type3_aov")
    private int type3_aov;

    @JsonIgnoreProperties(value = "type3_cost")
    private int type3_cost;

    @JsonIgnoreProperties(value = "type3_cpa")
    private int type3_cpa;

    @JsonIgnoreProperties(value = "type3_cr")
    private int type3_cr;

    @JsonIgnoreProperties(value = "type3_profit")
    private int type3_profit;

    @JsonIgnoreProperties(value = "type3_roas")
    private int type3_roas;

    @JsonIgnoreProperties(value = "type3_roi")
    private int type3_roi;

    @JsonIgnoreProperties(value = "type4_aov")
    private int type4_aov;

    @JsonIgnoreProperties(value = "type4_cost")
    private int type4_cost;

    @JsonIgnoreProperties(value = "type4_cpa")
    private int type4_cpa;

    @JsonIgnoreProperties(value = "type4_cr")
    private int type4_cr;

    @JsonIgnoreProperties(value = "type4_profit")
    private int type4_profit;

    @JsonIgnoreProperties(value = "type4_roas")
    private int type4_roas;

    @JsonIgnoreProperties(value = "type4_roi")
    private int type4_roi;

    @JsonIgnoreProperties(value = "type5_aov")
    private int type5_aov;

    @JsonIgnoreProperties(value = "type5_cost")
    private int type5_cost;

    @JsonIgnoreProperties(value = "type5_cpa")
    private int type5_cpa;

    @JsonIgnoreProperties(value = "type5_cr")
    private int type5_cr;

    @JsonIgnoreProperties(value = "type5_profit")
    private int type5_profit;

    @JsonIgnoreProperties(value = "type5_roas")
    private int type5_roas;

    @JsonIgnoreProperties(value = "type5_roi")
    private int type5_roi;

    @JsonIgnoreProperties(value = "type6_aov")
    private int type6_aov;

    @JsonIgnoreProperties(value = "type6_cost")
    private int type6_cost;

    @JsonIgnoreProperties(value = "type6_cpa")
    private int type6Cpa;

    @JsonIgnoreProperties(value = "type6_cr")
    private int type6Cr;

    @JsonIgnoreProperties(value = "type6_profit")
    private int type6Profit;

    @JsonIgnoreProperties(value = "type6_roas")
    private int type6Roas;

    @JsonIgnoreProperties(value = "type6_roi")
    private int type6Roi;

    @JsonIgnoreProperties(value = "type7_aov")
    private int type7Aov;

    @JsonIgnoreProperties(value = "type7_cost")
    private int type7Cost;

    @JsonIgnoreProperties(value = "unique_clicks")
    private int uniqueClicks;

    @JsonIgnoreProperties(value = "convtype5")
    private String convtype5;
}
