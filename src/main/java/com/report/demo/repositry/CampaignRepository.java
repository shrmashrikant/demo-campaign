package com.report.demo.repositry;

import com.report.demo.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    Campaign findByTitleContains(String title);

    Campaign findByTitleContainsAndUpdatedAt(String title, LocalDate localDate);

    Campaign findByIdAndUpdatedAt(String id, LocalDate localDate);

    Campaign findById(String id);

    List<Campaign> findAllByCreatedAtBetween(LocalDate fromDate, LocalDate toDate);
}
