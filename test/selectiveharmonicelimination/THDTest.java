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
import org.junit.Ignore;

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
     * This test check if the equations are actually zero
     * @param alpha
     * @return 
     */
    //@Ignore
    @Test
       public void ZeroTest(){
        int valuesThatAreSuposedToBeZero[]={1,5,7,11,13,17,19,23,25,29,31,35,37};
         Double thdBAD[]={0.0589,0.1019,0.1974,0.2922,0.3815,0.4266,0.5322,0.6146,0.7529,0.8173,0.943,1.0854,1.2725};
         Double thdGOOD[]={0.0545,    0.1080,    0.2318,    0.2909,    0.3806,    0.4279,    0.5313,    0.6153,    0.7513,    0.8530,    0.9448,    1.0847,    1.2369};
        
        final int KMax=50;
        final int E=1300;
        Double v;
        Double sumSquare=0.0;
        System.out.println("n*M*pi/4 = "+13*1*Math.PI/4);
            for (int k : valuesThatAreSuposedToBeZero) {
                System.out.println("v_"+k+"= "+SelectiveHarmonicElimination.getV(thdGOOD, k));
            }
            System.out.println("cost() = "+SelectiveHarmonicElimination.cost(thdGOOD));
        //return 100*Math.sqrt(sumSquare)/E;
        }
    
    
    
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void computeTHDTest() {

         Double thdBAD[]={0.0589,0.1019,0.1974,0.2922,0.3815,0.4266,0.5322,0.6146,0.7529,0.8173,0.943,1.0854,1.2725};
         Double thdGOOD[]={0.0545,    0.1080,    0.2318,    0.2909,    0.3806,    0.4279,    0.5313,    0.6153,    0.7513,    0.8530,    0.9448,    1.0847,    1.2369};
         //int seed=0;
         //SelectiveHarmonicElimination she=new SelectiveHarmonicElimination(seed, thd);
         double total=SelectiveHarmonicElimination.computeTHD(thdGOOD);
         System.out.println("THD: "+total);
                 
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
assertEquals(11.8954,SelectiveHarmonicElimination.computeTHD(angulos3),epsilon);

//Para n=4:
//Ángulos:
//0.1748    0.3865    0.7113    1.0781
//THD = 9.0579
 
Double angulos4[]={0.1748,    0.3865,    0.7113,    1.0781};
assertEquals(9.0579,SelectiveHarmonicElimination.computeTHD(angulos4),epsilon);



//Para n=5:
//Ángulos:
//0.1372    0.3381    0.5175    0.8322    1.1033
//THD = 7.4710
 Double angulos5[]={0.1372, 0.3381,    0.5175,    0.8322,    1.1033};
assertEquals(7.4710,SelectiveHarmonicElimination.computeTHD(angulos5),epsilon);


//Para n=6:
//Ángulos:
//0.1357    0.2925    0.4267    0.6381    0.9274    1.1034
//THD = 7.0868
 
Double angulos6[]={0.1357,   0.2925,    0.4267,    0.6381,    0.9274,    1.1034};
assertEquals(7.0868,SelectiveHarmonicElimination.computeTHD(angulos6),epsilon);
 
                 
     }
}
