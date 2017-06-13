package selectiveharmonicelimination;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author castudillo
 */
public class THDTest {
    
    public THDTest() {
    }
    
 
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
     
         /**
          * Test the THD value for a couple of vectors whose correct THD is Known
          **/
    @Test
     public void testTHD() {              
//Para n=3:
//Ángulos:
//0.2039    0.5442    1.0224
//THD = 11.8954
double epsilon=0.001; 
Double angulos3[]={0.2039,    0.5442,    1.0224};
SelectiveHarmonicElimination she= new SelectiveHarmonicElimination(0, angulos3);
//assertEquals(11.8954,she.computeTHD(angulos3),epsilon);

//Para n=4:
//Ángulos:
//0.1748    0.3865    0.7113    1.0781
//THD = 9.0579
 
Double angulos4[]={0.1748,    0.3865,    0.7113,    1.0781};
assertEquals(9.0579,she.computeTHD(angulos4),epsilon);



//Para n=5:
//Ángulos:
//0.1372    0.3381    0.5175    0.8322    1.1033
//THD = 7.4710
 Double angulos5[]={0.1372, 0.3381,    0.5175,    0.8322,    1.1033};
assertEquals(7.4710,she.computeTHD(angulos5),epsilon);


//Para n=6:
//Ángulos:
//0.1357    0.2925    0.4267    0.6381    0.9274    1.1034
//THD = 7.0868
 
Double angulos6[]={0.1357,   0.2925,    0.4267,    0.6381,    0.9274,    1.1034};
assertEquals(7.0868,she.computeTHD(angulos6),epsilon);
 
                 
     }
}
