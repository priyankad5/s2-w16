import java.net.*;
import java.io.*;
import java.util.*;

public class ImportData {
  
  ArrayList<Record> data = new ArrayList<Record>();
  
  public ImportData()  {
    try{
        //1. GET THE DATA from 
        URL url = new URL("https://think.cs.vt.edu/corgis/datasets/csv/food_access/food_access.csv");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
  
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer content = new StringBuffer();
        String inputLine = in.readLine();
        while (inputLine != null) {
            content.append(inputLine);
            inputLine = in.readLine();
        }
        
        //parseJson(content.toString());
        System.out.println(content.toString());
        in.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }


  public ArrayList<Record> getData(){
    return data;
  }

  public void parseJson(String content){
      //remove the first and last character
      content = content.substring(2, content.length() - 2);
      String delim = "\\},\\{";
      String[] r = content.split(delim);
      for(String x: r){
        data.add(new Record(x)); 
      }  
  }


}