package com;

import javax.persistence.*;

@Entity
@Table(name = "Restaurants", schema = "the_third_meal", catalog = "")
public class RestaurantsEntity {
    private int restaurantKey;
    private String restaurantName;

    @Id
    @Column(name = "RestaurantKey")
    public int getRestaurantKey() {
        return restaurantKey;
    }

    public void setRestaurantKey(int restaurantKey) {
        this.restaurantKey = restaurantKey;
    }

    @Basic
    @Column(name = "RestaurantName")
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantsEntity that = (RestaurantsEntity) o;

        if (restaurantKey != that.restaurantKey) return false;
        if (restaurantName != null ? !restaurantName.equals(that.restaurantName) : that.restaurantName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = restaurantKey;
        result = 31 * result + (restaurantName != null ? restaurantName.hashCode() : 0);
        return result;
    }
}
