package com;

import javax.persistence.*;

@Entity
@Table(name = "OrderStatuses", schema = "the_third_meal", catalog = "")
public class OrderStatusesEntity {
    private byte orderStatusKey;
    private String orderStatusDescription;

    @Id
    @Column(name = "OrderStatusKey")
    public byte getOrderStatusKey() {
        return orderStatusKey;
    }

    public void setOrderStatusKey(byte orderStatusKey) {
        this.orderStatusKey = orderStatusKey;
    }

    @Basic
    @Column(name = "OrderStatusDescription")
    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStatusesEntity that = (OrderStatusesEntity) o;

        if (orderStatusKey != that.orderStatusKey) return false;
        if (orderStatusDescription != null ? !orderStatusDescription.equals(that.orderStatusDescription) : that.orderStatusDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderStatusKey;
        result = 31 * result + (orderStatusDescription != null ? orderStatusDescription.hashCode() : 0);
        return result;
    }
}
