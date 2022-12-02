package com.luv2code.aop_zzz_around_handle_exception.dao;

import com.luv2code.aop_zzz_around_handle_exception.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new method : findAccounts()

    public List<Account> findAccounts(boolean tripWire) {

        // for academic purpose ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts

        Account temp1 = new Account("Jhon", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }


    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK : ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " : inGetName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : inSetName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : inGetServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : inSetServiceCode()");
        this.serviceCode = serviceCode;
    }
}
