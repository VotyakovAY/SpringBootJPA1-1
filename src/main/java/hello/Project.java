package hello;

import javax.persistence.*;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

/**
 * Created by admin1 on 15.03.2017.
 */
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @OneToMany
    @JoinTable(name="projcust",
            joinColumns=@JoinColumn(name="projid"),
            inverseJoinColumns=@JoinColumn(name="custid"))
//    private Collection<Customer> customers;
    private List<Customer> customers = new ArrayList<>();
    protected Project() {}

    public Project(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Project[id=%d, name='%s']",
                id, name);
    }

// end::sample[]

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }
}
