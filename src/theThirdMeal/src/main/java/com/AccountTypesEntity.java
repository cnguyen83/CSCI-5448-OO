package com;

import javax.persistence.*;

@Entity
@Table(name = "AccountTypes", schema = "the_third_meal", catalog = "")
public class AccountTypesEntity {
    private byte accountTypeKey;
    private String accountTypeDescription;

    @Id
    @Column(name = "AccountTypeKey")
    public byte getAccountTypeKey() {
        return accountTypeKey;
    }

    public void setAccountTypeKey(byte accountTypeKey) {
        this.accountTypeKey = accountTypeKey;
    }

    @Basic
    @Column(name = "AccountTypeDescription")
    public String getAccountTypeDescription() {
        return accountTypeDescription;
    }

    public void setAccountTypeDescription(String accountTypeDescription) {
        this.accountTypeDescription = accountTypeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountTypesEntity that = (AccountTypesEntity) o;

        if (accountTypeKey != that.accountTypeKey) return false;
        if (accountTypeDescription != null ? !accountTypeDescription.equals(that.accountTypeDescription) : that.accountTypeDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) accountTypeKey;
        result = 31 * result + (accountTypeDescription != null ? accountTypeDescription.hashCode() : 0);
        return result;
    }
}
