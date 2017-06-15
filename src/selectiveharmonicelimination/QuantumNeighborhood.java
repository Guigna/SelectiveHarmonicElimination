/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.Random;

/**
 * Quantum neighborhood works as follows: given an angles setting, it slightly modifies a single angle by randomly adding or substracting an epsilon quantity, specified as a paramenter
 * @author castudillo
 */
class QuantumNeighborhood extends SHENeighborhood{

    public QuantumNeighborhood(Random r) {
        this.r = r;
    }
    
    Random r;
    
    /**
     * @param current A sequence of angles representing the current solution
     * @return A sequence of angles which are in the neighborhood of the current solution
     */
    @Override
    public Double[] nextNeighbor(final Double[] current) {
        double value;
        Double b[] = new Double[current.length]; //copy array
        for (int i = 0; i < current.length; i++) {
            b[i] = new Double(current[i]);
        }
        //select angle to be modified   
        int index = r.nextInt(current.length);
        if (index == 0) {//first angle
            value = r.nextDouble() * current[index + 1];
        } else if (index < current.length - 1) { //the general case
            value = current[index - 1] + r.nextDouble() * (current[index + 1] - current[index - 1]);
        } else {//last angle
            value = current[index - 1] + r.nextDouble() * (Math.PI / 2.0 - current[index - 1]);
        }
        b[index] = value;//update mutated value
        return b;
    }
    
}
