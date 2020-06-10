package co.in.va.ms.mp.api.service.order.connector;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/customer")
@RegisterRestClient(configKey = "customer-service")
public interface CustomerServiceProxy {

        @GET
        @Path("/age/{toAge}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Integer> getCustomersIdByAge(@PathParam("toAge") final Integer toAge);

        @GET
        @Path("/age/{toAge}/{fromAge}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Integer> getCustomersIdByAge(@PathParam("toAge") final Integer toAge,
                        @PathParam("fromAge") final Integer fromAge);
}