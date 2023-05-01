import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ui.ApplicationFrame; 
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.plot.CategoryPlot;
import java.awt.*;
import java.util.*;

public class BarChartExample extends ApplicationFrame {
  //LOOK HERE
  private ImportData id = new ImportData();
  
  //STUDY THIS
  public BarChartExample() {
      super( "Covid Test Tracking" );        
      JFreeChart barChart = ChartFactory.createBarChart(
         "Number of tests per state",           
         "State",            
         "Total Tests",            
         createDataset(ct.getData()),    //NOTICE THIS !      
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      // CategoryPlot plot = barChart.getCategoryPlot();
      // BarRenderer renderer = (BarRenderer) plot.getRenderer();

      // // set the color (r,g,b) or (r,g,b,a)
      // Color color = new Color(255, 129, 189);
      // Color color1 = new Color(150, 129, 189);
      // Color color2 = new Color(0, 129, 189);
      // renderer.setSeriesPaint(0, color);
      // renderer.setSeriesPaint(1, color1);
      // renderer.setSeriesPaint(2, color2);


      // ChartPanel chartPanel = new ChartPanel( barChart );        
      // chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      // setContentPane( chartPanel ); 
      // this.pack( );          
      // this.setVisible( true ); 
   }
   
   private CategoryDataset createDataset(ArrayList<Record> records ) {      
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      //1. Create a dataset --

      // Record s = records.get(0);
      // int total = Integer.parseInt(s.getValueByKey("total"));
      // int neg = Integer.parseInt(s.getValueByKey("negative")) ;
      // int pos = Integer.parseInt(s.getValueByKey("positive")) ;
   
      // String state = s.getValueByKey("state");
      // dataset.addValue(total, "Total", state);
      // dataset.addValue(neg, "Negative", state);
      // dataset.addValue(pos, "Positive", state);
      
      dataset.addValue(Integer.parseInt("44000"), "Total", "WA");
      dataset.addValue(Integer.parseInt("40000"), "Negative", "WA");
      dataset.addValue(Integer.parseInt("4000"), "Positive", "WA");
      
      dataset.addValue(Integer.parseInt("35000"), "Total", "VI");
      dataset.addValue(Integer.parseInt("30000"), "Negative", "VI");
      dataset.addValue(Integer.parseInt("5000"), "Positive", "VI");



      //2. Now run it -- takes a while ...
      //3. Set up for tonight piece:
      //      a. Get any record from states list -- do you get this?
      //      b. Get the state abbr
      //      c. Get the total tests value
      //4. You job is to loop over the entire states list and set up the dataset so it renders everything
      return dataset; 
   }

}