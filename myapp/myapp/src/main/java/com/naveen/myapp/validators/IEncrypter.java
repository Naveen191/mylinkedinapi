package com.naveen.myapp.validators;

import org.springframework.stereotype.Component;

//@Component
public interface IEncrypter {
    public String encrypt(String field) throws Exception;

    public String decrypt(String field) throws Exception;
}
