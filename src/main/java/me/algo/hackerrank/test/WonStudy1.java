package me.algo.hackerrank.test;

public class WonStudy1 {
    public static void main(String[] args) {
        String encoded = "701011792823411101701997927";
        System.out.println(decode(encoded));
    }

    public static String decode(String encoded){
        String reverseEncoded = new StringBuffer(encoded).reverse().toString();
        System.out.println(reverseEncoded);

        int flag = 0;
        int size = reverseEncoded.length();
        String ret = "";

        while(flag < size){
            String targetString = reverseEncoded.substring(flag, flag+2);
            int targetStringToInt = Integer.parseInt(targetString);
            if(targetStringToInt > 64 && targetStringToInt < 91 ||
                targetStringToInt > 96 && targetStringToInt < 100 ||
                targetStringToInt == 32){
                ret += String.valueOf(Character.toChars(targetStringToInt));
                flag +=2;
            }else{
                targetString = reverseEncoded.substring(flag, flag+3);
                targetStringToInt = Integer.parseInt(targetString);
                if(targetStringToInt > 99 && targetStringToInt < 123){
                    ret += String.valueOf(Character.toChars(targetStringToInt));
                    flag +=3;
                }else{
                    break;
                }
            }
        }

        return ret;
    }


}
