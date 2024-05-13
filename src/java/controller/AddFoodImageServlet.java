package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "AddFoodImageServlet", value = "/food-add-image")
public class AddFoodImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("food-image-manager").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID= request.getParameter("productId");
        String url=request.getParameter("urlImage");
        ProductRepository.addFoodImage(foodID,url);
        request.setAttribute("productId",foodID);
        System.out.println("ok");
        response.sendRedirect("food-image-manager?productId="+foodID);
//        request.getRequestDispatcher("food-image-manager?productId="+foodID).forward(request,response);
    }
}
