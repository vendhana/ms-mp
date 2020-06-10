package co.in.va.ms.mp.api.service.order;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

    public List<Order> findAllOrder() {
        return listAll();
    }

    public List<Order> findByCustomer(int customer) {
        return find("customer", customer).list();
    }

    public Order findById(int id) {
        return find("id", id).firstResult();
    }
}
