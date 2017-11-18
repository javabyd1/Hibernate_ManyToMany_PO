package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ORDERS_ID")
    private int ordersId;

    @Column(name = "ORDERS_DATE")
    private LocalDate ordersDate;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

}
