package com.example.asmwcd.model;

import com.example.asmwcd.entity.myenum.Dish;

import java.util.List;

public interface DishModel {
    boolean save(Dish obj);
    boolean update(int id, Dish updateObj);
    boolean delete(int id);
    List<Dish> findAll();
    Dish findById(int id);
    Dish findByDishName(String name);
}