package controller;

import entity.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import repository.OrderRepository;

import java.io.IOException;

@WebServlet(name = "PaidOrderServlet", value = "/paidorder")
public class PaidOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        OrderRepository.paidOrder(id,user.getUserId());

        request.getRequestDispatcher("list-order-accepted").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
