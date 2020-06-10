package co.in.va.ms.mp.api.service.customer;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("customer")
public class CustomerResource {

    @Inject
    CustomerRepository repository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("id") final int id) {
        return repository.findById(id);
    }

    @GET
    @Path("/age/{toAge}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Integer> getCustomersIdByAge(@PathParam("toAge") final Integer toAge) {
        return repository.findByAgeSegemnt( Integer.valueOf(0), toAge.intValue()).stream()
                .map(customer -> customer.getId()).collect(Collectors.toList());
    }

    @GET
    @Path("/age/{toAge}/{fromAge}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Integer> getCustomersIdByAge(@PathParam("toAge") final Integer toAge,
            @PathParam("fromAge") final Integer fromAge) {
        return repository.findByAgeSegemnt(fromAge.intValue(), toAge.intValue()).stream()
                .map(customer -> customer.getId()).collect(Collectors.toList());
    }
}