package com.report.demo.service.impl;

import com.report.demo.mapper.CampaignMapper;
import com.report.demo.mapper.PublisherDetailsMapper;
import com.report.demo.mapper.StatMapper;
import com.report.demo.model.Campaign;
import com.report.demo.model.PublisherDetails;
import com.report.demo.model.Stat;
import com.report.demo.repositry.CampaignRepository;
import com.report.demo.repositry.PublisherDetailsRepositry;
import com.report.demo.repositry.StatRepository;
import com.report.demo.request.CampaignRequest;
import com.report.demo.request.Items;
import com.report.demo.request.PublisherDetailRequest;
import com.report.demo.request.StatsRequest;
import com.report.demo.response.CampaignCsvResponse;
import com.report.demo.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class CampaignServiceImpl implements CampaignService {
    private final CampaignRepository campaignRepository;
    private final PublisherDetailsRepositry publisherDetailsRepositry;
    private final StatRepository statRepository;
    private final PublisherDetailsMapper publisherDetailsMapper;
    private final StatMapper statMapper;
    private final CampaignMapper campaignMapper;
    private static final String CAMPAIGN_DATA_REPORT_SHEET = "Campaign_Report";
    public static final String[] ACTIVITY_HEADER = new String[]{"#", "Title", "Date Created", "Traffic Channel", "Clicks", "LP Click","LP views", "All Conversions", " Revenue","Total Revenue", "Cost","Profit","Total Roi","AddToCart"};
    @Override
    public String addAll(Items items) {
        for (CampaignRequest campaignRequest : items.getItems()) {
            Campaign campaign = new Campaign();
            Campaign campaigndb = campaignRepository.findByTitleContains(campaignRequest.getTitle());
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
            campaign.setPublisher_details(preparePublisherDetails(campaignRequest.getPublisher_details(), campaigndb == null ? null : campaigndb.getPublisher_details().getId()));
            campaignRepository.save(campaign);

        }
        return "Campaign  Data process Successfully";
    }

    @Transactional
    @Override
    public String saveAggregatedByDay(Items items) {
        for (CampaignRequest campaignRequest : items.getItems()) {
            Long campaign_id = null;
            //Campaign campaigndb = campaignRepository.findByTitleContainsAndUpdatedAt(campaignRequest.getTitle(), LocalDate.now());
            Campaign campaigndb = campaignRepository.findByIdAndUpdatedAt(campaignRequest.getId(), LocalDate.now());
            if (Objects.nonNull(campaigndb)) {
                campaign_id = campaigndb.getCampaign_id();
            }
            Campaign campaign = campaignMapper.responseToEntity(campaignRequest, campaign_id);
            campaign.setStats(prepareStat(campaignRequest.getStat(), campaigndb == null ? null : campaigndb.getStats().getId()));
            campaign.setPublisher_details(preparePublisherDetails(campaignRequest.getPublisher_details(), campaigndb == null ? null : campaigndb.getPublisher_details().getId()));
            campaignRepository.save(campaign);

        }
        return "Campaign  Data update Successfully";
    }

    @Override
    public String saveDataByDateRenge(Items items) {
        for (CampaignRequest campaignRequest : items.getItems()) {
            Long campaign_id = null;
            //Campaign campaigndb = campaignRepository.findByTitleContainsAndUpdatedAt(campaignRequest.getTitle(), LocalDate.now());
            Campaign campaigndb = campaignRepository.findById(campaignRequest.getId());
            if (Objects.nonNull(campaigndb)) {
                campaign_id = campaigndb.getCampaign_id();
            }
            Campaign campaign = campaignMapper.responseToEntity(campaignRequest, campaign_id);
            campaign.setStats(prepareStat(campaignRequest.getStat(), campaigndb == null ? null : campaigndb.getStats().getId()));
            campaign.setPublisher_details(preparePublisherDetails(campaignRequest.getPublisher_details(), campaigndb == null ? null : campaigndb.getPublisher_details().getId()));
            campaignRepository.save(campaign);

        }
        return "Campaign  Data update Successfully";
    }

    private Stat prepareStat(StatsRequest request, Long statsId) {
        Long id = null;
        Stat statDb = statsId == null ? null : statRepository.findById(statsId).orElse(null);
        if (statDb != null && statDb.getId() != null) {
            id = statDb.getId();
        }
        return statMapper.statResponseToEntity(request, id);
    }

    private PublisherDetails preparePublisherDetails(PublisherDetailRequest request, Long publisherId) {
        Long pubId = null;
        PublisherDetails dbPublisherDetails = publisherId == null ? null : publisherDetailsRepositry.findById(publisherId).get();
        if (dbPublisherDetails != null && dbPublisherDetails.getId() != null) {
            pubId = dbPublisherDetails.getId();
        }
        return publisherDetailsMapper.responseToEntity(request, pubId);
    }

    @Override
    public CampaignCsvResponse downloadCsv(LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public Map<String, Object> exportToExcelCampaignData(String fromDate, String toDate) throws IOException {
        Integer rowCount = 0;
        List<Campaign> excelData = campaignRepository.findAllByCreatedAtBetween(LocalDate.parse(fromDate),LocalDate.parse(toDate));
        String fileName = CAMPAIGN_DATA_REPORT_SHEET + ".xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet reportSheet = workbook.createSheet(CAMPAIGN_DATA_REPORT_SHEET);
        CellStyle cellStyle = getCellStyle(workbook);
        createDataRows(excelData,
                reportSheet,
                ACTIVITY_HEADER, rowCount, cellStyle);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        workbook.close();
        Map<String, Object> map = new HashMap<>();
        map.put("fileName", fileName);
        map.put("stream", stream);
        return map;
    }
    private Integer createDataRows(List<Campaign> details, XSSFSheet sheet, String[] header, Integer rowCount, CellStyle rowStyle) {
        createHeaderRow(sheet, rowCount, header, rowStyle);
        for (Campaign detail : details) {
            StatsRequest statResponse=statMapper.entityToResponse(detail.getStats());
            Row signalCreateRow = sheet.createRow(++rowCount);
            AtomicInteger cellCount = new AtomicInteger();
            signalCreateRow.createCell(0).setCellValue(detail.getId());
            signalCreateRow.createCell(1).setCellValue(detail.getTitle());
            signalCreateRow.createCell(2).setCellValue(detail.getCreatedAt());
            signalCreateRow.createCell(3).setCellValue(detail.getSource_title());
            signalCreateRow.createCell(4).setCellValue(statResponse.getClicks());
            signalCreateRow.createCell(5).setCellValue(statResponse.getLp_clicks());
            signalCreateRow.createCell(6).setCellValue(statResponse.getLp_views());
            signalCreateRow.createCell(7).setCellValue(statResponse.getTotal_conversions());
            signalCreateRow.createCell(8).setCellValue(statResponse.getRevenue());
            signalCreateRow.createCell(9).setCellValue(statResponse.getTotal_revenue());
            signalCreateRow.createCell(10).setCellValue(statResponse.getCost());
            signalCreateRow.createCell(11).setCellValue(statResponse.getProfit());
            signalCreateRow.createCell(12).setCellValue(statResponse.getRoi());
            signalCreateRow.createCell(13).setCellValue(statResponse.getConvtype5());
        }
        return rowCount;
    }

    private void createHeaderRow(XSSFSheet sheet, Integer rowCount, String[] header, CellStyle style) {
        Row headerRow = sheet.createRow(rowCount);
        // headerRow.setRowStyle(style);
        IntStream.range(0, header.length).forEachOrdered(col -> {
            sheet.autoSizeColumn(col, true);
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(header[col]);
            cell.setCellStyle(style);
        });
    }

    private CellStyle getCellStyle(XSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(10);
        font.getFontName();
        style.setFont(font);
        return style;
    }

}
