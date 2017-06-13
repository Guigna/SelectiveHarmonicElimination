/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.Random;
import org.junit.Test;

/**
 *
 * @author castudillo
 */
public class LocalSearchTest {


    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testFindSolution() {
        Random r=new Random();
        SelectiveHarmonicElimination she=new SelectiveHarmonicElimination(r, 4, new SimpleRandomNeighborhood(r));
        Double sol[]=she.localSearch(4);
        //Arrays.toString(sol);
        //System.out.println("OK"+sol);
        for (int i = 0; i < sol.length; i++) {
            System.out.print(" "+sol[i]);
        }
        System.out.println();
        System.out.println("costo: "+she.cost(sol));
        System.out.println("THD: "+she.computeTHD(sol));
    }
    
}
