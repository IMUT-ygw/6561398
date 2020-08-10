package com.imut.redis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/25 10:32
 */
@WebServlet("/kill")
public class KillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prodId = request.getParameter("prodId");
        String userId = new Random().nextInt(5000)+"";
        KillUtils k = new KillUtils();
        boolean result = k.result(prodId, userId);
        response.getWriter().print(result);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
