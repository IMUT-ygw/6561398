package com.imut.servlet;

import com.imut.domain.Student;
import com.imut.server.SelectInfo;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/18 8:53
 */

@WebServlet(name = "ProductServlet", urlPatterns = "/findAll")
public class SelectServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        SelectInfo selectInfo = new SelectInfo();
        List<Student> all = selectInfo.findAll();
        System.out.println(all);

        request.setAttribute("findAll",all);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
