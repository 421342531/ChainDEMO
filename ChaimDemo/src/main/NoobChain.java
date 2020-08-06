package main;

import com.Block;

public class NoobChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创世块
		 Block genesisBlock = new Block("Hi im the first block", "0");
		 //输出第一块的hash信息  
		 System.out.println("Hash for block 1 : " + genesisBlock.hash);
		 
		 Block secondBlock = new Block("Yo im the second block",genesisBlock.hash);
	     System.out.println("Hash for block 2 : " + secondBlock.hash);
	     
	     Block thirdBlock = new Block("Hey im the third block",secondBlock.hash);
	     System.out.println("Hash for block 3 : " + thirdBlock.hash);
		
	}

}
