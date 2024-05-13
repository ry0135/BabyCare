package controller;

import entity.Image;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FoodImageServlet", value = "/food-image-manager")
public class FoodImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID=request.getParameter("productId");
        ArrayList<Image> listImage= ProductRepository.getListFoodImage(foodID);
        request.setAttribute("productId",foodID);
        request.setAttribute("listImage",listImage);
        request.getRequestDispatcher("food-list-image.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
