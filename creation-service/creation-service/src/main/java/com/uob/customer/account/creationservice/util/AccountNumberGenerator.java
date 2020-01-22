package com.uob.customer.account.creationservice.util;

import java.util.Random;

public class AccountNumberGenerator {

	public static String generateAccountNumber() {
		Random rand = new Random();
	    String card = "UOB";
	    for (int i = 0; i < 14; i++)
	    {
	        int n = rand.nextInt(10) + 0;
	        card += Integer.toString(n);
	    }
	    for (int i = 0; i < 16; i++)
	    {
	        if(i % 4 == 0)
	          System.out.print(" ");
	        System.out.print(card.charAt(i));
	    }
	    
	    return card;
	}
}
