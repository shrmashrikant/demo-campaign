package com.report.demo.service.impl;

import com.report.demo.mapper.PublisherDetailsMapper;
import com.report.demo.mapper.StatMapper;
import com.report.demo.model.Campaign;
import com.report.demo.model.PublisherDetails;
import com.report.demo.model.Stat;
import com.report.demo.repositry.CampaignRepository;
import com.report.demo.repositry.PublisherDetailsRepositry;
import com.report.demo.repositry.StatRepository;
import com.report.demo.response.CampaignRequest;
import com.report.demo.response.Items;
import com.report.demo.response.PublisherDetailRequest;
import com.report.demo.response.StatsRequest;
import com.report.demo.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CampaignServiceImpl implements CampaignService {
    private final CampaignRepository campaignRepository;
    private final PublisherDetailsRepositry publisherDetailsRepositry;
    private final StatRepository statRepository;
    private final PublisherDetailsMapper publisherDetailsMapper;
    private final StatMapper statMapper;

    @Override
    public String addAll(Items items) {
       /* for (CampaignRequest campaignRequest : items.getItems()) {
            Campaign campaign = new Campaign();
            Campaign campaigndb = campaignRepository.findByTitleContains(campaignRequest.getTitle());
            if (Objects.nonNull(campaigndb)) {
                campaign.setId(campaigndb.getId());
            }
            campaign.setSerial_number(campaignRequest.getSerial_number());
            campaign.setId(campaignRequest.getId());
            campaign.setTitle(campaignRequest.getTitle());
            campaign.setSource_title(campaignRequest.getSource_title());
            campaign.setStats(statRepository.save(ampaignRequest.getStat(), campaigndb == null ? null : campaigndb.getStats().getId()));
            campaign.setPublisherDetails(publisherDetailsRepositry.save(PublisherDetails.builder().domain(campaignRequest.getPublisher_details().getDomain()).build()));
            campaignRepository.save(campaign);

        }*/
        return "Campaign  Data process Successfully";
    }

    @Transactional
    @Override
    public String saveAggregatedByDay(Items items) {
        for (CampaignRequest campaignRequest : items.getItems()) {
            Campaign campaign = new Campaign();
            //Campaign campaigndb = campaignRepository.findByTitleContains(campaignRequest.getTitle());
            Campaign campaigndb = campaignRepository.findByTitleContainsAndUpdatedAt(campaignRequest.getTitle(), LocalDate.now());
            if (Objects.nonNull(campaigndb)) {
                campaign.setCampaign_id(campaigndb.getCampaign_id());
            }
            campaign.setCreatedAt(LocalDate.from(LocalDateTime.parse((campaignRequest.getCreated_at().replace("Z", "")))));
            campaign.setUpdatedAt(LocalDate.from(LocalDateTime.parse(campaignRequest.getUpdated_at().replace("Z", ""))));
            campaign.setSerial_number(campaignRequest.getSerial_number());
            campaign.setId(campaignRequest.getId());
            campaign.setTitle(campaignRequest.getTitle());
            campaign.setSource_title(campaignRequest.getSource_title());
            campaign.setStats(prepareStat(campaignRequest.getStat(), campaigndb == null ? null : campaigndb.getStats().getId()));
            campaign.setPublisherDetails(preparePublisherDetails(campaignRequest.getPublisher_details(), campaigndb == null ? null : campaigndb.getPublisherDetails().getId()));
            campaignRepository.save(campaign);

        }
        return "Campaign  Data update Successfully";
    }

    private Stat prepareStat(StatsRequest request, Long statsId) {
        Long id = null;
        Stat statDb = statsId == null ? null : statRepository.findById(statsId).get();
        if (statDb != null && statDb.getId() != null) {
            id = statDb.getId();
        }
        return statRepository.save(statMapper.statResponseToEntity(request, id));
    }

    private PublisherDetails preparePublisherDetails(PublisherDetailRequest request, Long publisherId) {
        Long pubId = null;
        PublisherDetails dbPublisherDetails = publisherId == null ? null : publisherDetailsRepositry.findById(publisherId).get();
        if (dbPublisherDetails != null && dbPublisherDetails.getId() != null) {
            pubId = dbPublisherDetails.getId();
        }
        return publisherDetailsRepositry.save(publisherDetailsMapper.responseToEntity(request, pubId));
    }
}
