
package com.proyecto_hospital.vista;



import java.text.DecimalFormat;
import javax.swing.JInternalFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
/**
 * @author imssbora
 */
public class PieChartExample extends JInternalFrame {
  private static final long serialVersionUID = 6294689542092367723L;

  public PieChartExample(String title) {
    super(title);

    // Create dataset
    PieDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createPieChart(
        "Estadisticas de Paciente",
        dataset,
        true, 
        true,
        false);

    //Format Label
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
        "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
    
    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private PieDataset createDataset() {

    DefaultPieDataset dataset=new DefaultPieDataset();
      dataset.setValue("Pacientes con complicaciones", 30);
      dataset.setValue("Pacientes covid", 70);
  
   
   
    return dataset;
  }

//  public static void main(String[] args) {
//    SwingUtilities.invokeLater(() -> {
//      PieChartExample example = new PieChartExample("Ver Estadistica");
//      example.setSize(800, 400);
//      //xample.setLocationRelativeTo(null);
//      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//      example.setVisible(true);
//    });
//  }
  }