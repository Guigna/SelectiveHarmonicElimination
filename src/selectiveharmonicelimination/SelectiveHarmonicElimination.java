/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author castudillo
 */
public class SelectiveHarmonicElimination {
    
    //double [] time; //time at which best values are recorded
    //double [] best; // best so far
    
    List<Double> time;
    List<Double> best;
    
//    
//    double angles[][]=
//{
//{0.52344168025609,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.25260931027965,0.84768646658519,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.16714944411539,0.52344168025609,0.98467360499554,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.12504789240211,0.38394101637031,0.67488159015010,1.06510642020896,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.09991263764792,0.30413658252575,0.52344168025609,0.77479422779802,1.11914721793048,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.08294634068884,0.25260931027965,0.42918447492786,0.62272593653515,0.84768646658519,1.15936362553719,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.07100709468060,0.21553480951721,0.36508957530466,0.52344168025609,0.69813170079773,0.90361240841327,1.19015431261107,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.06220975551663,0.18851441065645,0.31733259127170,0.45243458557549,0.59696230041210,0.75782793083894,0.94822748560196,1.21528956736527,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.05529756045923,0.16714944411539,0.28088647187812,0.39902216922283,0.52344168025609,0.65728691182217,0.80684167760962,0.98467360499554,1.23539777116862,0.00000000000000,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.04964212813953,0.15018314715631,0.25260931027965,0.35754899887841,0.46625897569029,0.58188114755959,0.70755742133055,0.84768646658519,1.01546429206943,1.25299244949656,0.00000000000000,0.00000000000000,0.00000000000000},
//{0.04524345855755,0.13635875704150,0.22873081826316,0.32361640496025,0.42101551713275,0.52344168025609,0.63215165706797,0.74965897304383,0.88287582324106,1.04185630956133,1.26807360234908,0.00000000000000,0.00000000000000},
//{0.04147317034442,0.12504789240211,0.20925099582866,0.29596762473063,0.38394101637031,0.47568469622312,0.57182704565791,0.67488159015010,0.78673347380627,0.91303812894609,1.06510642020896,1.28064122972617,0.00000000000000},
//{0.03833126350015,0.11562217186929,0.19291308023844,0.27208913271415,0.35315032929642,0.43672505135412,0.52344168025609,0.61455697874004,0.71258447228139,0.81940930498672,0.94005852780685,1.08521462401232,1.29195209436556}
//};
    

//initial angles, form 1 to 13
    double angles[][]=
{
{0.52344168025609},
{0.25260931027965,0.84768646658519},
{0.16714944411539,0.52344168025609,0.98467360499554},
{0.12504789240211,0.38394101637031,0.67488159015010,1.06510642020896},
{0.09991263764792,0.30413658252575,0.52344168025609,0.77479422779802,1.11914721793048},
{0.08294634068884,0.25260931027965,0.42918447492786,0.62272593653515,0.84768646658519,1.15936362553719},
{0.07100709468060,0.21553480951721,0.36508957530466,0.52344168025609,0.69813170079773,0.90361240841327,1.19015431261107},
{0.06220975551663,0.18851441065645,0.31733259127170,0.45243458557549,0.59696230041210,0.75782793083894,0.94822748560196,1.21528956736527},
{0.05529756045923,0.16714944411539,0.28088647187812,0.39902216922283,0.52344168025609,0.65728691182217,0.80684167760962,0.98467360499554,1.23539777116862},
{0.04964212813953,0.15018314715631,0.25260931027965,0.35754899887841,0.46625897569029,0.58188114755959,0.70755742133055,0.84768646658519,1.01546429206943,1.25299244949656},
{0.04524345855755,0.13635875704150,0.22873081826316,0.32361640496025,0.42101551713275,0.52344168025609,0.63215165706797,0.74965897304383,0.88287582324106,1.04185630956133,1.26807360234908},
{0.04147317034442,0.12504789240211,0.20925099582866,0.29596762473063,0.38394101637031,0.47568469622312,0.57182704565791,0.67488159015010,0.78673347380627,0.91303812894609,1.06510642020896,1.28064122972617},
{0.03833126350015,0.11562217186929,0.19291308023844,0.27208913271415,0.35315032929642,0.43672505135412,0.52344168025609,0.61455697874004,0.71258447228139,0.81940930498672,0.94005852780685,1.08521462401232,1.29195209436556}
};

//THD of the initial solutions    
double []THD={30.01895505922690,16.43767607768410,11.04648404636570,8.34991752964596,6.35812759071053,5.28563115148675,4.50494817695189,3.89399200811655,2.83641379399731,2.38846521189903,2.06930098753316,1.64266642088436,1.46291939766942};
    
    SHENeighborhood neighborhood;
     Random r = new Random();
    Double a[]; //factores

    //numero magico!!!
    //final Double M = 0.998; // en una primera instancia trabajar con M igual a 1
    final  Double M = 1.0; // en una primera instancia trabajar con M igual a 1

   //TAKEN FORM THE PAPER 
    //public Double thd[]={0.0589,0.1019,0.1974,0.2922,0.3815,0.4266,0.5322,0.6146,0.7529,0.8173,0.943,1.0854,1.2725};
    // public Double df1[]={0.0546,0.1078,0.2316,0.2910,0.3805,0.4279,0.5313,0.6153,0.7513,0.8528,0.9448,1.0847,1.2372};
    //public Double df2[]={0.0596,0.1011,0.1989,0.2927,0.3812,0.4269,0.5321,0.6146,0.7528,0.8189,0.9431,1.0854,1.2710};
    private  int n;

    /**
     * Creates random values for the angles, using an arbitrary number of angles
     *
     * @param seed the random seed
     * @param n the number of angles to be used
     */
    public SelectiveHarmonicElimination(Random r, int n, SHENeighborhood neighborhood) {
        this.n = n;
        this.neighborhood=neighborhood;
        this.r = r;
        a = new Double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble() * Math.PI / 2.0;
        }
    }


    /**
     *
     * @param a an array whose the values of the angles have been previously
     * assigned
     * @param seed the random seed
     */
    public SelectiveHarmonicElimination(int seed, Double a[]) {
        this.n = a.length;
        r = new Random(seed);
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble() * Math.PI / 2.0;
        }
    }

    
    
    
    public String displayEquationSystemInLatex() {
        StringBuilder sb = new StringBuilder();
        int values[] = {1, 5, 7, 11, 13, 17, 19, 23, 25, 29, 31, 35, 37};
        sb.append("\\begin{align*}").append("\n");
        for (int value : values) {
            //int value = values[i];
            for (int i = 1; i <= n; i++) {
                //sb.append("Math.cos(").append(value).append("*alpha_").append(i) ;    
                sb.append("\\cos(").append(value).append("\\alpha_{").append(i).append("})");
                if (i < n) {
                    sb.append("+");
                } else {
                    sb.append("& =");
                }
            }
            if (value == 1) //sb.append("(M*Math.pi)/4");
            {
                sb.append("(" + n + "M*\\pi)/4");
            } else {
                sb.append("0");
            }
            sb.append("\\\\").append("\n");
        }
        sb.append("\\end{align*}").append("\n");
        return sb.toString();
    }



    /**
     * public void EvaluateEquations(final int alpha[]){ int
     * values[]={1,5,7,11,13,17,19,23,25,29,31,35,37};
     * //sb.append("\\begin{align*}").append("\n"); Double sum; for (int
     * value:values) { sum=0.0; for (int i = 1; i <=13; i++) {
     * //sb.append("\\cos(").append(value).append("\\alpha_{").append(i).append("})")
     * ; sum+=Math.cos(value*alpha[i]); } if (value==1)
     * //sb.append("(M*Math.pi)/4"); sum-=M*Math.PI/4; } }
*
     */
    /**
     * algoritmo para calcular THD V se calcula a través de la ecuacion de
     * coseno, usando ese formato calcular los V para los 50 primeros termino
     * (desde el 2) (ya sabemos que algunos son cero) cada uno de los V se eleva
     * al cudrado se suman los cuadrados.multiplico por 100 divido 1300 por
     * ahora E es una constante que es 1300, tiene quever con la amplitud de la
     * señal-
     *
     * @param alpha
     * @return
     */
    public Double computeTHD(final Double[] alpha) {

/*
        function THD = myfun(x)
         global M
        f=0;
        for i=1:2:50
        COS=0;
        for j=1:length(x)
            COS=COS+cos(i*x(j));   
        end
        V=4/pi*M/i*COS;
        if(i==1)
            V1=V;
        else
            f = f + V^2;
        end
        end
 
THD=sqrt(f)/V1*100;
        */


        final int KMax = 50;
        //final int E = 1300; // este numero tiene que ver con la amplitud de la señal
        Double V1=0.0;
        Double COS=0.0; //voltaje
        Double sumSquare = 0.0;
        //para calcular el thd se parte desde el tercer indice (que en el caso de java es k=2, puesto que el primero es k=0, el segundo es k=1; pero el segundo es par) recorriendo solo los indices impares (pares en java)
        //hasta el indice 50. que por esta razon el indice 50 queda excluido.
        
        Double V=0.0;
        
        for (int i = 1; i <= KMax; i+=2) { //esta saltandose el primer voltaje que se calcula a partir de los angulos
            COS = 0.0;
            //for (Double x : alpha) { //considera los 13 alpha
            for (int j = 0; j < alpha.length; j++) {
                
                COS = COS + Math.cos(i * alpha[j]);
            }
            V=COS*4*M/(Math.PI*i);
            if(i==1)
                V1=V;
            else
                sumSquare = sumSquare + V * V;
        }    
            //v=v*4*M/(Math.PI*k);             
            //System.out.println("v_"+k+"= "+v);
            //sumSquare += v * v;
        
        return 100* Math.sqrt(sumSquare) / V1;
    }
    
    
    

    /**
     * the cost is a function f() that will be zero when alpha is a solution for
     * the equations in the paper. this is achieved by computing a seudo dot
     * product. the steps are as follows: Vectors V_i are computed for i between
     * 1 to 13 using the formula Vi= Math.cos(k * alpha1);. the first vector,
     * V_1, cofgmputing the square value and subtracting N*M*PI/4. The
     *
     * @param alpha
     * @return
     */
    public Double cost(final Double alpha[]) {
        int values[] = {1, 5, 7, 11, 13, 17, 19, 23, 25, 29, 31, 35, 37}; //13 indices
        Double v;
        Double sumSquare = 0.0;

        //for (int k :values) {
        for (int i = 0; i < alpha.length; i++) {
            double k = values[i]; //read the ocrresponding value from the array
            v = 0.0;
            for (Double alpha1 : alpha) {
                v += Math.cos(k * alpha1);
            }
                //System.out.println("v_"+k+"= "+v);

            if (k == 1) {
                v -= alpha.length * (Math.PI * 1) / 4.0; // el n ya esta incluido en la expresion, el n es el alpha.lenght, y se necesita para calcular la ecuaciones
            }
            sumSquare += v * v;
        }
        return sumSquare;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a + "\n");
        sb.append("Cost: " + cost(a));
        return sb.toString();
    }

    /**
     * The new vector in created at random, respecting the property that ai<a_j
     * for all i<j, and that a_0<=0 and a_n>pi/2.
     *
     * @param n the number of angles to consider
     * @return the newly generated angles vector
     */
    public Double[] initialSolution(int n) {
        //rabdomly generate n numbers between 0 and pi/2
        Double a[] = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextDouble() * Math.PI / 2.0;
        }
        Arrays.sort(a);// soort elements to respect the rules of the angles.
        return a;
    }



    /**
     * Local search heuristic for solving the angles vector equation.
     *
     * @param n the number of angles to be considered
     * @return an array with n angles which is a solution for the angles
     * equations.
     */
    public Double[] localSearch(int n) {
        Double x[];
        Double cx;
        Double y[];
        Double cy;
        
        int tmax = 1000000;// a big number
        
        time=new ArrayList<Double>(); //for recording bestvalues
        best=new ArrayList<Double>();
        
        int t = 0;
        x = initialSolution(n);

        System.out.println("initial solution: ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(" " + x[i]);
        }
        //System.out.print("\ncosto: " + SelectiveHarmonicElimination.cost(x));
        //System.out.println();

        cx = cost(x);
        while (cx > 0.0 && t < tmax) { //if we found the solution or if we spent too much time
            y=neighborhood.nextNeighbor(x);
            cy = cost(y);
            if (cy < cx) {
                cx = cy;
                x = y;
                best.add(cx);
                time.add(new Double(t));
            }

//        System.out.print("x: ");    
//        for (int i = 0; i < x.length; i++) 
//            System.out.print(" "+x[i]);
//        System.out.print(" costo: "+SelectiveHarmonicElimination.cost(x));
//        System.out.print(" | ");        
//        System.out.print("y: ");    
//        for (int i = 0; i < y.length; i++) 
//            System.out.print(" "+y[i]);
//        System.out.println("\tcosto: "+SelectiveHarmonicElimination.cost(y));
            t++;
        }
        return x;
    }

    
    public double[] getTime(){
        double[] timeUnbox=new double[time.size()];
        for (int i = 0; i < timeUnbox.length; i++) {
            timeUnbox[i]=time.get(i);
        }
       //return (Double[]) time.toArray();
       return timeUnbox;
    }
    
    public double[] getBest(){
        double[] bestUnbox=new double[best.size()];
        for (int i = 0; i < bestUnbox.length; i++) {
            bestUnbox[i]=best.get(i);
        }
       //return (Double[]) time.toArray();
       return bestUnbox;

    }
}
