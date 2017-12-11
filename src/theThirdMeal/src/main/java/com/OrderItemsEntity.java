package com;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems", schema = "the_third_meal", catalog = "")
public class OrderItemsEntity {
    private int orderItemKey;
    private byte quantity;

    @Id
    @Column(name = "OrderItemKey")
    public int getOrderItemKey() {
        return orderItemKey;
    }

    public void setOrderItemKey(int orderItemKey) {
        this.orderItemKey = orderItemKey;
    }

    @Basic
    @Column(name = "Quantity")
    public byte getQuantity() {
        return quantity;
    }

    public void setQuantity(byte quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemsEntity that = (OrderItemsEntity) o;

        if (orderItemKey != that.orderItemKey) return false;
        if (quantity != that.quantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderItemKey;
        result = 31 * result + (int) quantity;
        return result;
    }
}
