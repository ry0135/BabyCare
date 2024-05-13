package controller;

import entity.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("Lay thong tin cua" + user);
        String firstname = user.getFirstname(), lastname = user.getLastname(), address = user.getAddress(), phone = user.getPhone();
        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("address", address);
        request.setAttribute("phone", phone);
        if(request.getParameter("thongbao2")!=null){

            if(request.getParameter("thongbao2").equals("1"))
                request.setAttribute("thongbao2","Cập nhật mật khẩu thành công");
            else
                request.setAttribute("thongbao2","Mật khẩu cũ không đúng vui lòng nhập lại");
        }
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
