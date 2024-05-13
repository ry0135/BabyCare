package controller;

import entity.OrderAccept;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListOrderPaidServlet", value = "/order-list-paid")
public class ListOrderPaidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<OrderAccept> listOrder = OrderRepository.getAllOrderPaid();
        request.setAttribute("listOrder",listOrder);
        request.getRequestDispatcher("order-list-paid.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
