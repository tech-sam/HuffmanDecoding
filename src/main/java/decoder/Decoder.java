package decoder;

public interface Decoder {

    void addCode(char symbol, String code) throws IllegalStateException;

    String decode(String encodedMessgae) throws IllegalStateException;

    String allCodes();

    boolean isCodeComplete();

}
