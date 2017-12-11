package com;

import javax.persistence.*;

@Entity
@Table(name = "Menus", schema = "the_third_meal", catalog = "")
public class MenusEntity {
    private int menuKey;
    private String menuName;

    @Id
    @Column(name = "MenuKey")
    public int getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(int menuKey) {
        this.menuKey = menuKey;
    }

    @Basic
    @Column(name = "MenuName")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenusEntity that = (MenusEntity) o;

        if (menuKey != that.menuKey) return false;
        if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuKey;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        return result;
    }
}
