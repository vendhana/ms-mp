package co.in.va.ms.mp.api.service.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import co.in.va.ms.mp.api.service.order.connector.CustomerServiceProxy;

@Path("/order")
public class OrderResource {

    @Inject
    OrderRepository repository;

    @Inject
    @RestClient
    CustomerServiceProxy customerServiceProxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders() {
        return repository.findAllOrder();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Order getOrderById(@PathParam("id") final int id) {
        return repository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/customer/{id}")
    public List<Order> getOrdersByCustomerId(@PathParam("id") final int id) {
        return repository.findByCustomer(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/customer/age/{toAge}")
    @Fallback(fallbackMethod = "getDefaultOrders")
    public List<Order> getOrdersByCustomerAgeSegment(@PathParam("toAge") final Integer toAge) {
        final List<Integer> customerIdList = customerServiceProxy.getCustomersIdByAge(toAge);
        List<Order> orderList = customerIdList.stream().map(id -> repository.findByCustomer(id))
                .flatMap(orderlist -> orderlist.stream()).collect(Collectors.toList());
        return orderList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/customer/age/{toAge}/{fromAge}")
    @Fallback(fallbackMethod = "getDefaultOrders")
    public List<Order> getOrdersByCustomerAgeSegment(@PathParam("toAge") final Integer toAge,
            @PathParam("fromAge") final Integer fromAge) {
        final List<Integer> customerIdList = customerServiceProxy.getCustomersIdByAge(toAge, fromAge);
        List<Order> orderList = customerIdList.stream().map(id -> repository.findByCustomer(id))
                .flatMap(orderlist -> orderlist.stream()).collect(Collectors.toList());
        return orderList;
    }

    public List<Order> getDefaultOrders(@PathParam("toAge") Integer toAge) {
        return new ArrayList<Order>();
    }

    public List<Order> getDefaultOrders(@PathParam("toAge") Integer toAge, @PathParam("fromAge")  Integer fromAge) {
        return new ArrayList<Order>();
    }
}