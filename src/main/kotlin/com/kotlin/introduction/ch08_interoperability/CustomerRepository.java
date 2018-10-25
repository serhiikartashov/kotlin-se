package com.kotlin.introduction.ch08_interoperability;

import com.kotlin.introduction.ch03_classes.CustomerJava;

import java.util.List;

public interface CustomerRepository {

    CustomerJava getById(int id);
    List<CustomerJava> getAll();
}
