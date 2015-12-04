package jamesbaker.adventofcode.day4;

import org.apache.commons.codec.digest.DigestUtils;

public class Part2 {
	private static final String INPUT = "bgvyzdsv";
	
	public static void main(String[] args) {
		Integer x = 1;
		while(!DigestUtils.md5Hex(INPUT + x).startsWith("000000")){
			x++;
		}

		System.out.println(x + ": "+DigestUtils.md5Hex(INPUT + x));
	}
}
