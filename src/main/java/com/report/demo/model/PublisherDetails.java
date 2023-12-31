package com.report.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity(name = "publisher_details")
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties("publisher_details")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PublisherDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_details_generator")
    @SequenceGenerator(name = "publisher_details_generator", sequenceName = "publisher_details_seq", initialValue = 10)
    @Column(name = "publisher_details_id")
    private Long id;

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

    @JsonIgnoreProperties(value = "coupon")
    private String coupon;

    @JsonIgnoreProperties(value = "hide_payout_details")
    private boolean hide_payout_details;

    @JsonIgnoreProperties(value = "campaign_type")
    private String campaign_type;

    @JsonIgnoreProperties(value = "hide_deeplinks")
    private boolean hide_deeplinks;

    @JsonIgnoreProperties(value = "hide_direct_tracking_urls")
    private boolean hide_direct_tracking_urls;

    @JsonIgnoreProperties(value = "hide_redirect_tracking_url")
    private boolean hide_redirect_tracking_url;

    @JsonIgnoreProperties(value = "hide_redirect_impression_url")
    private boolean hide_redirect_impression_url;
}
