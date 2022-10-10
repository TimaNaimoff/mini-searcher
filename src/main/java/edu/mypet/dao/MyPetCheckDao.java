package edu.mypet.dao;

import edu.mypet.domain.Request;
import edu.mypet.domain.Response;
import edu.mypet.exception.MyPetException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyPetCheckDao {
    private String sql;
    private static final String SELECT_1="SELECT *FROM areas WHERE area_code=?";
    private static final String SELECT_2="SELECT *FROM districts WHERE district_code=?";
    private static final String SELECT_3="select *from areas,districts where area_code=? and district_code=?";

    ConnectionBuilder connectionBuilder;
    public MyPetCheckDao(){
        try {
            Class.forName("org.postgresql.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    public void setConnectionBuilder(ConnectionBuilder connectionBuilder){
        this.connectionBuilder=connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }
    public Response checkArea(Request request) throws SQLException, MyPetException {
         Response response=new Response();
         sql=SELECT_1;
         if(request.getFirstNumbers().length()<5)
         checkNumberForFirst(request,response);
//         if(request.getLastNumbers()==null&&request.getFirstNumbers().length()<6){
//
//         }
//         if(request.getFirstNumbers()==null&&request.getLastNumbers().length()<6){
//             sql=SELECT_2;
//             checkNumberForLast(request,response);
//         }
//         else{
//             sql=SELECT_3;
//             checkNumberForALL(request,response);
//         }

         return response;
    }
    public void checkNumberForFirst(Request request,Response response){
        try(Connection con=getConnection();
            PreparedStatement pr=con.prepareStatement(sql)
        ) {

            pr.setString(1, request.getFirstNumbers());
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                response.setArea_name(rs.getString("area_name"));
                if(request.getLastNumbers().length()<10) {
                    checkNumberForLast(request, response);
                }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void checkNumberForLast(Request request,Response response) throws SQLException {
        try(Connection con=getConnection();
            PreparedStatement pr=con.prepareStatement(SELECT_2)){
            pr.setString(1,request.getLastNumbers().substring(0,2));
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                response.setDistrict_name(rs.getString("district_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void checkNumberForALL(Request request,Response response){
        try(Connection con=getConnection();
            PreparedStatement pr=con.prepareStatement(sql)){
            pr.setString(1,request.getFirstNumbers());
            pr.setString(2,request.getLastNumbers());
            ResultSet rs=pr.executeQuery();
            if(rs.next()){
                response.setArea_name(rs.getString("area_name"));
                response.setDistrict_name(rs.getString("district_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
//    public void checkNumberForAll(Request request,Response response){
//
//    }
}
