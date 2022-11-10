package lotto;

import static lotto.LottoGenerator.COUNT;
import static lotto.LottoGenerator.END_INCLUSIVE;
import static lotto.LottoGenerator.START_INCLUSIVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());
    List<Integer> lottoNumber;


    @BeforeEach
    void setUp() {
        lottoNumber = LottoGenerator.makeLotto();
    }

    @Test
    void 랜덤_번호_여섯자리_생성_확인() {
        assertThat(lottoNumber.size()).isEqualTo(COUNT);
    }

    @Test
    void 랜덤_번호_중복_확인() {
        assertThat(new HashSet<>(lottoNumber).size()).isEqualTo(lottoNumber.size());
    }

    @Test
    void 랜덤_번호_범위_확인() {
        lottoNumber.stream().map(STANDARD_LOTTO_NUMBER::contains).forEach(Assertions::assertTrue);
    }

    @Test
    void 랜덤_번호_생성_순서_오름차순_확인() {
        for (int i = 0; i < lottoNumber.size() - 1; i++) {
            assertTrue(lottoNumber.get(i) < lottoNumber.get(i + 1));
        }
    }
}