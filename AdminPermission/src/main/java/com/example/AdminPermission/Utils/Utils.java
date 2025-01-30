package com.example.AdminPermission.Utils;

import java.util.Random;

public  class Utils {


    public static  String  generateAdminToken() {
        String alphabet = "wvwrjfjJWJFNKIWNW@@#(E@JN@R(@)!Nfwjf23jnv3j4n*@&**$*!(!((@(#*@bvjvbvevn!(@";

        Random random = new Random();
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < 10; i++) {

            int randomIndex = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(randomIndex);

            token.append(randomChar);
        }
        return token.toString();
    }

}
