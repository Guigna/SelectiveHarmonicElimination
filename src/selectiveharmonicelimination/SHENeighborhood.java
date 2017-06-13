/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

/**
 *Abstract class to define neighborhood functions
 * @author castudillo
 */
abstract class SHENeighborhood {
    abstract public Double[] nextNeighbor(final Double current[]);
}
