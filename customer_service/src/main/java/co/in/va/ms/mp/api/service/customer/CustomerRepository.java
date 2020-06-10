package co.in.va.ms.mp.api.service.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public Customer findById(final int id) {
        return find("id", id).firstResult();
    }

    public List<Customer> findByAgeSegemnt(final int fromAge, final int toAge) {
        Map<String, Object> params = new HashMap<>();
        params.put("fromAge", fromAge);
        params.put("toAge", toAge);
        return find("age >= :fromAge and age <= :toAge", params).list();
    }
}