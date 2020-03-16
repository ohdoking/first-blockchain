package dev.ohdoking.blockchain.model;


import dev.ohdoking.blockchain.util.StringUtil;

import java.util.Date;

/**
 * Each block in the blockchain will have its own digital fingerprint,
 * contain digital fingerprint of the previous block, and have some data
 *
 * Hash = Digital Fingerprint.
 *
 *
 */
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;

    public Block(String previousHash, String data){
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
        return calculatedhash;
    }


}
