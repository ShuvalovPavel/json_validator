package com.mycompany.json_validator;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.stream.Collectors;
import org.json.*;


/* Root resource */
@Path("")

/**
 * Validate  json file
 * 
 * @param InputStream stream
 * 
 * @return String
 */
public class Resource {
    @POST
    
    public String checkFile(InputStream stream){
        Integer a;
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        final String jsonInString = br.lines().collect(Collectors.joining("\n")) + "\n"; 
        String returnString = jsonInString;
        try {
            JSONObject a1 = new JSONObject(jsonInString);
        } catch (JSONException ex) {
            String exception = ex.toString();
            String[] er = exception.split(" at ");
            String errorMessage = er[0]; 
            String errorPlace = er[1]; 
            String id = Integer.toString(ex.hashCode());
            
            returnString = "{\n" +
            " \"errorCode\"  : 12345,\n" +
            " \"errorMessage\" : \"" + errorMessage + "\",\n" +
            " \"errorPlace\" : \"" + errorPlace + "\",\n" +
            " \"resource\"   : \"filename\",\n" +
            " \"request-id\" : \"" + id + "\",\n" +
            "}";
        }
        return returnString;
    }
}
