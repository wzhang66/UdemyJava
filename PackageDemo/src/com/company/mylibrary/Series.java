package com.company.mylibrary;

public class Series {
    public static long nSum(int n) {
        return (n*(n+1))/2;
    }

    public static long factorial(int n){
        if(n == 0){
            return 1;
        } else if(n > 0){
            long fact = 1;
            for(int i=1; i<=n; i++){
                fact = fact*i;
            }
            return fact;
        } else {
            return -1;
        }
    }

    public static long fibonaci(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else if(n > 1){
            long nMinus1 = 1;
            long nMinus2 = 0;
            long fib = 0;
            for(int i=1; i<n; i++){
                fib = nMinus1 + nMinus2;
                nMinus2 = nMinus1;
                nMinus1 = fib;
            }
            return fib;
        } else {
            return -1;
        }
    }

}
