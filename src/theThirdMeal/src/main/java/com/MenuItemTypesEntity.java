package com;

import javax.persistence.*;

@Entity
@Table(name = "MenuItemTypes", schema = "the_third_meal", catalog = "")
public class MenuItemTypesEntity {
    private byte menuItemTypeKey;
    private String menuItemTypeDescription;

    @Id
    @Column(name = "MenuItemTypeKey")
    public byte getMenuItemTypeKey() {
        return menuItemTypeKey;
    }

    public void setMenuItemTypeKey(byte menuItemTypeKey) {
        this.menuItemTypeKey = menuItemTypeKey;
    }

    @Basic
    @Column(name = "MenuItemTypeDescription")
    public String getMenuItemTypeDescription() {
        return menuItemTypeDescription;
    }

    public void setMenuItemTypeDescription(String menuItemTypeDescription) {
        this.menuItemTypeDescription = menuItemTypeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItemTypesEntity that = (MenuItemTypesEntity) o;

        if (menuItemTypeKey != that.menuItemTypeKey) return false;
        if (menuItemTypeDescription != null ? !menuItemTypeDescription.equals(that.menuItemTypeDescription) : that.menuItemTypeDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) menuItemTypeKey;
        result = 31 * result + (menuItemTypeDescription != null ? menuItemTypeDescription.hashCode() : 0);
        return result;
    }
}
