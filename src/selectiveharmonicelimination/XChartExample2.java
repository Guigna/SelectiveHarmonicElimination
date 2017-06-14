/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectiveharmonicelimination;

import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 *
 * @author castudillo
 */
public class XChartExample2 {
      public static void main(String[] args) {
 
    int numCharts = 2;
 
    List<XYChart> charts = new ArrayList<XYChart>();
 
    for (int i = 0; i < numCharts; i++) {
      XYChart chart = new XYChartBuilder().xAxisTitle("X").yAxisTitle("Y").theme(ChartTheme.GGPlot2).width(600).height(400).build();
      chart.getStyler().setYAxisMin(-10.0);
      chart.getStyler().setYAxisMax(10.0);
      XYSeries series = chart.addSeries("" + i, null, getRandomWalk(200));
      series.setMarker(SeriesMarkers.NONE);
      charts.add(chart);
    }
    
    //charts.get(1).getStyler().theme(ChartTheme.Matlab);
    new SwingWrapper<XYChart>(charts).displayChartMatrix();
  }
 
  /**
   * Generates a set of random walk data
   *
   * @param numPoints
   * @return
   */
  private static double[] getRandomWalk(int numPoints) {
 
    double[] y = new double[numPoints];
    y[0] = 0;
    for (int i = 1; i < y.length; i++) {
      y[i] = y[i - 1] + Math.random() - .5;
    }
    return y;
  }
 
}
