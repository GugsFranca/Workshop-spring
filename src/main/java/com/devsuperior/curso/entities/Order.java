package com.devsuperior.curso.entities;

import com.devsuperior.curso.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") //Ja tava assim
    private Instant moment;

    private String orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> itens = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {

    }

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        Id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOF(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getName();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItens() {
        return itens;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal(){
        Double sum = 0.0;
        for(OrderItem x : itens){
            sum += x.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        return Objects.equals(Id, order.Id);
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}
