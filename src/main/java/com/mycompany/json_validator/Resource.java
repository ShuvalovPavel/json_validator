package com.mycompany.json_validator;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.stream.Collectors;
import javax.ws.rs.PathParam;
import org.json.*;



@Path("")

/**
 * @author phn
 */
public class Resource {
    @PUT
    @Path("/{file}")
    
    /**
     * Validate  json file
     * 
     * @param InputStream stream
     * 
     * @return String
     */
    public String checkFile(@PathParam("file") String file, InputStream stream){
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
            " \"resource\"   : \"" + file + "\",\n" +
            " \"request-id\" : \"" + id + "\",\n" +
            "}";
        }
        return returnString;
    }
}
