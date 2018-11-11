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
        d1 = new DecoderImpl(binaryCodeSymbols);

        String hexCodeSymbols = "0123456789abcdef";
        d2 = new DecoderImpl(hexCodeSymbols);
    }


    /**
     * Tests if the addCode method works correctly when valid symbols and valid
     * codes are passed.
     */
    @Test
    public void testValidDecode() {
        d1.addCode('a', "00");
        d1.addCode('b', "01");
        d1.addCode('c', "10");
        d1.addCode('d', "11");

        assertEquals(d1.decode("00"), "a");
        assertEquals(d1.decode("01"), "b");
        assertEquals(d1.decode("10"), "c");
        assertEquals(d1.decode("11"), "d");

        d2.addCode('a', "a");
        d2.addCode('b', "b");
        d2.addCode('c', "c");
        d2.addCode('1', "001");
        d2.addCode('2', "1ef");
        assertEquals(d2.decode("abc0011ef0011efacb001001"), "abc1212acb11");
    }

}
