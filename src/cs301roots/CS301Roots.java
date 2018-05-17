/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs301roots;

//Driver for the roots algorithms implemented in this project
public class CS301Roots {

    
    public static void main(String[] args) {
        Function myFuncA = new FunctionA();
        Bisection bisecTest = new Bisection();
        FalsePosition falsePTest = new FalsePosition();
        Newtons newtonTest = new Newtons();
        
        System.out.println("Running bisection algorithm test...");
        bisecTest.runAlg(myFuncA, 0, 1, 100, 0.01);
        bisecTest.runAlg(myFuncA, 1, 3, 100, 0.01);
        bisecTest.runAlg(myFuncA, 3, 4, 100, 0.01);
        
        System.out.println("Running false position test...");
        falsePTest.runAlg(myFuncA, 0, 1, 100, 0.01);
        falsePTest.runAlg(myFuncA, 1, 3, 100, 0.01);
        falsePTest.runAlg(myFuncA, 3, 4, 100, 0.01);
        
        System.out.println("Running Newtons algorithm test...");
        newtonTest.runAlg(myFuncA, 4, 100, 0.01, 0.01);
        
    }
    
}
