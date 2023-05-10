import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;

public class BarChartProject extends ApplicationFrame {
  //LOOK HERE
  private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/opioids/opioids.csv");
  
  //STUDY THIS
  public BarChartProject() {
      super( "Name Your Chart" );        
      JFreeChart barChart = ChartFactory.createBarChart(
         "Synthetic and Prescription Opioid Overdose Deaths",           
         "Years",            
         "Overdose Deaths",            
         createDataset(id.getData()),    //NOTICE THIS !      
         PlotOrientation.VERTICAL,           
         true, true, false);
      
    
    //   CategoryPlot plot = barChart.getCategoryPlot();
    //   BarRenderer renderer = (BarRenderer) plot.getRenderer();

    //   // set the color (r,g,b) or (r,g,b,a)
    //   Color color = new Color(255, 129, 189);
    //   Color color1 = new Color(150, 129, 189);
    //   Color color2 = new Color(0, 129, 189);
    //   renderer.setSeriesPaint(0, color);
    //   renderer.setSeriesPaint(1, color1);
    //   renderer.setSeriesPaint(2, color2);


      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
      this.pack( );          
      this.setVisible( true ); 
   }
   
   private CategoryDataset createDataset(ArrayList<Record> records) {      
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      //Create a dataset --
      for(Record r : records){
         String year = r.getValueByIndex(0);
         int prescription = Integer.parseInt(r.getValueByIndex(3));
         int synthetic = Integer.parseInt(r.getValueByIndex(4));
         

         if(major.equals("Computer Science and Math")){
            dataset.addValue(asian, "asian", year);
            dataset.addValue(minority, "minority", year);
            dataset.addValue(white, "white", year);
         }
      }
      return dataset; 
   }

   public static void main(String[] args) {
      new BarChartProject();
   }
}