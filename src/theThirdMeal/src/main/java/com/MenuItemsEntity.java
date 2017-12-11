package com;

import javax.persistence.*;

@Entity
@Table(name = "MenuItems", schema = "the_third_meal", catalog = "")
public class MenuItemsEntity {
    private int menuItemKey;
    private String menuItemName;
    private String menuItemDescription;
    private double menuItemCost;

    @Id
    @Column(name = "MenuItemKey")
    public int getMenuItemKey() {
        return menuItemKey;
    }

    public void setMenuItemKey(int menuItemKey) {
        this.menuItemKey = menuItemKey;
    }

    @Basic
    @Column(name = "MenuItemName")
    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    @Basic
    @Column(name = "MenuItemDescription")
    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }

    @Basic
    @Column(name = "MenuItemCost")
    public double getMenuItemCost() {
        return menuItemCost;
    }

    public void setMenuItemCost(double menuItemCost) {
        this.menuItemCost = menuItemCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItemsEntity that = (MenuItemsEntity) o;

        if (menuItemKey != that.menuItemKey) return false;
        if (Double.compare(that.menuItemCost, menuItemCost) != 0) return false;
        if (menuItemName != null ? !menuItemName.equals(that.menuItemName) : that.menuItemName != null) return false;
        if (menuItemDescription != null ? !menuItemDescription.equals(that.menuItemDescription) : that.menuItemDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = menuItemKey;
        result = 31 * result + (menuItemName != null ? menuItemName.hashCode() : 0);
        result = 31 * result + (menuItemDescription != null ? menuItemDescription.hashCode() : 0);
        temp = Double.doubleToLongBits(menuItemCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
