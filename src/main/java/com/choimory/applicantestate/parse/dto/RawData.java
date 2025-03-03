package com.choimory.applicantestate.parse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RawData {
    @JsonProperty("TITLE")
    private String title;
    @JsonProperty("ADDRESS")
    private String address;
    @JsonProperty("DOC_TYPE")
    private String docType;
    @JsonProperty("EUL_COUNT")
    private String eulCount;
    @JsonProperty("KAP_COUNT")
    private String kapCount;
    @JsonProperty("ISSUE_DATE")
    private String issueDate;
    @JsonProperty("ISSUE_TIME")
    private String issueTime;
    @JsonProperty("LAND_COUNT")
    private String landCount;
    @JsonProperty("SALE_COUNT")
    private String saleCount;
    @JsonProperty("BUILD_COUNT")
    private String buildCount;
    @JsonProperty("DOC_DETAILS")
    private String docDetails;
    @JsonProperty("HOLDER_COUNT")
    private String holderCount;
    @JsonProperty("REAL_ESTATE_NO")
    private String realEstateNo;
    @JsonProperty("OUTPUT_FILENAME")
    private String outputFilename;
    @JsonProperty("REGISTER_OFFICE")
    private String registerOffice;
    @JsonProperty("SUMMARY_A_COUNT")
    private String summaryACount;
    @JsonProperty("SUMMARY_E_COUNT")
    private String summaryECount;
    @JsonProperty("SUMMARY_K_COUNT")
    private String summaryKCount;
    @JsonProperty("COLLATERAL_COUNT")
    private String collateralCount;
    @JsonProperty("COLLATERAL1_COUNT")
    private String collateralOneCount;
    @JsonProperty("COLLATERAL2_COUNT")
    private String collateralTwoCount;
    @JsonProperty("COLLATERAL3_COUNT")
    private String collateralThreeCount;
    @JsonProperty("COLLATERAL4_COUNT")
    private String collateralFourCount;
    @JsonProperty("BUILD_DATA")
    private List<BuildData> builds;
    @JsonProperty("COLLATERAL4_DATA")
    private List<CollateralFourData> collateralFourDataList;
    @JsonProperty("COLLATERAL1_DATA")
    private List<CollateralOneData> collateralOneDataList;
    @JsonProperty("COLLATERAL3_DATA")
    private List<CollateralThreeData> collateralThreeDataList;
    @JsonProperty("COLLATERAL2_DATA")
    private List<CollateralTwoData> collateralTwoDataList;
    @JsonProperty("EUL_DATA")
    private List<EulData> eulDataList;
    @JsonProperty("HOLDER_DATA")
    private List<HolderData> holderDataList;
    @JsonProperty("KAP_DATA")
    private List<KapData> kapDataList;
    @JsonProperty("LAND_DATA")
    private List<LandData> landDataList;
    @JsonProperty("SALE_DATA")
    private List<SaleData> saleData;
    @JsonProperty("SUMMARY_A_DATA")
    private List<SummaryAData> summaryADataList;
    @JsonProperty("SUMMARY_E_DATA")
    private List<SummaryEData> summaryEDataList;
    @JsonProperty("SUMMARY_K_DATA")
    private List<SummaryKData> summaryKDataList;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class EulData {
    @JsonProperty("EUL_SEPARATOR")
    private String eulSeparator;
    @JsonProperty("EUL_REASON")
    private String eulReason;
    @JsonProperty("EUL_DOC_TYPE")
    private String eulDocType;
    @JsonProperty("EUL_ACCEPT")
    private String eulAccept;
    @JsonProperty("EUL_NO")
    private String eulNo;
    @JsonProperty("EUL_ETC")
    private String eulEtc;
    @JsonProperty("EUL_PURPOSE")
    private String eulPurpose;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class KapData {
    @JsonProperty("KAP_ACCEPT")
    private String kapAccept;
    @JsonProperty("KAP_NO")
    private String kapNo;
    @JsonProperty("KAP_REASON")
    private String kapReason;
    @JsonProperty("KAP_PURPOSE")
    private String kapPurpose;
    @JsonProperty("KAP_SEPARATOR")
    private String kapSeparator;
    @JsonProperty("KAP_DOC_TYPE")
    private String kapDocType;
    @JsonProperty("KAP_ETC")
    private String kapEtc;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class CollateralOneData {
    @JsonProperty("COLLATERAL1_SEPARATOR")
    private String collateralOneSeparator;
    @JsonProperty("COLLATERAL1_BUILD_NAME")
    private String collateralOneBuildName;
    @JsonProperty("COLLATERAL1_ACCEPT")
    private String collateralOneAccept;
    @JsonProperty("COLLATERAL1_BUILD_CONTENT")
    private String collateralOneBuildContent;
    @JsonProperty("COLLATERAL1_DOC_TYPE")
    private String collateralOneDocType;
    @JsonProperty("COLLATERAL1_NO")
    private String collateralOneNo;
    @JsonProperty("COLLATERAL1_ETC")
    private String collateralOneEtc;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class CollateralTwoData {
    @JsonProperty("COLLATERAL2_ETC")
    private String collateralTwoEtc;
    @JsonProperty("COLLATERAL2_DOC_TYPE")
    private String collateralTwoDocType;
    @JsonProperty("COLLATERAL2_LAND_CATEGORY")
    private String collateralTwoLandCategory;
    @JsonProperty("COLLATERAL2_SEPARATOR")
    private String collateralTwoSeparator;
    @JsonProperty("COLLATERAL2_ADDRESS")
    private String collateralTwoAddress;
    @JsonProperty("COLLATERAL2_NO")
    private String collateralTwoNo;
    @JsonProperty("COLLATERAL2_AREA")
    private String collateralTwoArea;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class CollateralThreeData {
    @JsonProperty("COLLATERAL3_ACCEPT")
    private String collateralThreeAccept;
    @JsonProperty("COLLATERAL3_BUILD_NAME")
    private String collateralThreeBuildName;
    @JsonProperty("COLLATERAL3_DOC_TYPE")
    private String collateralThreeDocType;
    @JsonProperty("COLLATERAL3_BUILD_CONTENT")
    private String collateralThreeBuildContent;
    @JsonProperty("COLLATERAL3_NO")
    private String collateralThreeNo;
    @JsonProperty("COLLATERAL3_SEPARATOR")
    private String collateralThreeSeparator;
    @JsonProperty("COLLATERAL3_ETC")
    private String collateralThreeEtc;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class CollateralFourData {
    @JsonProperty("COLLATERAL4_SEPARATOR")
    private String collateralFourSeparator;
    @JsonProperty("COLLATERAL4_DOC_TYPE")
    private String collateralFourDocType;
    @JsonProperty("COLLATERAL4_NO")
    private String collateralFourNo;
    @JsonProperty("COLLATERAL4_LAND_RATE")
    private String collateralFourLandRate;
    @JsonProperty("COLLATERAL4_LAND_KIND")
    private String collateralFourLandKind;
    @JsonProperty("COLLATERAL4_ETC")
    private String collateralFourEtc;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class BuildData {
    @JsonProperty("BUILD_CONTENT")
    private String buildContent;
    @JsonProperty("BUILD_ACCEPT")
    private String buildAccept;
    @JsonProperty("BUILD_NO")
    private String buildNo;
    @JsonProperty("BUILD_DOC_TYPE")
    private String buildDocType;
    @JsonProperty("BUILD_SEPARATOR")
    private String buildSeparator;
    @JsonProperty("BUILD_ETC")
    private String buildEtc;
    @JsonProperty("BUILD_ADDRESS")
    private String buildAddress;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class SaleData {
    @JsonProperty("SALE_PRICE")
    private String salePrice;
    @JsonProperty("SALE_ADDRESS")
    private String saleAddress;
    @JsonProperty("SALE_ETC_CAUSE2")
    private String saleEtcCause2;
    @JsonProperty("SALE_INDEX")
    private String saleIndex;
    @JsonProperty("SALE_NO")
    private String saleNo;
    @JsonProperty("SALE_PRIORITY")
    private String salePriority;
    @JsonProperty("SALE_ETC_CAUSE")
    private String saleEtcCause;
    @JsonProperty("SALE_SEPARATOR")
    private String saleSeparator;
}

@Builder
@NoArgsConstructor
@Getter
class HolderData {
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class SummaryAData {
    @JsonProperty("SUMMARY_SEPARATOR_A")
    private String summarySeparatorA;
    @JsonProperty("SUMMARY_SHARE")
    private String summaryShare;
    @JsonProperty("SUMMARY_PRIORITY")
    private String summaryPriority;
    @JsonProperty("SUMMARY_REGNO_RESIDENT")
    private String summaryRegnoResident;
    @JsonProperty("SUMMARY_NAME")
    private String summaryName;
    @JsonProperty("SUMMARY_ADDRESS")
    private String summaryAddress;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class SummaryKData {
    @JsonProperty("SUMMARY_SEPARATOR_K")
    private String summarySeparatorK;
    @JsonProperty("SUMMARY_NO_K")
    private String summaryNoK;
    @JsonProperty("SUMMARY_OWNER_K")
    private String summaryOwnerK;
    @JsonProperty("SUMMARY_PARTICULAR_K")
    private String summaryParticularK;
    @JsonProperty("SUMMARY_PURPOSE_K")
    private String summaryPurposeK;
    @JsonProperty("SUMMARY_ACCEPT_K")
    private String summaryAcceptK;
}

@Builder
@NoArgsConstructor
@Getter
class LandData {
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
class SummaryEData {
    @JsonProperty("SUMMARY_PARTICULAR_E")
    private String summaryParticularE;
    @JsonProperty("SUMMARY_PURPOSE_E")
    private String summaryPurposeE;
    @JsonProperty("SUMMARY_ACCEPT_E")
    private String summaryAcceptE;
    @JsonProperty("SUMMARY_SEPARATOR_E")
    private String summarySeparatorE;
    @JsonProperty("SUMMARY_NO_E")
    private String summaryNoE;
    @JsonProperty("SUMMARY_OWNER_E")
    private String summaryOwnerE;
}