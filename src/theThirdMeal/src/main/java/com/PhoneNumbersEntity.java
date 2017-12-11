package com;

import javax.persistence.*;

@Entity
@Table(name = "PhoneNumbers", schema = "the_third_meal", catalog = "")
public class PhoneNumbersEntity {
    private int phoneNumberKey;
    private String areaCode;
    private String numberMid;
    private String numberEnd;

    @Id
    @Column(name = "PhoneNumberKey")
    public int getPhoneNumberKey() {
        return phoneNumberKey;
    }

    public void setPhoneNumberKey(int phoneNumberKey) {
        this.phoneNumberKey = phoneNumberKey;
    }

    @Basic
    @Column(name = "AreaCode")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Basic
    @Column(name = "NumberMid")
    public String getNumberMid() {
        return numberMid;
    }

    public void setNumberMid(String numberMid) {
        this.numberMid = numberMid;
    }

    @Basic
    @Column(name = "NumberEnd")
    public String getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(String numberEnd) {
        this.numberEnd = numberEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumbersEntity that = (PhoneNumbersEntity) o;

        if (phoneNumberKey != that.phoneNumberKey) return false;
        if (areaCode != null ? !areaCode.equals(that.areaCode) : that.areaCode != null) return false;
        if (numberMid != null ? !numberMid.equals(that.numberMid) : that.numberMid != null) return false;
        if (numberEnd != null ? !numberEnd.equals(that.numberEnd) : that.numberEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phoneNumberKey;
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        result = 31 * result + (numberMid != null ? numberMid.hashCode() : 0);
        result = 31 * result + (numberEnd != null ? numberEnd.hashCode() : 0);
        return result;
    }
}
