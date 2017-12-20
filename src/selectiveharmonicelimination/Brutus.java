/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author castudil
 */
public class Brutus{
    int n;
    protected Random r;
    double []angle;
    double error;        

    /**
    @param seed random seed
    @param n number of angles
    */
    public Brutus(int seed,int n) {
        this.n=n;
         r = new Random(seed);
    }

    /**
     * 
     * @return random feasible solution
     */
    public double[] generateRandomSolution(){
        double[]  a = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble() * Math.PI / 2.0;
        } 
        // sorting array
        Arrays.sort(a);
        return a;
    }


}
