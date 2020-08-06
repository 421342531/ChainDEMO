package main;

import java.util.ArrayList;

import com.Block;
import com.google.gson.GsonBuilder;

public class NoobChain1 {

    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
    public static int difficulty = 5;

    public static void main(String[] args) {    
        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("Hi im the first block", "0"));        
        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash)); 
        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);      
        System.out.println(blockchainJson);
        
        //blockchain.get(0).hash = "1";
       // blockchain.get(1).data = "被我改掉了";
       // blockchain.get(2).data = "块2=新的内容";
        NoobChain1 nc =new NoobChain1();
        System.out.println("===============================");
        System.out.println("开始校验区块链...");
        System.out.println("检查链路结果："+ nc.isChainValid());
    }
    
    
    public static Boolean isChainValid() {
        Block currentBlock; 
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("当前的 Hashes 不匹配");         
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("前面的 Hashes 不匹配");
                return false;
            }
        }
        return true;
    }

}