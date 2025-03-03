package com.choimory.applicantestate.parse.dto;

import com.choimory.applicantestate.common.util.CommonDateFormatting;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
public class Output {
    private final Title title;
    private final List<Owner> owners;
    private final Gapgu gapgu;
    private final Eulgu eulgu;

    @Builder
    public Output(Title title, List<Owner> owners, Gapgu gapgu, Eulgu eulgu) {
        this.title = title;
        this.owners = owners;
        this.gapgu = gapgu;
        this.eulgu = eulgu;
    }

    public static Output to(RawData rawData) {
        return rawData != null ? Output.builder()
                .title(Title.to(rawData.getAddress()))
                .owners(rawData.getSummaryADataList().stream()
                        .filter(data -> !data.getSummaryShare().isBlank())
                        .map(data -> Owner.to(RawData.SummaryAData.builder()
                                .summaryName(data.getSummaryName().trim()
                                        .replaceAll("\\s+", "")
                                        .replaceAll("\\(.*?\\)", ""))
                                .summaryShare(data.getSummaryShare().trim())
                                .summaryRegnoResident(data.getSummaryRegnoResident().trim())
                                .summaryAddress(data.getSummaryAddress().trim())
                                .build()))
                        .collect(Collectors.toList()))
                .gapgu(Gapgu.to(rawData.getKapDataList()))
                .eulgu(Eulgu.to(rawData.getSummaryEDataList()))
                .build() : null;
    }

    @Getter
    public static class Title {
        private final String fullAddress;
        private final String buildingType;

        @Builder
        public Title(String fullAddress, String buildingType) {
            this.fullAddress = fullAddress;
            this.buildingType = buildingType;
        }

        public static Title to(String address) {
            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(address);

            return Title.builder()
                    .fullAddress(address)
                    .buildingType(matcher.find() ? matcher.group() : "")
                    .build();
        }
    }

    @Getter
    public static class Owner {
        private final String name;
        private final String age;
        private final String share;
        private final String address;
        private final String buyDate;

        @Builder
        public Owner(String name, String age, String share, String address, String buyDate) {
            this.name = name;
            this.age = age;
            this.share = share;
            this.address = address;
            this.buyDate = buyDate;
        }

        public static Owner to(RawData.SummaryAData summaryAData) {
            return summaryAData != null ? Owner.builder()
                    .name(summaryAData.getSummaryName())
                    .age(summaryAData.getSummaryRegnoResident())
                    .share(summaryAData.getSummaryShare())
                    .address(summaryAData.getSummaryAddress())
                    .buyDate("") // TODO ?
                    .build() : null;
        }
    }

    @Getter
    public static class Gapgu {
        private final Long seizureCount;
        private final Long provisionalSeizureCount;
        private final Long provisionalDispositionCount;
        private final Long voluntaryAuctionCount;
        private final Long compulsoryAuctionCount;
        private final Long bankruptcyCount;

        @Builder
        public Gapgu(Long seizureCount, Long provisionalSeizureCount, Long provisionalDispositionCount, Long voluntaryAuctionCount, Long compulsoryAuctionCount, Long bankruptcyCount) {
            this.seizureCount = seizureCount;
            this.provisionalSeizureCount = provisionalSeizureCount;
            this.provisionalDispositionCount = provisionalDispositionCount;
            this.voluntaryAuctionCount = voluntaryAuctionCount;
            this.compulsoryAuctionCount = compulsoryAuctionCount;
            this.bankruptcyCount = bankruptcyCount;
        }

        public static Gapgu to(List<RawData.KapData> kapDataList) {
            return Gapgu.builder()
                    .seizureCount(CollectionUtils.isEmpty(kapDataList) ? 0L
                            : kapDataList.stream()
                            .map(RawData.KapData::getKapPurpose)
                            .filter(purpose -> purpose.contains("압류"))
                            .count())
                    .provisionalSeizureCount(CollectionUtils.isEmpty(kapDataList) ? 0L
                            : kapDataList.stream()
                            .map(RawData.KapData::getKapPurpose)
                            .filter(purpose -> purpose.contains("가압류"))
                            .count())
                    .provisionalDispositionCount(CollectionUtils.isEmpty(kapDataList) ? 0L
                            : kapDataList.stream()
                            .map(RawData.KapData::getKapPurpose)
                            .filter(purpose -> purpose.contains("가처분"))
                            .count())
                    .voluntaryAuctionCount(CollectionUtils.isEmpty(kapDataList) ? 0L
                            : kapDataList.stream()
                            .map(RawData.KapData::getKapPurpose)
                            .filter(purpose -> purpose.contains("임의경매개시결정"))
                            .count())
                    .compulsoryAuctionCount(CollectionUtils.isEmpty(kapDataList) ? 0L
                            : kapDataList.stream()
                            .map(RawData.KapData::getKapPurpose)
                            .filter(purpose -> purpose.contains("강제경매개시결정"))
                            .count())
                    .bankruptcyCount(CollectionUtils.isEmpty(kapDataList) ? 0L
                            : kapDataList.stream()
                            .map(RawData.KapData::getKapPurpose)
                            .filter(purpose -> purpose.contains("파산선고"))
                            .count())
                    .build();
        }
    }

    @Getter
    public static class Eulgu {
        private final Long collateralTotalAmount;
        private final List<CollateralDetail> collateralsDetails;
        private final Long leaseTotalAmount;
        private final List<LeaseDetail> leaseDetails;

        @Builder
        public Eulgu(Long collateralTotalAmount, List<CollateralDetail> collateralsDetails, Long leaseTotalAmount, List<LeaseDetail> leaseDetails) {
            this.collateralTotalAmount = collateralTotalAmount;
            this.collateralsDetails = collateralsDetails;
            this.leaseTotalAmount = leaseTotalAmount;
            this.leaseDetails = leaseDetails;
        }

        public static Eulgu to(List<RawData.SummaryEData> summaryEDataList) {
            //근저당권설정 객체 번호
            List<Integer> collateralIndexes = new ArrayList<>();
            for (int i = 0; i < summaryEDataList.size(); i++) {
                if (summaryEDataList.get(i).getSummaryPurposeE().contains("근저당권설정") && summaryEDataList.get(i).getSummarySeparatorE().equals("N")) {
                    collateralIndexes.add(i);
                }
            }

            //근저당권 정보
            List<CollateralDetail> collateralDetails = new ArrayList<>();
            for (Integer index : collateralIndexes) {
                collateralDetails.add(CollateralDetail.to(summaryEDataList.get(index), summaryEDataList.get(index + 1)));
            }

            //임차권설정 객체 번호
            List<Integer> leaseIndexes = new ArrayList<>();
            for (int i = 0; i < summaryEDataList.size(); i++) {
                if (summaryEDataList.get(i).getSummaryPurposeE().contains("임차권설정") && summaryEDataList.get(i).getSummarySeparatorE().equals("N")) {
                    leaseIndexes.add(i);
                }
            }

            //임차권 정보
            List<LeaseDetail> leaseDetails = new ArrayList<>();
            for (Integer index : leaseIndexes) {
                leaseDetails.add(LeaseDetail.to(summaryEDataList.get(index), summaryEDataList.get(index + 1)));
            }

            //반환
            return Eulgu.builder()
                    .collateralTotalAmount(CollectionUtils.isEmpty(summaryEDataList) ? 0L
                            : summaryEDataList.stream()
                            .filter(data -> data.getSummaryParticularE().contains("채권최고액"))
                            .flatMap(data -> {
                                Matcher matcher = Pattern.compile("[\\d,]+").matcher(data.getSummaryParticularE());
                                return matcher.results().map(MatchResult::group);
                            })
                            .mapToLong(amount -> Long.parseLong(amount.replace(",", "")))
                            .sum())
                    .collateralsDetails(collateralDetails)
                    .leaseTotalAmount(CollectionUtils.isEmpty(summaryEDataList) ? 0L
                            : summaryEDataList.stream()
                            .filter(data -> data.getSummaryParticularE().contains("임차보증금"))
                            .flatMap(data -> {
                                Matcher matcher = Pattern.compile("[\\d,]+").matcher(data.getSummaryParticularE());
                                return matcher.results().map(MatchResult::group);
                            })
                            .mapToLong(amount -> Long.parseLong(amount.replace(",", "")))
                            .sum())
                    .leaseDetails(leaseDetails)
                    .build();
        }
    }

    @Getter
    public static class CollateralDetail {
        private final String rankNo;
        private final String date;
        private final Long amount;
        private final String collateralHolder;

        @Builder
        public CollateralDetail(String rankNo, String date, Long amount, String collateralHolder) {
            this.rankNo = rankNo;
            this.date = date;
            this.amount = amount;
            this.collateralHolder = collateralHolder;
        }

        public static CollateralDetail to(RawData.SummaryEData data, RawData.SummaryEData holder) {
            return CollateralDetail.builder()
                    .rankNo(data.getSummaryNoE().trim())
                    .date(StringUtils.hasText(data.getSummaryAcceptE()) ? CommonDateFormatting.to("[^가-힣0-9]", data.getSummaryAcceptE()) : "")
                    .amount(Long.parseLong(data.getSummaryParticularE().replaceAll("[^0-9]", "")))
                    .collateralHolder(holder.getSummaryParticularE().replaceAll("근저당권자", "").replaceAll("[^가-힣0-9\\s]", "").trim())
                    .build();
        }
    }

    @Getter
    public static class LeaseDetail {
        private final String rankNo;
        private final String date;
        private final Long amount;
        private final String leaseHolder;

        @Builder
        public LeaseDetail(String rankNo, String date, Long amount, String leaseHolder) {
            this.rankNo = rankNo;
            this.date = date;
            this.amount = amount;
            this.leaseHolder = leaseHolder;
        }

        public static LeaseDetail to(RawData.SummaryEData data, RawData.SummaryEData holder) {
            return LeaseDetail.builder()
                    .rankNo(data.getSummaryNoE())
                    .date(StringUtils.hasText(data.getSummaryAcceptE()) ? CommonDateFormatting.to("[^가-힣0-9]", data.getSummaryAcceptE()) : "")
                    .amount(Long.parseLong(data.getSummaryParticularE().replaceAll("[^0-9]", "")))
                    .leaseHolder(holder.getSummaryParticularE().replaceAll("임차권자", "").replaceAll("[^가-힣0-9\\s]", "").trim())
                    .build();
        }
    }
}
