package yokohama.murataku.sample.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringOperatorTest {

    @Test
    @DisplayName("デフォルトのデリミタで文字列を結合すること")
    public void testJoin1() {
        assertEquals("a,b", new StringOperator().join("a", "b"));
    }

    @Test
    @DisplayName("メッセージは Supplier<String> で設定できる")
    public void testJoin2() {
        assertEquals("a,b", new StringOperator().join("a", "b"), () -> "結合が間違っている!!");
    }

    @Test
    @DisplayName("AssertJ での結合テスト")
    public void testJoin3() {
        // 結果に "c" がないことだけがエラーメッセージに出る。
        assertThat(new StringOperator().join("a", "b")).contains("a").contains("c").contains("d").contains(",").hasSize(3);
    }

    @Test
    @DisplayName("複数項目を必ず検証する")
    public void testJoin4() {
        String joined = new StringOperator().join("a", "b");

        // "c", "d" がないこと、長さが 4 ではないことがエラーメッセージに出る。
        assertAll(
                () -> assertThat(joined).contains("a"),
                () -> assertThat(joined).contains("b"),
                () -> assertThat(joined).contains("c"),
                () -> assertThat(joined).contains("d"),
                () -> assertThat(joined).hasSize(4)
        );
    }

}
