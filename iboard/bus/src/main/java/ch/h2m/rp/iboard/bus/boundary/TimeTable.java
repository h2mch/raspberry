package ch.h2m.rp.iboard.bus.boundary;

import ch.h2m.rp.iboard.bus.control.Service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by hem on 28.10.2016.
 */
@Path("timetable")
@Produces("application/json")
public class TimeTable {

    @Inject
    Service service;

    @GET
    @Path("sternmatt")
    public Response helloWorld() throws IOException {
        List<String> nextDeparture = service.getNextDeparture();
        String depature = nextDeparture.stream().collect(Collectors.joining(" | "));
        return Response.ok(depature).build();
    }



}
