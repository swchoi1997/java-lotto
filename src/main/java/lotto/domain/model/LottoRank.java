package lotto.domain.model;

import static lotto.domain.view.IOMessage.BONUS_STATISTICS_MESSAGE;
import static lotto.domain.view.IOMessage.STANDARD_STATISTICS_MESSAGE;

import java.util.Arrays;

public enum LottoRank {

    NONE("0", 0),
    THREE_MATCHES("3",5000),
    FOUR_MATCHES("4",50000),
    FIVE_MATCHES("5",1500000),
    FIVE_BONUS_MATCHES("5",30000000),
    SIX_MATCHES("6",2000000000);


    private final String matchPoint;
    private final Integer reward;
    LottoRank(final String matchPoint, final Integer prizeMoney) {
        this.matchPoint = matchPoint;
        this.reward = prizeMoney;
    }

    public Integer getReward() {
        return reward;
    }

    public static LottoRank find(String matchPoint) {
        return Arrays.stream(values()).filter(lottoRank -> lottoRank.matchPoint.equals(matchPoint)).findFirst()
                .orElse(NONE);
    }

    public static LottoRank of(LottoRank lottoRank, Boolean isBonusMatch) {
        if (lottoRank == FIVE_MATCHES && isBonusMatch) {
            return FIVE_BONUS_MATCHES;
        }
        return lottoRank;
    }

    public static String createStatisticsForm(LottoRank lottoRank, Integer count) {
        if (lottoRank == FIVE_BONUS_MATCHES) {
            return String.format(BONUS_STATISTICS_MESSAGE.getMessage(), lottoRank.matchPoint, lottoRank.reward, count);
        }
        return String.format(STANDARD_STATISTICS_MESSAGE.getMessage(), lottoRank.matchPoint, lottoRank.reward, count);
    }
}
