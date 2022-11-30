package com.luv2code.aop_pointcut_declaration_combo.dao;

import com.luv2code.aop_pointcut_declaration_combo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
