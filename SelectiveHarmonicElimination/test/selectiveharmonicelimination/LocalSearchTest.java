/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author castudillo
 */
public class LocalSearchTest {


    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testFindSolution() {
        Double sol[]=SelectiveHarmonicElimination.findSolution(13);
        //Arrays.toString(sol);
        //System.out.println("OK"+sol);
        for (int i = 0; i < sol.length; i++) {
            System.out.print(" "+sol[i]);
        }
        System.out.println();
        System.out.println("costo: "+SelectiveHarmonicElimination.cost(sol));
        System.out.println("THD: "+SelectiveHarmonicElimination.computeTHD(sol));
    }
    
}
