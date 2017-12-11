package com;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Orders", schema = "the_third_meal", catalog = "")
public class OrdersEntity {
    private int orderKey;
    private Timestamp createdTime;

    @Id
    @Column(name = "OrderKey")
    public int getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(int orderKey) {
        this.orderKey = orderKey;
    }

    @Basic
    @Column(name = "CreatedTime")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderKey != that.orderKey) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderKey;
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }
}
