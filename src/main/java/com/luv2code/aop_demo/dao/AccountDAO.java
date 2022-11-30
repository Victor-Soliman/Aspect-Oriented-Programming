package com.luv2code.aop_demo.dao;

import com.luv2code.aop_demo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK : ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return false;
    }


}
