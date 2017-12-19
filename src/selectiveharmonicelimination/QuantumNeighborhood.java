/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.Random;

/**
 * Quantum neighborhood works as follows: given an angles setting, it slightly
 * modifies a single angle by randomly adding or substracting an epsilon
 * quantity, specified as a paramenter
 *
 * @author César Astudillo <cesar dot astudillo at gmail dot com>
 */
class QuantumNeighborhood extends SHENeighborhood {

    public QuantumNeighborhood(Random r, double epsilon) {
        this.r = r;
        this.epsilon = epsilon;
    }

    Random r;
    double epsilon;

    /**
     * @param current A sequence of angles representing the current solution
     * @return A sequence of angles which are in the neighborhood of the current
     * solution
     */
    @Override
    public Double[] nextNeighbor(final Double[] current) {
        double value = 0.0;
        Double b[] = new Double[current.length]; //copy array
        for (int i = 0; i < current.length; i++) {
            b[i] = new Double(current[i]);
        }

        int index = r.nextInt(current.length); //select angle to be modified   
        int flipcoin = r.nextInt(2) * 2 - 1; //-1 or +1
        value = b[index] + flipcoin * epsilon;
        if (index == 0) {//first angle
            if (value > 0.0 && value < current[index + 1]) //within range
            {
                b[index] = value;
            }
        } else if (index < current.length - 1) { //the general case
            if (value > current[index - 1] && value < current[index + 1]) //within range
            {
                b[index] = value;
            }
        } else {//last angle
            if (value < Math.PI / 2.0 && value > current[index - 1]) //within range
            {
                b[index] = value;
            }
        }

        return b;
    }

}
