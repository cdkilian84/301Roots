//Christopher Kilian
//CS 301 - Spring 2018
//Project 2 - Roots

package cs301roots;

//Driver for the roots algorithms implemented in this project
public class CS301Roots {
    private static final double ZERO_THRESHHOLD = 0.001;
    private static final double RELATIVE_ERROR = 0.01;
    
    public static void main(String[] args) {
        Function myFuncA = new FunctionA();
        Function myFuncB = new FunctionB();
        Bisection bisecTest = new Bisection();
        FalsePosition falsePTest = new FalsePosition();
        Newtons newtonTest = new Newtons();
        Secant secantTest = new Secant();
        ModifiedSecant modifiedSecantTest = new ModifiedSecant();
        
        //Gather plot data from function A and B
//        ((FunctionA)myFuncA).plotFunction(-30, 30);
//        ((FunctionB)myFuncB).plotFunction(105, 135);
        
        

        System.out.println("Running Bisection algorithm test...");
        System.out.println("Running on function A for 3 roots:");
        bisecTest.runAlg(myFuncA, 0, 1, 100, RELATIVE_ERROR);
        bisecTest.runAlg(myFuncA, 1, 3, 100, RELATIVE_ERROR);
        bisecTest.runAlg(myFuncA, 3, 4, 100, RELATIVE_ERROR);
        System.out.println("Running on function B for 1 root:");
        bisecTest.runAlg(myFuncB, 120, 130, 100, RELATIVE_ERROR); //function B
        
        System.out.println("Running False Position test...");
        System.out.println("Running on function A for 3 roots:");
        falsePTest.runAlg(myFuncA, 0, 1, 100, RELATIVE_ERROR);
        falsePTest.runAlg(myFuncA, 1, 3, 100, RELATIVE_ERROR);
        falsePTest.runAlg(myFuncA, 3, 4, 100, RELATIVE_ERROR);
        System.out.println("Running on function B for 1 root:");
        falsePTest.runAlg(myFuncB, 120, 130, 100, RELATIVE_ERROR); //function B
        
        System.out.println("Running Newtons algorithm test...");
        System.out.println("Running on function A for 3 roots:");
        newtonTest.runAlg(myFuncA, 1, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        newtonTest.runAlg(myFuncA, 2, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        newtonTest.runAlg(myFuncA, 3, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        System.out.println("Running on function B for 1 root:");
        newtonTest.runAlg(myFuncB, 120, 100, RELATIVE_ERROR, ZERO_THRESHHOLD); //function B
        
        System.out.println("Running Secant algorithm test...");
        System.out.println("Running on function A for 3 roots:");
        secantTest.runAlg(myFuncA, 0.1, 1, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        secantTest.runAlg(myFuncA, 1, 2, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        secantTest.runAlg(myFuncA, 3, 4, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        System.out.println("Running on function B for 1 root:");
        secantTest.runAlg(myFuncB, 120, 130, 100, RELATIVE_ERROR, ZERO_THRESHHOLD); //function B
        
        System.out.println("Running Modified Secant algorithm test...");
        System.out.println("Running on function A for 3 roots:");
        modifiedSecantTest.runAlg(myFuncA, 1, 0.01, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        modifiedSecantTest.runAlg(myFuncA, 2, 0.01, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        modifiedSecantTest.runAlg(myFuncA, 3, 0.01, 100, RELATIVE_ERROR, ZERO_THRESHHOLD);
        System.out.println("Running on function B for 1 root:");
        modifiedSecantTest.runAlg(myFuncB, 120, 0.01, 100, RELATIVE_ERROR, ZERO_THRESHHOLD); //function B
        
        
    }
    
}
