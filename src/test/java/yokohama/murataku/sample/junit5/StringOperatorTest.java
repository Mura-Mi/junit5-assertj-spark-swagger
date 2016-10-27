package yokohama.murataku.sample.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertEquals("a,b", new StringOperator().join("a", "b"), ()->"結合が間違っている!!");
    }
}
