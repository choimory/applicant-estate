package com.choimory.applicantestate.parse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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


    @Builder
    public RawData(String title, String address, String docType, String eulCount, String kapCount, String issueDate, String issueTime, String landCount, String saleCount, String buildCount, String docDetails, String holderCount, String realEstateNo, String outputFilename, String registerOffice, String summaryACount, String summaryECount, String summaryKCount, String collateralCount, String collateralOneCount, String collateralTwoCount, String collateralThreeCount, String collateralFourCount, List<BuildData> builds, List<CollateralFourData> collateralFourDataList, List<CollateralOneData> collateralOneDataList, List<CollateralThreeData> collateralThreeDataList, List<CollateralTwoData> collateralTwoDataList, List<EulData> eulDataList, List<HolderData> holderDataList, List<KapData> kapDataList, List<LandData> landDataList, List<SaleData> saleData, List<SummaryAData> summaryADataList, List<SummaryEData> summaryEDataList, List<SummaryKData> summaryKDataList) {
        this.title = title;
        this.address = address;
        this.docType = docType;
        this.eulCount = eulCount;
        this.kapCount = kapCount;
        this.issueDate = issueDate;
        this.issueTime = issueTime;
        this.landCount = landCount;
        this.saleCount = saleCount;
        this.buildCount = buildCount;
        this.docDetails = docDetails;
        this.holderCount = holderCount;
        this.realEstateNo = realEstateNo;
        this.outputFilename = outputFilename;
        this.registerOffice = registerOffice;
        this.summaryACount = summaryACount;
        this.summaryECount = summaryECount;
        this.summaryKCount = summaryKCount;
        this.collateralCount = collateralCount;
        this.collateralOneCount = collateralOneCount;
        this.collateralTwoCount = collateralTwoCount;
        this.collateralThreeCount = collateralThreeCount;
        this.collateralFourCount = collateralFourCount;
        this.builds = builds;
        this.collateralFourDataList = collateralFourDataList;
        this.collateralOneDataList = collateralOneDataList;
        this.collateralThreeDataList = collateralThreeDataList;
        this.collateralTwoDataList = collateralTwoDataList;
        this.eulDataList = eulDataList;
        this.holderDataList = holderDataList;
        this.kapDataList = kapDataList;
        this.landDataList = landDataList;
        this.saleData = saleData;
        this.summaryADataList = summaryADataList;
        this.summaryEDataList = summaryEDataList;
        this.summaryKDataList = summaryKDataList;
    }

    @Getter
    public static class EulData {
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

        @Builder
        public EulData(String eulSeparator, String eulReason, String eulDocType, String eulAccept, String eulNo, String eulEtc, String eulPurpose) {
            this.eulSeparator = eulSeparator;
            this.eulReason = eulReason;
            this.eulDocType = eulDocType;
            this.eulAccept = eulAccept;
            this.eulNo = eulNo;
            this.eulEtc = eulEtc;
            this.eulPurpose = eulPurpose;
        }
    }

    @Getter
    public static class KapData {
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

        @Builder
        public KapData(String kapAccept, String kapNo, String kapReason, String kapPurpose, String kapSeparator, String kapDocType, String kapEtc) {
            this.kapAccept = kapAccept;
            this.kapNo = kapNo;
            this.kapReason = kapReason;
            this.kapPurpose = kapPurpose;
            this.kapSeparator = kapSeparator;
            this.kapDocType = kapDocType;
            this.kapEtc = kapEtc;
        }
    }

    @Getter
    public static class CollateralOneData {
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

        @Builder
        public CollateralOneData(String collateralOneSeparator, String collateralOneBuildName, String collateralOneAccept, String collateralOneBuildContent, String collateralOneDocType, String collateralOneNo, String collateralOneEtc) {
            this.collateralOneSeparator = collateralOneSeparator;
            this.collateralOneBuildName = collateralOneBuildName;
            this.collateralOneAccept = collateralOneAccept;
            this.collateralOneBuildContent = collateralOneBuildContent;
            this.collateralOneDocType = collateralOneDocType;
            this.collateralOneNo = collateralOneNo;
            this.collateralOneEtc = collateralOneEtc;
        }
    }

    @Getter
    public static class CollateralTwoData {
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

        @Builder
        public CollateralTwoData(String collateralTwoEtc, String collateralTwoDocType, String collateralTwoLandCategory, String collateralTwoSeparator, String collateralTwoAddress, String collateralTwoNo, String collateralTwoArea) {
            this.collateralTwoEtc = collateralTwoEtc;
            this.collateralTwoDocType = collateralTwoDocType;
            this.collateralTwoLandCategory = collateralTwoLandCategory;
            this.collateralTwoSeparator = collateralTwoSeparator;
            this.collateralTwoAddress = collateralTwoAddress;
            this.collateralTwoNo = collateralTwoNo;
            this.collateralTwoArea = collateralTwoArea;
        }
    }

    @Getter
    public static class CollateralThreeData {
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

        @Builder
        public CollateralThreeData(String collateralThreeAccept, String collateralThreeBuildName, String collateralThreeDocType, String collateralThreeBuildContent, String collateralThreeNo, String collateralThreeSeparator, String collateralThreeEtc) {
            this.collateralThreeAccept = collateralThreeAccept;
            this.collateralThreeBuildName = collateralThreeBuildName;
            this.collateralThreeDocType = collateralThreeDocType;
            this.collateralThreeBuildContent = collateralThreeBuildContent;
            this.collateralThreeNo = collateralThreeNo;
            this.collateralThreeSeparator = collateralThreeSeparator;
            this.collateralThreeEtc = collateralThreeEtc;
        }
    }

    @Getter
    public static class CollateralFourData {
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

        @Builder
        public CollateralFourData(String collateralFourSeparator, String collateralFourDocType, String collateralFourNo, String collateralFourLandRate, String collateralFourLandKind, String collateralFourEtc) {
            this.collateralFourSeparator = collateralFourSeparator;
            this.collateralFourDocType = collateralFourDocType;
            this.collateralFourNo = collateralFourNo;
            this.collateralFourLandRate = collateralFourLandRate;
            this.collateralFourLandKind = collateralFourLandKind;
            this.collateralFourEtc = collateralFourEtc;
        }
    }

    @Getter
    public static class BuildData {
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

        @Builder
        public BuildData(String buildContent, String buildAccept, String buildNo, String buildDocType, String buildSeparator, String buildEtc, String buildAddress) {
            this.buildContent = buildContent;
            this.buildAccept = buildAccept;
            this.buildNo = buildNo;
            this.buildDocType = buildDocType;
            this.buildSeparator = buildSeparator;
            this.buildEtc = buildEtc;
            this.buildAddress = buildAddress;
        }
    }

    @Getter
    public static class SaleData {
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

        @Builder
        public SaleData(String salePrice, String saleAddress, String saleEtcCause2, String saleIndex, String saleNo, String salePriority, String saleEtcCause, String saleSeparator) {
            this.salePrice = salePrice;
            this.saleAddress = saleAddress;
            this.saleEtcCause2 = saleEtcCause2;
            this.saleIndex = saleIndex;
            this.saleNo = saleNo;
            this.salePriority = salePriority;
            this.saleEtcCause = saleEtcCause;
            this.saleSeparator = saleSeparator;
        }
    }

    @Builder
    @NoArgsConstructor
    @Getter
    public static class HolderData {
    }

    @Getter
    public static class SummaryAData {
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

        @Builder
        public SummaryAData(String summarySeparatorA, String summaryShare, String summaryPriority, String summaryRegnoResident, String summaryName, String summaryAddress) {
            this.summarySeparatorA = summarySeparatorA;
            this.summaryShare = summaryShare;
            this.summaryPriority = summaryPriority;
            this.summaryRegnoResident = summaryRegnoResident;
            this.summaryName = summaryName;
            this.summaryAddress = summaryAddress;
        }
    }

    @Getter
    public static class SummaryKData {
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

        @Builder
        public SummaryKData(String summarySeparatorK, String summaryNoK, String summaryOwnerK, String summaryParticularK, String summaryPurposeK, String summaryAcceptK) {
            this.summarySeparatorK = summarySeparatorK;
            this.summaryNoK = summaryNoK;
            this.summaryOwnerK = summaryOwnerK;
            this.summaryParticularK = summaryParticularK;
            this.summaryPurposeK = summaryPurposeK;
            this.summaryAcceptK = summaryAcceptK;
        }
    }

    @Builder
    @NoArgsConstructor
    @Getter
    public static class LandData {
    }

    @Getter
    public static class SummaryEData {
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
}