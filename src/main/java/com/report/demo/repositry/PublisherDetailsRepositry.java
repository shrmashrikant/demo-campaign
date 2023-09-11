package com.report.demo.repositry;

import com.report.demo.model.Campaign;
import com.report.demo.model.PublisherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherDetailsRepositry extends JpaRepository<PublisherDetails, Long> {
}
