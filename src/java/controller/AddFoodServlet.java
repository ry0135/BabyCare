package controller;

import entity.Food;
import entity.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.ProductRepository;
import service.MyRandom;

import java.io.IOException;
import java.util.ArrayList;
/*
CHUA PHAT TRIEN :D
 */
@WebServlet(name = "AddFoodServlet", value = "/addfood")
public class AddFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID= MyRandom.getRandomFoodID();
        String foodName=request.getParameter("foodName");
        double foodPrice=0 ;
        if(!request.getParameter("foodPrice").isEmpty()) foodPrice=Double.parseDouble( request.getParameter("foodPrice"))  ;
        String foodType=request.getParameter("foodType");
        String foodUrlImg=request.getParameter("foodUrlImg");
        String foodOrigin=request.getParameter("foodOrigin");
        System.out.println("Them " +foodID +" "+ foodName+" "+ foodPrice+" "+ foodType+" "+foodUrlImg +foodOrigin );
        ArrayList<Image> listImg=new ArrayList<Image>();
        listImg.add(new Image(foodID,foodUrlImg));
        Food food=new Food(foodID,foodName,foodType,foodOrigin,foodPrice,1,listImg,1);
        ProductRepository.addFood(food);
        request.setAttribute("thongbao","Thêm thành công");
        request.getRequestDispatcher("food-add.jsp").forward(request,response);
    }
}
