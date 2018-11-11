import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import decoder.Decoder;
import decoder.DecoderImpl;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the decoder and its functionality against various test
 * cases.
 */
public class DecoderTest {

    private Decoder d1;
    private Decoder d2;
    private Decoder d3;

    /**
     * This method is used to set up the decoder objects with a string of coding
     * symbols.
     */
    @Before
    public void setUp() {
        String binaryCodeSymbols = "01";
        String hexCodeSymbols = "0123456789abcdef";

        // decoder with binary code symbols
        d1 = new DecoderImpl(binaryCodeSymbols);

        // decoder with hexadecimal code symbols
//		d2 = new DecoderImpl(hexCodeSymbols);
//
//		// decoder with coding symbols 'a', 'b', and 'c'
//		d3 = new DecoderImpl("abc");
    }


    /**
     * Tests if the addCode method works correctly when valid symbols and valid
     * codes are passed.
     */
    @Test
    public void testValidAddCode() {
        try {
            d1.addCode('1', "001");
           // d1.addCode('2', "010");

        } catch (Exception e) {
            fail();
        }
    }


}
