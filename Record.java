import java.util.*;

public class Record {
  private HashMap<String,String> data = new HashMap<String,String>();

  public Record(String stateJson){
      parseJson(stateJson);
  }

  private String removeQuotesBackSlashes(String item){
        item = removeCharacters(item, "\"");
        return removeCharacters(item, "\\");
  }

  private String removeCharacters(String item, String character){
        while(item.indexOf(character) != -1){  
            int q = item.indexOf(character);
            item = item.substring(0, q) + item.substring(q + 1); //remove
        }
        return item;
  }

  private void addToMap(String[] kv){
      data.put(kv[0], kv[1]); 
  }

  public String getValueByKey(String key){
      String d = data.get(key);
      if(d.equals("null"))
        d = "0";
      return d; 
  }


  private void parseJson(String json){
      json=removeQuotesBackSlashes(json);
      String[] kv = json.split(",");          
      for(String i : kv){
       
          if(i.indexOf(":") != -1){
            String[] items = i.split(":");
            try{
              addToMap(items);
            }catch(Exception e){
              addToMap(new String[]{i, null});
            }
          }
      }
  }

  public String toString(){
      String s = "===== Record: \n";
      for(String key: data.keySet()){
          s += key + " : " + data.get(key) + "\n";
      }
      
      return s;
  }
}