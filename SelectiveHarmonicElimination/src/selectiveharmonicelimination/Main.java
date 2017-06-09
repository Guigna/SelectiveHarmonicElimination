/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

/**
 *
 * @author castudillo
 */
public class Main {
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double seed=Math.random();
        SelectiveHarmonicElimination she = new SelectiveHarmonicElimination((int)seed);
        
        
        //System.out.println(she.displayEquationSystemInLatex());
    }

}
