package com.taxi.infrastructure.services;

import org.springframework.data.domain.Example;

import java.util.List;

public interface BaseService<T> {
    //Insert
    T create(T model);
    //Insert array
    List<T> create(Iterable<T> models);
    //Update
    T update(T modelFromDb, T model);
    //Delete by model
    void delete(T model);
    //Delete by array models
    void delete(Iterable<T> models);
    //Delete by ID
    void delete(Integer Id);
    //Select all
    List<T> read(Example<T> example);
    //Select by ID
    T read(Integer Id) throws Exception;
}
