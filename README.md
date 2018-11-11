# HuffmanDecoding
Encoding and decoding are common operations on data. Given data in the form of symbols (e.g. text), it can be encoded by translating each symbol into a unique code, possibly consisting of many symbols. Decoding applies this process in reverse. The unique codes may be made of a different set of symbols (e.g. the original symbols may be characters, but the codes are bits). We call this set “coding symbols”.

The main component of encoding and decoding can be thought of as a symbol -> code dictionary. The dictionary represents a coding scheme. For example, consider that all input messages are made of symbols {𝑎,𝑏,𝑐,𝑑,𝑒}
, and the coding symbols are {0,1}. An example dictionary could be {𝑎→10,𝑏→1100,𝑐→1101,𝑑→01,𝑒→00}

. Then, an input message “dab” will be encoded as “01101100” by replacing the symbols ‘d’, ‘a’, ‘b’ with their respective codes from the dictionary. Similarly, an encoded string “11001001” will be decoded to “bad” using the same dictionary.

Coding schemes may have some unique characteristics. For example, certain encoding schemes generate codes such that no code is a prefix of another code (e.g. 10 and 101 cannot both be codes, because the first is a prefix of the second). Such schemes are called prefix codes, and this property can be used to decode faster. You can verify that the dictionary in the above example shows a prefix coding scheme.

This repository containes prefix decoding called Huffman decoding scheme

