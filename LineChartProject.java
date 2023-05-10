import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;

public class LineChartProject extends ApplicationFrame {
  //LOOK HERE
  private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/graduates/graduates.csv");
  
  //STUDY THIS
  public LineChartProject() {
      super( "Name Your Chart" );        
      JFreeChart lineChart = ChartFactory.createLineChart(
         "Computer Science Degree by Ethnicity",           
         "Years",            
         "Computer Science Degrees",            
         createDataset(id.getData()),    //NOTICE THIS !      
         PlotOrientation.VERTICAL,           
         true, true, false);
      
      //HOW TO COLOR BARS
      // CategoryPlot plot = barChart.getCategoryPlot();
      // BarRenderer renderer = (BarRenderer) plot.getRenderer();

      // // set the color (r,g,b) or (r,g,b,a)
      // Color color = new Color(255, 129, 189);
      // Color color1 = new Color(150, 129, 189);
      // Color color2 = new Color(0, 129, 189);
      // renderer.setSeriesPaint(0, color);
      // renderer.setSeriesPaint(1, color1);
      // renderer.setSeriesPaint(2, color2);


      ChartPanel chartPanel = new ChartPanel( lineChart );        
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
         String major = r.getValueByIndex(2);
         int asian = Integer.parseInt(r.getValueByIndex(9));
         int minority = Integer.parseInt(r.getValueByIndex(10));
         int white = Integer.parseInt(r.getValueByIndex(11));

         if(major.equals("Computer Science and Math")){
            dataset.addValue(asian, major, year);
            dataset.addValue(minority, major, year);
            dataset.addValue(white, major, year);
         }
      }
      return dataset; 
   }

   public static void main(String[] args) {
      new BarChartProject();
   }
}
