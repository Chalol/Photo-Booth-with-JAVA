
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
public class customerdata {

    public static String main(String name,String email,String address) {
       JSONObject obj = new JSONObject();
       obj.put("NAME", name);
       obj.put("EMAIL", email);
       obj.put("ADDRESS", address);
       
       try(FileWriter file = new FileWriter("customerData.json")) {
           file.write(obj.toString());
           file.flush();
       }
       catch(IOException e){
           e.printStackTrace();
       }
       System.out.println(obj);
        return null;
    }
}

