package controller;

import entity.Food;
import entity.Pet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.ProductRepository;
import service.ProductService;

import java.io.IOException;
import java.util.ArrayList;

/*
CHUA PHAT TRIEN :D
 */
@WebServlet(name = "productShowServlet", value = "/product")
public class ProductShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        ArrayList<Pet> listPet = ProductRepository.getListPetAva();
        ArrayList<Food> listFood = ProductRepository.getListFood();
        ArrayList<Pet> subListPet = new ArrayList<Pet>();
        ArrayList<Food> subListFood = new  ArrayList<Food>();
        for(int i=0;i<4;i++){
            subListFood.add(listFood.get(i));
            subListPet.add(listPet.get(i));
        }
//        for (Object a: listFood) {
//            System.out.println(a.toString());
//        }
//        for (Object a: listPet) {
//            System.out.println(a.toString());
//        }


        request.setAttribute("listPet", subListPet);
        request.setAttribute("listFood", subListFood);

        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
