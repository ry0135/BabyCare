package controller;

import entity.Cart;
import entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.OrderRepository;

import java.io.IOException;

@WebServlet(name = "makeOrderServlet", value = "/makeoder")
public class MakeOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.getCart().size()==0) response.sendRedirect("cart.jsp");
        else{
            String orderId = OrderRepository.createOrder(cart,user);
            cart.setDiscountCode(null);
            cart.removeAll();
            request.getRequestDispatcher("getordereddetail?orderId="+orderId).forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
