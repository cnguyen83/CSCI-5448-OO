package com;

import javax.persistence.*;

@Entity
@Table(name = "Addresses", schema = "the_third_meal", catalog = "")
public class AddressesEntity {
    private int addressKey;
    private String streetAddress;
    private String city;
    private String stateProvince;
    private String country;
    private String zip;

    @Id
    @Column(name = "AddressKey")
    public int getAddressKey() {
        return addressKey;
    }

    public void setAddressKey(int addressKey) {
        this.addressKey = addressKey;
    }

    @Basic
    @Column(name = "StreetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "StateProvince")
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "Zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressesEntity that = (AddressesEntity) o;

        if (addressKey != that.addressKey) return false;
        if (streetAddress != null ? !streetAddress.equals(that.streetAddress) : that.streetAddress != null)
            return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (stateProvince != null ? !stateProvince.equals(that.stateProvince) : that.stateProvince != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressKey;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        return result;
    }
}
