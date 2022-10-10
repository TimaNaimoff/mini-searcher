package edu.mypet.web;

import edu.mypet.dao.MyPetCheckDao;
import edu.mypet.dao.OneConnectionBuilder;
import edu.mypet.domain.Request;
import edu.mypet.domain.Response;
import edu.mypet.exception.MyPetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="MyPetServlet",urlPatterns = "/myPet")
public class MyPetServlet extends HttpServlet {
    MyPetCheckDao dao;
    private static final Logger logger= LoggerFactory.getLogger(MyPetServlet.class);


    @Override
    public void init() throws ServletException {
        logger.info("SERVLET IS CREATED");
        dao=new MyPetCheckDao();
        dao.setConnectionBuilder(new OneConnectionBuilder());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           resp.getWriter().println("Servlet is called");

           req.setCharacterEncoding("UTF-8");
           Request request=new Request();
               request.setFirstNumbers(req.getParameter("firstNumb"));
               request.setLastNumbers(req.getParameter("secondNumb"));
           try{
               Response response=dao.checkArea(request);
               if(response.getArea_name()!=null){

                   resp.getWriter().write("Area: "+response.getArea_name()+" ");
               }
              if(response.getDistrict_name()!=null){

                   resp.getWriter().write("District: "+response.getDistrict_name());
               }
           } catch (SQLException | MyPetException e) {
               e.printStackTrace();
           }

    }
}
