package controller;

import entity.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "getPetDetailServlet", value = "/getpetdetail")
public class GetPetDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            System.out.println("null");
        } else {
            Product p = ProductRepository.getPet(id);
            System.out.println(p);
            request.setAttribute("product", p);
            request.getRequestDispatcher("product-detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
