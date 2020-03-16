package dev.ohdoking.blockchain;

import com.google.gson.GsonBuilder;
import dev.ohdoking.blockchain.model.Block;

import java.util.ArrayList;

public class firstBlockchainProject {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();


    public static void main(String[] args) {

//        Block genesisBlock = new Block("Hi im the first block", "0");
//        System.out.println("Hash for block 1 : " + genesisBlock.hash);
//
//        Block secondBlock = new Block("Yo im the second block",genesisBlock.hash);
//        System.out.println("Hash for block 2 : " + secondBlock.hash);
//
//        Block thirdBlock = new Block("Hey im the third block",secondBlock.hash);
//        System.out.println("Hash for block 3 : " + thirdBlock.hash);

        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);

    }

    /***
     * Proof of work.
     *
     * The hashcash proof of work system means it takes considerable time and computational power to create new blocks.
     *
     * @return
     */
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
