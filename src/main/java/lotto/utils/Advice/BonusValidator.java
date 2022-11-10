package lotto.utils.Advice;

import static lotto.domain.model.ErrorMessage.BONUS_NUMBER_OUT_BOUND;
import static lotto.domain.model.ErrorMessage.COMMON_MESSAGE;
import static lotto.utils.Advice.LottoValidator.STANDARD_LOTTO_NUMBER;

public class BonusValidator {

    private static final String BONUS_REG_EXP = "\\d{1,2}";

    private BonusValidator(){}


    public static void checkSizeAndNumber(String bonus) {
        if (!bonus.matches(BONUS_REG_EXP)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRange(String bonus) {
        if (!STANDARD_LOTTO_NUMBER.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + BONUS_NUMBER_OUT_BOUND.getMessage());
        }
    }
}
