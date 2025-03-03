package com.choimory.applicantestate.parse.dto;

import ch.qos.logback.core.util.StringUtil;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

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
                .title(Title.to(rawData.getAddress()))
                //.owners()
                //.gapgu()
                //.eulgu()
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
            return Title.builder()
                    .fullAddress(address)
                    //.buildingType() // TODO address에서 첫번째 [내용] 파싱
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

        public static Owner to() {
            // TODO SUMMARY_A_DATA[]에서 공백 데이터 제외, 중복 데이터는 합산 (홍길동의 SHARE가 10/120, 30/120일시, 40/120)
            return Owner.builder()
                    //.name() // TODO SUMMARY_A_DATA[].SUMMARY_NAME
                    //.age() // TODO SUMMARY_A_DATA[].SUMMARY_REGNO_RESIDENT
                    //.share() // TODO SUMMARY_A_DATA[].SUMMARY_SHARE
                    //.address() // TODO SUMMARY_A_DATA[].ADDRESS
                    //.buyDate() // TODO ?
                    .build();
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
            return Gapgu.builder()
                    //.seizureCount() // TODO KAP_DATA[].KAP_PURPOSE="압류" 횟수
                    //.provisionalSeizureCount() // TODO KAP_DATA[].KAP_PURPOSE="가압류" 횟수
                    //.provisionalDispositionCount() // TODO KAP_DATA[].KAP_PURPOSE="가처분" 횟수
                    //.voluntaryAuctionCount() // TODO KAP_DATA[].KAP_PURPOSE="임의경매개시결정" 횟수
                    //.compulsoryAuctionCount() // TODO KAP_DATA[].KAP_PURPOSE="강제경매개시결정" 횟수
                    //.bankruptcyCount() // TODO KAP_DATA[].KAP_PURPOSE="파산선고" 횟수
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

        public static Eulgu to() {
            return Eulgu.builder()
                    //.collateralTotalAmount() // TODO EUL_DATA[].EUL_ETC에서 채권내용 파싱
                    //.collateralsDetails()
                    //.leaseTotalAmount() // TODO EUL_DATA[].EUL_ETC에서 임차내용 파싱
                    //.leaseDetails()
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

        public static CollateralDetail to() {
            // 1.SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값중 채권최고액이 포함되어있으면 근저당권 내용
            // 2. 1의 다음값은 근저당권자 내용
            // 3. 2 다음에 근저당권 이전이 있으면 해당 내용이 케이스에 따라 있을수도 없을수도 있음

            return CollateralDetail.builder()
                    //.rankNo()
                    //.date() // TODO SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값에 '채권최고액'이 포함되어 있는 객체의 SUMMARY_ACCEPT_E를 포맷변경
                    //.amount() // TODO SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값에 '채권최고액'이 포함되어 있는 객체의 SUMMARY_PARTICULAR_E에서 '채권최고액' 다음에 오는 값을 파싱하여 포맷변경
                    //.collateralHolder() // TODO SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값에 '채권최고액'이 포함되어 있는 객체의 다음 객체에서 '근저당권자' 다음에 오는 값을 파싱 -> 근저당권이전으로 두번 붙을수도 있음
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

        public static LeaseDetail to() {
            // 1.SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값중 임차보증금이 포함되어있으면 임차권 내용
            // 2. 1의 다음값은 임차권자 내용

            return LeaseDetail.builder()
                    //.rankNo()
                    //.date() // TODO SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값에 '임차보증금'이 포함되어 있는 객체의 SUMMARY_ACCEPT_E를 포맷변경
                    //.amount() // TODO SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값에 '임차보증금'이 포함되어 있는 객체의 SUMMARY_PARTICULAR_E에서 '임차보증금' 다음에 오는 값을 파싱하여 포맷변경
                    //.leaseHolder() // TODO SUMMARY_E_DATA[].SUMMARY_PARTICULAR_E의 값에 '임차보증금'이 포함되어 있는 객체의 다음 객체에서 '임차권자' 다음에 오는 값을 파싱
                    .build();
        }
    }
}
