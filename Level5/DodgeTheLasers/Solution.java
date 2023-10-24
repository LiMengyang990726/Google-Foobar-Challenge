package Level5.DodgeTheLasers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    // Beatty sequence: 𝑆(𝛼,𝑛)=(𝑛+𝑛′)(𝑛+𝑛′+1)/2−𝑆(𝛽,𝑛′), 𝑛′=⌊(𝛼−1)𝑛⌋,  𝛽=𝛼−1
    private static BigDecimal sqrt2 = new BigDecimal("1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727");

    public static String solution(String s) {

        BigInteger res = calc(new BigInteger(s));
        return res.toString();
    }

    private static BigInteger calc(BigInteger n){

        if(n.equals(BigInteger.ZERO)) return BigInteger.ZERO;

        BigInteger n2 = sqrt2.subtract(BigDecimal.ONE).multiply(new BigDecimal(n)).toBigInteger();

        return n.multiply(n2)
                .add(n.multiply(n.add(BigInteger.ONE)).shiftRight(1))
                .subtract(n2.multiply(n2.add(BigInteger.ONE)).shiftRight(1))
                .subtract(calc(n2));
    }

    // For Self-test
//    public static void main(String[] args){
//        System.out.println(Solution.solution("5"));
//        System.out.println(Solution.solution("77"));
//    }
}
