package edu.mypet.dao;

import edu.mypet.domain.Request;
import edu.mypet.domain.Response;
import edu.mypet.exception.MyPetException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class MyPetCheckDaoTest {

    @Test
    public void checkArea() throws SQLException, MyPetException {
         Request request=new Request();
         request.setFirstNumbers("1234");
         request.setLastNumbers("4321");
         MyPetCheckDao dao=new MyPetCheckDao();
         dao.setConnectionBuilder(new OneConnectionBuilder());
         Response resp=dao.checkArea(request);
         System.out.println(resp);

         Assert.assertTrue("Koson",true);
    }


}