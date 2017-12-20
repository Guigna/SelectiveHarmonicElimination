/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author castudil
 */
public class BrutusTest {
    
    public BrutusTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateRandomSolution method, of class Brutus.
     */
    @Test
    public void testGenerateRandomSolution() {
        System.out.println("generateRandomSolution");
        Brutus brutus = new Brutus(0,13);
        
        for (int i = 0; i < 1000; i++) {
            
                    double[] result = brutus.generateRandomSolution();
            //System.out.println(Arrays.toString(result));

            for (int j = 1; j < result.length; j++) {
                assertTrue(result[j - 1] < result[j]);
            }
            assertTrue(result[0] > 0);
            assertTrue(result[result.length - 1] < Math.PI / 2);
            
        }
    }
    
}
