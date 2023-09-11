package com.report.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.report.demo.response.PublisherDetailRequest;
import com.report.demo.response.StatsRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "campaign")
@Data
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Campaign extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_generator")
    @SequenceGenerator(name = "campaign_generator", sequenceName = "campaign_seq", initialValue = 10)
    @Column(name = "campaign_id")
    private Long campaign_id;

    @Column(name = "serial_number")
    private Long serial_number;

    @Column(name = "id")
    private String id;

    @Column(name = "title")
    @NotBlank(message = "title cannot be null")
    private String title;

    @Column(name = "source_title")
    @NotBlank(message = "traffic source cannot be null")
    private String source_title;

    @Column(name = "domain")
    @NotBlank(message = "domain cannot be null")
    private String domain;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "stats_id", referencedColumnName = "stats_id")
    private Stat stats;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "publisher_details_id", referencedColumnName = "publisher_details_id")
    private PublisherDetails publisherDetails;

    @Column(name = "add_to_cart")
    @NotBlank(message = "add to cart")
    private String addToCart;

    @Column(name = "purchase")
    @NotBlank(message = "purchase")
    private String purchase;

    @Column(name = "created_at")
    @NotBlank(message = "created_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    @NotBlank(message = "updated_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private LocalDate updatedAt;

    @JsonIgnoreProperties("user_id")
    private String userId;

    @JsonIgnoreProperties("source_id")
    private String sourceId;

    @JsonIgnoreProperties(value = "source_campaign_id")
    private String sourceCampaignId;

    @JsonIgnoreProperties(value = "domain_id")
    private String domainId;

    @JsonIgnoreProperties("trackback_url")
    private String trackbackUrl;

    @JsonIgnoreProperties(value = "impression_url")
    private String impressionUrl;

    @JsonIgnoreProperties(value = "cpc")
    private String cpc;

    @JsonIgnoreProperties("coupon")
    private String coupon;

}
