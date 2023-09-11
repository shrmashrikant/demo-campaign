package com.report.demo.mapper;

import com.report.demo.model.Stat;
import com.report.demo.response.StatsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StatMapper {
    @Mapping(target = "id", source = "id")
    Stat statResponseToEntity(StatsRequest request,Long id);
}
