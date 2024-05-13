package controller;

import entity.Preferential;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListDiscountServlet", value = "/listdiscount")
public class ListDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Preferential> listP= OrderRepository.getListDiscount();
        request.setAttribute("listP",listP);
        request.getRequestDispatcher("listdiscount.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
