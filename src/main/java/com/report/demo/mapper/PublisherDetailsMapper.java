package com.report.demo.mapper;

import com.report.demo.model.PublisherDetails;
import com.report.demo.request.PublisherDetailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PublisherDetailsMapper {
    @Mapping(target = "id", source = "id")
    PublisherDetails responseToEntity(PublisherDetailRequest request,Long id);

}
