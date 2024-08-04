package bank.management.system;

import java.util.Random;

public class rough {
    public static void main(String[] args) {
        Random ran = new Random();

        // Generate a 4-digit number between 1000 and 9999
        int first4 = (int)(Math.random() * 9000) + 1000;
        String first4String = Integer.toString(first4);
        System.out.println("4-digit number: " + first4);

        // Calculate the number of remaining digits needed to make a 16-digit card number
        // "1409963" is 7 digits, and we have 4 digits from first4String, so we need 5 more digits
        long remaining5Digits = (ran.nextLong() % 90000L) + 10000L;
        String remaining5String = Long.toString(Math.abs(remaining5Digits));

        // Combine the parts to form the card number
        String cardno = "1409963" + remaining5String + first4String;
        System.out.println("Card Number: " + cardno);
    }

}
