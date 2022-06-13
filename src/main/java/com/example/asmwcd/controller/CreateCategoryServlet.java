package com.example.asmwcd.controller;

import com.example.asmwcd.entity.Category;
import com.example.asmwcd.model.CategoryModel;
import com.example.asmwcd.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    public CreateCategoryServlet() {
        this.categoryModel = (CategoryModel) new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = this.categoryModel.findAll();
        req.setAttribute("categories",categories);
        req.setAttribute("action",1);
        req.getRequestDispatcher("/admin/categori/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");

            Category category = Category.CategoryBuilder.aCategory()
                    .withName(name)
                    .build();
            if (category.isValid()) {
                boolean result = categoryModel.save(category);
                if (result) {
                    resp.sendRedirect("/admin/categori/list");
                }
            } else {
                req.setAttribute("action", 1);
                req.setAttribute("categories", categoryModel.findAll());
                req.setAttribute("category", category);
                req.getRequestDispatcher("/admin/categories/form.jsp").forward(req, resp);
            }
        } finally {

        }
    }
}
