package com.algo.client;

public class CountClient {

	public static void main(String[] args) {
		String s="AAAAAAAAAAAAAAAaZaz!";
		int radix=124;
		int[] count=new int[radix];
		for(int i=0;i<radix;i++) {
			count[i]=0;
		}
		for(char ch: s.toCharArray()) {
			int value=(int) ch;
			if(value!=-1) {
				count[value]++;
			}
		}
		System.out.println("Count of characters : ");
		for(int i=0;i<radix;i++) {
			if(count[i]>0) {
				System.out.println("Character : "+(char)i+" Count : "+count[i]);
			}
		}
	}

}
