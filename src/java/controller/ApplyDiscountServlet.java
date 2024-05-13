package controller;

import entity.Cart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.OrderRepository;

import java.io.IOException;

@WebServlet(name = "ApplyDiscountServlet", value = "/applydiscount")
public class ApplyDiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String discountID= request.getParameter("discountID");
        double discountPercent = OrderRepository.getDiscountPercent(discountID);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart.getDiscountCode() == null) {
            cart.setDiscountCode(discountID);
            cart.setDiscountPercent(discountPercent);
            String message = "Áp dụng thành công";
            request.setAttribute("message",message);
            request.setAttribute("discountPercent",discountPercent);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        } else {
            String message = "Một đơn hàng chỉ được sử dụng 1 mã giảm giá";
            request.setAttribute("message",message);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
