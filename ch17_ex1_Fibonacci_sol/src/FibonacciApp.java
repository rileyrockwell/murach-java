/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class FibonacciApp {

    public static void main(String[] args) {
        long iterResult;
        long recResult;
        iterResult = iterFibo(100);
        //recResult = recFibo(45);
        
        System.out.println(iterResult);
        //System.out.println(recResult);
    }
    
    public static int iterFibo(int n) {
        if (n == 0) {          // base case 1
            return 0;
        } else if (n == 1) {  // base case 2
            return 1;
        }
        int n1 = 0, n2 = 1, fib = 0;
        for (int i =  2; i < n+1; i++) {
            fib = n1 + n2;
            n1 = n2;
            n2 = fib;
        }
        return fib;
    }
    
    public static int recFibo(int n) {
        if (n == 0) {         // base case 1
            return 0;
        } else if (n == 1) {  // base case 2
            return 1;
        } else {
            return recFibo(n - 1) + recFibo(n - 2);
        }
    }


}
