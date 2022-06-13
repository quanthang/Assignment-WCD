package com.example.asmwcd.model;


import com.example.asmwcd.entity.Category;

import java.util.List;
public interface CategoryModel {
    boolean save(Category obj);
    boolean update(int id, Category updateObj);
    boolean delete(int id);
    List<Category> findAll();
    Category findById(int id);
}
