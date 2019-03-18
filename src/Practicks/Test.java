package Practicks;

import java.math.BigInteger;

public class Test {
    static int calculateFactorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
    public static int factorial(int n)
    {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }
    public static BigInteger factorial2(int n)
    {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }

    public static void main(String[] args){
        System.out.println(factorial2(-10));
    }
}
