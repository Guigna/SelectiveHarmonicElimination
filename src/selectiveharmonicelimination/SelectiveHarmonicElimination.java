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
 * @author castudillo
 */
public class SelectiveHarmonicElimination {

    static Random r = new Random();
    Double a[]; //factores

    //numero magico!!!
    //final Double M = 0.998; // en una primera instancia trabajar con M igual a 1
    final static Double M = 1.0; // en una primera instancia trabajar con M igual a 1

   //TAKEN FORM THE PAPER 
    //public Double thd[]={0.0589,0.1019,0.1974,0.2922,0.3815,0.4266,0.5322,0.6146,0.7529,0.8173,0.943,1.0854,1.2725};
    // public Double df1[]={0.0546,0.1078,0.2316,0.2910,0.3805,0.4279,0.5313,0.6153,0.7513,0.8528,0.9448,1.0847,1.2372};
    //public Double df2[]={0.0596,0.1011,0.1989,0.2927,0.3812,0.4269,0.5321,0.6146,0.7528,0.8189,0.9431,1.0854,1.2710};
    private static int n;

    /**
     * Creates random values for the angles, using an arbitrary number of angles
     *
     * @param seed the random seed
     * @param n the number of angles to be used
     */
    public SelectiveHarmonicElimination(int seed, int n) {
        this.n = n;
        r = new Random(seed);
        a = new Double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble() * Math.PI / 2.0;
        }
    }

    /**
     * Creates random values for the angles, using 13 angles by default
     *
     * @param seed the random seed
     */
    public SelectiveHarmonicElimination(int seed) {
        this(seed, 13);
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
     * compute the kth components of V. by replacing the factors into the cosine
     * equation.
     *
     * @param alpha the factors of the angles
     * @param k the index of the Voltage V that is requested
     * @return
     */
    public static Double getV(final Double alpha[], int k) {
        Double V = 0.0;
        for (int i = 0; i < n; i++) {
            double angle = alpha[i];
            //sb.append("\\cos(").append(value).append("\\alpha_{").append(i).append("})") ;    
            V += Math.cos(angle * k);
        }
        return V;
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
    public static Double computeTHD(final Double[] alpha) {

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
    public static Double cost(final Double alpha[]) {
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
    public static Double[] initialSolution(int n) {
        //rabdomly generate n numbers between 0 and pi/2
        Double a[] = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextDouble() * Math.PI / 2.0;
        }
        Arrays.sort(a);// soort elements to respect the rules of the angles.
        return a;
    }

    /**
     * Creates a vector based on the current one. The new vector will have one
     * modified angle.
     *
     * @param a the current angles vector
     * @return a new angles vector which in the the neighborhood of the current
     * vector.
     */
    public static Double[] Neighbor(final Double[] a) {
        //TODO test this method to ensure mutation preserves the axiom
        double value;
        Double b[] = new Double[a.length]; //copy array
        for (int i = 0; i < a.length; i++) {
            b[i] = new Double(a[i]);
        }
        //select angle to be modified   
        int index = r.nextInt(a.length);
        if (index == 0) {//first angle
            value = r.nextDouble() * a[index + 1];
        } else if (index < a.length - 1) { //the general case
            value = a[index - 1] + r.nextDouble() * (a[index + 1] - a[index - 1]);
        } else {//last angle
            value = a[index - 1] + r.nextDouble() * (Math.PI / 2.0 - a[index - 1]);
        }
        b[index] = value;//update mutated value
        return b;
    }

    /**
     * Local search heuristic for solving the angles vector equation.
     *
     * @param n the number of angles to be considered
     * @return an array with n angles which is a solution for the angles
     * equations.
     */
    public static Double[] localSearch(int n) {
        Double x[];
        Double cx;
        Double y[];
        Double cy;
        int tmax = 1000000;// a big number
        int t = 0;
        x = initialSolution(n);

        System.out.println("initial solution: ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(" " + x[i]);
        }
        System.out.print("\ncosto: " + SelectiveHarmonicElimination.cost(x));
        System.out.println();

        cx = cost(x);
        while (cx > 0.0 && t < tmax) { //if we found the solution or if we spent too much time
            y = Neighbor(x);
            y = Neighbor(y);
            //y = Neighbor(y);
            //y = Neighbor(y);
            //y = Neighbor(y);
            cy = cost(y);
            if (cy < cx) {
                cx = cy;
                x = y;
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

}
