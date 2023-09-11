package com.report.demo.repositry;

import com.report.demo.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    Campaign findByTitleContains(String title);

    Campaign findByTitleContainsAndUpdatedAt(String title, LocalDate localDate);
}
