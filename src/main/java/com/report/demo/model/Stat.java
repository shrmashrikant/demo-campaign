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
    private int approvedCr;

    @JsonIgnoreProperties(value = "attribution")
    private int attribution;

    @JsonIgnoreProperties(value = "attribution_rate")
    private int attributionRate;

    @JsonIgnoreProperties(value = "baddevice")
    private int baddevice;

    @JsonIgnoreProperties(value = "baddevice_rate")
    private int baddeviceRate;

    @JsonIgnoreProperties(value = "blacklist")
    private int blacklist;

    @JsonIgnoreProperties(value = "blacklist_rate")
    private int blacklistRate;

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
    private int datacenterRate;

    @JsonIgnoreProperties(value = "declined")
    private int declined;

    @JsonIgnoreProperties(value = "declined_cr")
    private int declinedCr;

    @JsonIgnoreProperties(value = "default_aov")
    private double defaultAov;

    @JsonIgnoreProperties(value = "default_cost")
    private int defaultCost;

    @JsonIgnoreProperties(value = "default_cpa")
    private int defaultCpa;

    @JsonIgnoreProperties(value = "default_cr")
    private double defaultCr;

    @JsonIgnoreProperties(value = "default_profit")
    private double defaultProfit;

    @JsonIgnoreProperties(value = "default_roas")
    private int defaultRoas;

    @JsonIgnoreProperties(value = "default_roi")
    private int defaultRoi;

    @JsonIgnoreProperties(value = "epc")
    private double epc;

    @JsonIgnoreProperties(value = "epc_lp")
    private double epcLp;

    @JsonIgnoreProperties(value = "epc_roi")
    private int epcRoi;

    @JsonIgnoreProperties(value = "epuc")
    private int epuc;

    @JsonIgnoreProperties(value = "epv")
    private double epv;

    @JsonIgnoreProperties(value = "impressions")
    private int impressions;

    @JsonIgnoreProperties(value = "impressions_visible")
    private int impressionsVisible;

    @JsonIgnoreProperties(value = "lp_clicks")
    private int lpClicks;

    @JsonIgnoreProperties(value = "lp_clicks_cr")
    private double lpClicksCr;

    @JsonIgnoreProperties(value = "lp_clicks_ctr")
    private double lpClicksCtr;

    @JsonIgnoreProperties(value = "lp_ctr")
    private double lpCtr;

    @JsonIgnoreProperties(value = "lp_views")
    private int lpViews;

    @JsonIgnoreProperties(value = "lp_views_cr")
    private double lpViewsCr;

    @JsonIgnoreProperties(value = "ok")
    private int ok;

    @JsonIgnoreProperties(value = "ok_rate")
    private int okRate;

    @JsonIgnoreProperties(value = "other")
    private int other;

    @JsonIgnoreProperties(value = "other_cr")
    private int otherCr;

    @JsonIgnoreProperties(value = "pending")
    private int pending;

    @JsonIgnoreProperties(value = "pending_cr")
    private int pendingCr;

    @JsonIgnoreProperties(value = "prelp_clicks")
    private int prelpClicks;

    @JsonIgnoreProperties(value = "prelp_clicks_cr")
    private int prelpClicksCr;

    @JsonIgnoreProperties(value = "prelp_clicks_ctr")
    private int prelpClicksCtr;

    @JsonIgnoreProperties(value = "prelp_views")
    private int prelpViews;

    @JsonIgnoreProperties(value = "prelp_views_cr")
    private int prelpViewsCr;

    @JsonIgnoreProperties(value = "profit")
    private double profit;

    @JsonIgnoreProperties(value = "pub_revenue")
    private int pubRevenue;

    @JsonIgnoreProperties(value = "pub_revenue_legacy")
    private int pubRevenueLegacy;

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
    private int totalConversions;

    @JsonIgnoreProperties(value = "total_revenue")
    private double totalRevenue;

    @JsonIgnoreProperties(value = "tr")
    private int tr;

    @JsonIgnoreProperties(value = "transactions")
    private int transactions;

    @JsonIgnoreProperties(value = "type10_aov")
    private int type10Aov;

    @JsonIgnoreProperties(value = "type10_cost")
    private int type10Cost;

    @JsonIgnoreProperties(value = "type10_cpa")
    private int type10Cpa;

    @JsonIgnoreProperties(value = "type10_cr")
    private int type10Cr;

    @JsonIgnoreProperties(value = "type10_profit")
    private int type10Profit;

    @JsonIgnoreProperties(value = "type10_roas")
    private int type10Roas;

    @JsonIgnoreProperties(value = "type10_roi")
    private int type10Roi;

    @JsonIgnoreProperties(value = "type11_aov")
    private int type11Aov;

    @JsonIgnoreProperties(value = "type11_cost")
    private int type11Cost;

    @JsonIgnoreProperties(value = "type11_cpa")
    private int type11Cpa;

    @JsonIgnoreProperties(value = "type11_cr")
    private int type11Cr;

    @JsonIgnoreProperties(value = "type11_profit")
    private int type11Profit;

    @JsonIgnoreProperties(value = "type11_roas")
    private int type11Roas;

    @JsonIgnoreProperties(value = "type11_roi")
    private int type11Roi;

    @JsonIgnoreProperties(value = "type12_aov")
    private int type12Aov;

    @JsonIgnoreProperties(value = "type12_cost")
    private int type12Cost;

    @JsonIgnoreProperties(value = "type12_cpa")
    private int type12Cpa;

    @JsonIgnoreProperties(value = "type12_cr")
    private int type12Cr;

    @JsonIgnoreProperties(value = "type12_profit")
    private int type12Profit;

    @JsonIgnoreProperties(value = "type12_roas")
    private int type12Roas;

    @JsonIgnoreProperties(value = "type12_roi")
    private int type12Roi;

    @JsonIgnoreProperties(value = "type13_aov")
    private int type13Aov;

    @JsonIgnoreProperties(value = "type13_cost")
    private int type13Cost;

    @JsonIgnoreProperties(value = "type13_cpa")
    private int type13Cpa;

    @JsonIgnoreProperties(value = "type13_cr")
    private int type13Cr;

    @JsonIgnoreProperties(value = "type13_profit")
    private int type13Profit;

    @JsonIgnoreProperties(value = "type13_roas")
    private int type13Roas;

    @JsonIgnoreProperties(value = "type13_roi")
    private int type13Roi;

    @JsonIgnoreProperties(value = "type14_aov")
    private int type14Aov;

    @JsonIgnoreProperties(value = "type14_cost")
    private int type14Cost;

    @JsonIgnoreProperties(value = "type14_cpa")
    private int type14Cpa;

    @JsonIgnoreProperties(value = "type14_cr")
    private int type14Cr;

    @JsonIgnoreProperties(value = "type14_profit")
    private int type14Profit;

    @JsonIgnoreProperties(value = "type14_roas")
    private int type14Roas;

    @JsonIgnoreProperties(value = "type14_roi")
    private int type14Roi;

    @JsonIgnoreProperties(value = "type15_aov")
    private int type15Aov;

    @JsonIgnoreProperties(value = "type15_cost")
    private int type15Cost;

    @JsonIgnoreProperties(value = "type15_cpa")
    private int type15Cpa;

    @JsonIgnoreProperties(value = "type15_cr")
    private int type15Cr;

    @JsonIgnoreProperties(value = "type15_profit")
    private int type15Profit;

    @JsonIgnoreProperties(value = "type15_roas")
    private int type15Roas;

    @JsonIgnoreProperties(value = "type15_roi")
    private int type15Roi;

    @JsonIgnoreProperties(value = "type16_aov")
    private int type16Aov;

    @JsonIgnoreProperties(value = "type16_cost")
    private int type16Cost;

    @JsonIgnoreProperties(value = "type16_cpa")
    private int type16Cpa;

    @JsonIgnoreProperties(value = "type16_cr")
    private int type16Cr;

    @JsonIgnoreProperties(value = "type16_profit")
    private int type16Profit;

    @JsonIgnoreProperties(value = "type16_roas")
    private int type16Roas;

    @JsonIgnoreProperties(value = "type16_roi")
    private int type16Roi;

    @JsonIgnoreProperties(value = "type17_aov")
    private int type17Aov;

    @JsonIgnoreProperties(value = "type17_cost")
    private int type17Cost;

    @JsonIgnoreProperties(value = "type17_cpa")
    private int type17Cpa;

    @JsonIgnoreProperties(value = "type17_cr")
    private int type17Cr;

    @JsonIgnoreProperties(value = "type17_profit")
    private int type17Profit;

    @JsonIgnoreProperties(value = "type17_roas")
    private int type17Roas;

    @JsonIgnoreProperties(value = "type17_roi")
    private int type17Roi;

    @JsonIgnoreProperties(value = "type18_aov")
    private int type18Aov;

    @JsonIgnoreProperties(value = "type18_cost")
    private int type18Cost;

    @JsonIgnoreProperties(value = "type18_cpa")
    private int type18Cpa;

    @JsonIgnoreProperties(value = "type18_cr")
    private int type18Cr;

    @JsonIgnoreProperties(value = "type18_profit")
    private int type18Profit;

    @JsonIgnoreProperties(value = "type18_roas")
    private int type18Roas;

    @JsonIgnoreProperties(value = "type18_roi")
    private int type18Roi;

    @JsonIgnoreProperties(value = "type19_aov")
    private int type19Aov;

    @JsonIgnoreProperties(value = "type19_cost")
    private int type19Cost;

    @JsonIgnoreProperties(value = "type19_cpa")
    private int type19Cpa;

    @JsonIgnoreProperties(value = "type19_cr")
    private int type19Cr;

    @JsonIgnoreProperties(value = "type19_profit")
    private int type19Profit;

    @JsonIgnoreProperties(value = "type19_roas")
    private int type19Roas;

    @JsonIgnoreProperties(value = "type19_roi")
    private int type19Roi;

    @JsonIgnoreProperties(value = "type1_aov")
    private int type1Aov;

    @JsonIgnoreProperties(value = "type1_cost")
    private int type1Cost;

    @JsonIgnoreProperties(value = "type1_cpa")
    private int type1Cpa;

    @JsonIgnoreProperties(value = "type1_cr")
    private int type1Cr;

    @JsonIgnoreProperties(value = "type1_profit")
    private int type1Profit;

    @JsonIgnoreProperties(value = "type1_roas")
    private int type1Roas;

    @JsonIgnoreProperties(value = "type1_roi")
    private int type1Roi;

    @JsonIgnoreProperties(value = "type20_aov")
    private int type20Aov;

    @JsonIgnoreProperties(value = "type20_cost")
    private int type20Cost;

    @JsonIgnoreProperties(value = "type20_cpa")
    private int type20Cpa;

    @JsonIgnoreProperties(value = "type20_cr")
    private int type20Cr;

    @JsonIgnoreProperties(value = "type20_profit")
    private int type20Profit;

    @JsonIgnoreProperties(value = "type20_roas")
    private int type20Roas;

    @JsonIgnoreProperties(value = "type20_roi")
    private int type20Roi;

    @JsonIgnoreProperties(value = "type2_aov")
    private int type2Aov;

    @JsonIgnoreProperties(value = "type2_cost")
    private int type2Cost;

    @JsonIgnoreProperties(value = "type2_cpa")
    private int type2Cpa;

    @JsonIgnoreProperties(value = "type2_cr")
    private int type2Cr;

    @JsonIgnoreProperties(value = "type2_profit")
    private int type2Profit;

    @JsonIgnoreProperties(value = "type2_roas")
    private int type2Roas;

    @JsonIgnoreProperties(value = "type2_roi")
    private int type2Roi;

    @JsonIgnoreProperties(value = "type3_aov")
    private int type3Aov;

    @JsonIgnoreProperties(value = "type3_cost")
    private int type3Cost;

    @JsonIgnoreProperties(value = "type3_cpa")
    private int type3Cpa;

    @JsonIgnoreProperties(value = "type3_cr")
    private int type3Cr;

    @JsonIgnoreProperties(value = "type3_profit")
    private int type3Profit;

    @JsonIgnoreProperties(value = "type3_roas")
    private int type3Roas;

    @JsonIgnoreProperties(value = "type3_roi")
    private int type3Roi;

    @JsonIgnoreProperties(value = "type4_aov")
    private int type4Aov;

    @JsonIgnoreProperties(value = "type4_cost")
    private int type4Cost;

    @JsonIgnoreProperties(value = "type4_cpa")
    private int type4Cpa;

    @JsonIgnoreProperties(value = "type4_cr")
    private int type4Cr;

    @JsonIgnoreProperties(value = "type4_profit")
    private int type4Profit;

    @JsonIgnoreProperties(value = "type4_roas")
    private int type4Roas;

    @JsonIgnoreProperties(value = "type4_roi")
    private int type4Roi;

    @JsonIgnoreProperties(value = "type5_aov")
    private int type5Aov;

    @JsonIgnoreProperties(value = "type5_cost")
    private int type5Cost;

    @JsonIgnoreProperties(value = "type5_cpa")
    private int type5Cpa;

    @JsonIgnoreProperties(value = "type5_cr")
    private int type5Cr;

    @JsonIgnoreProperties(value = "type5_profit")
    private int type5Profit;

    @JsonIgnoreProperties(value = "type5_roas")
    private int type5Roas;

    @JsonIgnoreProperties(value = "type5_roi")
    private int type5Roi;

    @JsonIgnoreProperties(value = "type6_aov")
    private int type6Aov;

    @JsonIgnoreProperties(value = "type6_cost")
    int type6Cost;

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

    @JsonIgnoreProperties(value = "type7_cpa")
    private int type7Cpa;

    @JsonIgnoreProperties(value = "type7_cr")
    private int type7Cr;

    @JsonIgnoreProperties(value = "type7_profit")
    private int type7Profit;

    @JsonIgnoreProperties(value = "type7_roas")
    private int type7Roas;

    @JsonIgnoreProperties(value = "type7_roi")
    private int type7Roi;

    @JsonIgnoreProperties(value = "type8_aov")
    private int type8Aov;

    @JsonIgnoreProperties(value = "type8_cost")
    private int type8Cost;

    @JsonIgnoreProperties(value = "type8_cpa")
    private int type8Cpa;

    @JsonIgnoreProperties(value = "type8_cr")
    private int type8Cr;

    @JsonIgnoreProperties(value = "type8_profit")
    private int type8Profit;

    @JsonIgnoreProperties(value = "type8_roas")
    private int type8Roas;

    @JsonIgnoreProperties(value = "type8_roi")
    private int type8Roi;

    @JsonIgnoreProperties(value = "type9_aov")
    private int type9Aov;

    @JsonIgnoreProperties(value = "type9_cost")
    private int type9Cost;

    @JsonIgnoreProperties(value = "type9_cpa")
    private int type9Cpa;

    @JsonIgnoreProperties(value = "type9_cr")
    private int type9Cr;

    @JsonIgnoreProperties(value = "type9_profit")
    private int type9Profit;

    @JsonIgnoreProperties(value = "type9_roas")
    private int type9Roas;

    @JsonIgnoreProperties(value = "type9_roi")
    private int type9Roi;

    @JsonIgnoreProperties(value = "unique_clicks")
    private int uniqueClicks;

}
