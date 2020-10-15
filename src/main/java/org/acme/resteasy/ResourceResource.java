package org.acme.resteasy;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
@Path("/resource")
public class ResourceResource {

    @GET
    @Path("file")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloFile() throws IOException {
        log.info("/file");
        InputStream resourceAsStream = ResourceResource.class.getResourceAsStream("/META-INF/resources/myfile.properties");
        return IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
    }

    @GET
    @Path("string")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloString() {
        log.info("/string");
        return "string";
    }

}