package com.choimory.applicantestate.parse.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

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
        return Output.builder()
                .build();
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
            return Title.builder().build();
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

        public static Owner to() {
            return Owner.builder().build();
        }
    }

    @Getter
    public static class Gapgu {
        private final Integer seizureCount;
        private final Integer provisionalSeizureCount;
        private final Integer provisionalDispositionCount;
        private final Integer voluntaryAuctionCount;
        private final Integer compulsoryAuctionCount;
        private final Integer bankruptcyCount;

        @Builder
        public Gapgu(Integer seizureCount, Integer provisionalSeizureCount, Integer provisionalDispositionCount, Integer voluntaryAuctionCount, Integer compulsoryAuctionCount, Integer bankruptcyCount) {
            this.seizureCount = seizureCount;
            this.provisionalSeizureCount = provisionalSeizureCount;
            this.provisionalDispositionCount = provisionalDispositionCount;
            this.voluntaryAuctionCount = voluntaryAuctionCount;
            this.compulsoryAuctionCount = compulsoryAuctionCount;
            this.bankruptcyCount = bankruptcyCount;
        }

        public static Gapgu to() {
            return Gapgu.builder().build();
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

        public static Eulgu to() {
            return Eulgu.builder().build();
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

        public static CollateralDetail to() {
            return CollateralDetail.builder().build();
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

        public static LeaseDetail to() {
            return LeaseDetail.builder().build();
        }
    }
}
