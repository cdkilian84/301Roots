/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs301roots;

//implements Newton-Raphson method
public class Newtons {
    
    public void runAlg(Function func, double x, int nMax, double epsilon, double delta){
       double fOfX = func.theFunction(x);
       
       System.out.println("n = 0, x = " + x + ", f(x) = " + fOfX);
       
       for(int n = 1; n <= nMax; n++){
           double derivOfX = func.derivativeOfTheFunction(x);
           if(Math.abs(derivOfX) < delta){
               System.out.println("small derivative");
               break;
           }
           double d = fOfX / derivOfX;
           x = x - d;
           fOfX = func.theFunction(x);
           System.out.println("n = " + n + ", x = " + x + ", f(x) = " + fOfX);
           
           if(Math.abs(d) < epsilon){
               System.out.println("Convergence achieved");
               break;
           }
       }
       
    }
    
}
