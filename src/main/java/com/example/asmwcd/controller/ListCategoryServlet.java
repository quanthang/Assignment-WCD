package com.example.asmwcd.controller;

import com.example.asmwcd.model.CategoryModel;
import com.example.asmwcd.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    public ListCategoryServlet() {
        this.categoryModel = (CategoryModel) new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categori", categoryModel.findAll());
        req.getRequestDispatcher("/admin/categori/list.jsp").forward(req, resp);
    }
}
