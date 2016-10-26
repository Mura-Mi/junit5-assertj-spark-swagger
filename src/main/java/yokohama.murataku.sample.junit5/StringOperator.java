package yokohama.murataku.sample.junit5;

public class StringOperator {

    private final String joiner;

    public StringOperator() {
        this.joiner = ",";
    }

    public StringOperator(String joiner) {
        this.joiner = joiner;
    }

    public String join(String a, String b) {
        return a + joiner + b;
    }

}
