/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.Random;

/**
 *
 * @author castudillo
 */
public class SelectiveHarmonicElimination {

    Random r;
    Double a[]; //factores
    
    final Double M = 1.0; // en una primera instancia trabajar con M igual a 1
    
    
    public Double thd[]={0.0589,0.1019,0.1974,0.2922,0.3815,0.4266,0.5322,0.6146,0.7529,0.8173,0.943,1.0854,1.2725};
    public Double df1[]={0.0546,0.1078,0.2316,0.2910,0.3805,0.4279,0.5313,0.6153,0.7513,0.8528,0.9448,1.0847,1.2372};
    public Double df2[]={0.0596,0.1011,0.1989,0.2927,0.3812,0.4269,0.5321,0.6146,0.7528,0.8189,0.9431,1.0854,1.2710};
    private final int n;
    
    


    /**
     * Creates random values for the angles, using an arbitrary number of angles
     * @param seed the random seed
     * @param n the number of angles to be used
     */
        public SelectiveHarmonicElimination(int seed, int n){
            this.n=n;
            r= new Random(seed);
            a= new Double[n];
            for (int i = 0; i < a.length; i++) {
                a[i]=r.nextDouble()*Math.PI/2.0;
            }
    }        
   
     /**
     * Creates random values for the angles, using 13 angles by default
     * @param seed the random seed
     */
        public SelectiveHarmonicElimination(int seed){
            this(seed,13);
    }
        
        /**
         * 
         * @param a an array whose the values of the angles have been previously assigned
         * @param seed the random seed
         */
        public SelectiveHarmonicElimination(int seed,Double a[]){
            this.n=a.length;
            r=new Random(seed);
            for (int i = 0; i < a.length; i++) {
                a[i]=r.nextDouble()*Math.PI/2.0;
            }
    }
        
        
    public String displayEquationSystemInLatex(){
        StringBuilder sb=new StringBuilder();
        int values[]={1,5,7,11,13,17,19,23,25,29,31,35,37};
        sb.append("\\begin{align*}").append("\n");
        for (int value:values) {
            //int value = values[i];
            for (int i = 1; i <=n; i++) {
                //sb.append("Math.cos(").append(value).append("*alpha_").append(i) ;    
                sb.append("\\cos(").append(value).append("\\alpha_{").append(i).append("})") ;    
                if(i<n)
                    sb.append("+");
                else
                    sb.append("& =");
            }
            if (value==1)
                //sb.append("(M*Math.pi)/4");
                sb.append("("+n+"M*\\pi)/4");
            else
                sb.append("0");
            sb.append("\\\\").append("\n");
        }
        sb.append("\\end{align*}").append("\n");
        return sb.toString();
    }
    
    
    
    /**
     * compute the kth components of V. by replacing the factors into the cosine equation.
     * @param alpha the factors of the angles
     * @param k 
     * @return 
     */
    public static Double getV(Double alpha[],int k){
        Double V=0.0;
            for (Double angle:alpha) {
                //sb.append("\\cos(").append(value).append("\\alpha_{").append(i).append("})") ;    
                V+=Math.cos(angle*k);
            }
        return V;    
        }


    public void EvaluateEquations(int alpha[]){
        int values[]={1,5,7,11,13,17,19,23,25,29,31,35,37};
        //sb.append("\\begin{align*}").append("\n");
        Double sum;
        for (int value:values) {
            sum=0.0;
            for (int i = 1; i <=13; i++) {
                //sb.append("\\cos(").append(value).append("\\alpha_{").append(i).append("})") ;    
                sum+=Math.cos(value*alpha[i]);
            }
            if (value==1)
                //sb.append("(M*Math.pi)/4");
                sum-=M*Math.PI/4;
        }
    }



    
    
    
    /**
     * algoritmo para calcular THD
        V se calcula a traves de la ecuacion de coseno, usando ese formato
        calcular los V para los 50 primeros termino (desde el 2) (ya sabemos que algunos son cero)
        cada uno de los V se eleva al cudrado
        se suman los cuadrados.multiplico por 100 divido 1300
        por ahora E es una constante que es 1300, tiene quever con la amplitud de la señal-
     * @param alpha
     * @return
     */
    public static Double computeTHD(Double alpha[]){
        final int KMax=50;
        final int E=1300;
        Double v;
        Double sumSquare=0.0;
            for (int k = 1; k <=KMax; k++) {
                v=0.0;
            for (Double alpha1 : alpha) {
                v += Math.cos(k * alpha1);
            }
                //System.out.println("v_"+k+"= "+v);
                sumSquare+=v*v;
            }
        return 100*Math.sqrt(sumSquare)/E;
        }
        
        
    /**
     * the cost is a funcition f() that will be zero when alpha is a solution for the equations in the paper.
     * this is achieved by computing a seudo dot product. the steps are as follows:
     * Vectors V_i are computed for i between 1 to 13 using the formula Vi= Math.cos(k * alpha1);.
     * the first vector, V_1, computing the square value and subtracting N*M*PI/4.
     * The 
     * @param alpha
     * @return
     */
    public static Double cost(Double alpha[]){
        int values[]={1,5,7,11,13,17,19,23,25,29,31,35,37};
        Double v;
        Double sumSquare=0.0;
        
            for (int k :values) {
                v=0.0;
            for (Double alpha1 : alpha) {
                v += Math.cos(k * alpha1);
            }
                //System.out.println("v_"+k+"= "+v);
            
            if(k==1)
                v-=(Math.PI*1*13)/4.0;
            sumSquare+=v*v;
            }
        return sumSquare;
        }
    
    
    
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(a+"\n");
        sb.append("Cost: "+cost(a));
        return sb.toString();
    }

    
   
    
    
}
