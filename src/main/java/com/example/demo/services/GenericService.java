package com.example.demo.services;
import java.util.List;

public interface GenericService<T, ID> {
    public List<T> Get();
    public T Get(ID id);
    public Boolean Save(T model);
    public Boolean Delete(ID id);
}
