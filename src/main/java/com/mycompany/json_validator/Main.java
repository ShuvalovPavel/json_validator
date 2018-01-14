package com.mycompany.json_validator;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import java.io.IOException;
import java.net.URI;

public class Main {

static String SERVICE_URI = "http://0.0.0.0:8080";

    /**
     * Start server
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ResourceConfig rc = new ResourceConfig().packages("com.mycompany.json_validator");
        rc.register(MultiPartFeature.class);
        rc.register(Resource.class);
        GrizzlyHttpServerFactory.createHttpServer(URI.create(SERVICE_URI), rc);
    }
}
