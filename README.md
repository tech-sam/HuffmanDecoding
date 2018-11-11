# HuffmanDecoding
Encoding and decoding are common operations on data. Given data in the form of symbols (e.g. text), it can be encoded by translating each symbol into a unique code, possibly consisting of many symbols. Decoding applies this process in reverse. The unique codes may be made of a different set of symbols (e.g. the original symbols may be characters, but the codes are bits). We call this set “coding symbols”.

The main component of encoding and decoding can be thought of as a symbol -> code dictionary. The dictionary represents a coding scheme. For example, consider that all input messages are made of symbols {𝑎,𝑏,𝑐,𝑑,𝑒}
, and the coding symbols are {0,1}. An example dictionary could be {𝑎→10,𝑏→1100,𝑐→1101,𝑑→01,𝑒→00}

. Then, an input message “dab” will be encoded as “01101100” by replacing the symbols ‘d’, ‘a’, ‘b’ with their respective codes from the dictionary. Similarly, an encoded string “11001001” will be decoded to “bad” using the same dictionary.

Coding schemes may have some unique characteristics. For example, certain encoding schemes generate codes such that no code is a prefix of another code (e.g. 10 and 101 cannot both be codes, because the first is a prefix of the second). Such schemes are called prefix codes, and this property can be used to decode faster. You can verify that the dictionary in the above example shows a prefix coding scheme.

This repository containes prefix decoding called Huffman decoding scheme

### Prefix tree ###

symbol        | code
------------- | -------------
a             | 100
b             | 00
c             | 01
d             | 11
e             | 101

Formally, the original symbol set is {𝑎,𝑏,𝑐,𝑑,𝑒} and the code symbols are {0,1}. We can see that the above code is a prefix code (no code is a prefix of another).

This coding scheme can be represented as a tree 𝑈:

![picture alt](https://course.ccs.neu.edu/cs5010/huffmantree.png "Huffman tree")

All the original symbols are leaves in this tree. The others are transition nodes. Since there are only two code symbols, this is a binary tree. Each edge of the tree is annotated (for illustration) with a code symbol (left is 0, right is 1).

Given an encoded message 10001101
, we can decode it as follows:

1.    Start at the root of the tree.

2.    Read the next symbol.

3.    Turn “left” or “right” depending on the read symbol.

4.    If a leaf is reached, output the character at that leaf, restart at the root.

5.    Go to step 2


This process is illustrated for the decoding 101 into ‘e’:

![picture alt](https://course.ccs.neu.edu/cs5010/huffmandecoding.png "Huffman tree")

Applying this process to the encoded message 10001101: we use the first three symbols 100 to arrive at ‘a’, the next two symbols 01 to arrive at ‘c’ and the last three symbols 101 to arrive at ‘e’. Thus the encoded message 10001101

decodes to the string “ace”.

A complete coding tree is full: each transition node has children to its full capacity (2 above, since the tree is binary).


credit goes to [Northeastern University](https://course.ccs.neu.edu)
