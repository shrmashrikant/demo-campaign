package com.report.demo.mapper;

import com.report.demo.model.Campaign;
import com.report.demo.request.CampaignRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CampaignMapper {
    @Mapping(target = "campaign_id", source = "campaign_id")
    @Mapping(target = "createdAt", source = "request.created_at", qualifiedByName = "StringToLocalDate")
    @Mapping(target = "updatedAt", source = "request.updated_at", qualifiedByName = "StringToLocalDate")
    Campaign responseToEntity(CampaignRequest request, Long campaign_id);


    @Named("StringToLocalDate")
    default LocalDate StringToLocalDate(String dateTime) {
        return LocalDate.from(LocalDateTime.parse((dateTime.replace("Z", ""))));
    }



}
