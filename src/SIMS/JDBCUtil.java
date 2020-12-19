package SIMS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class JDBCUtil {

    Connection conn = null;

    public Connection getConn() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/StudentManager?useUnicode=true&characterEncoding=utf8";
        String usrName = "root";
        String passwd = "fahaxiki";
        try {
            conn = DriverManager.getConnection(url, usrName, passwd);
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return conn;
    }

    public List<userData> getAllInfo() {
        conn = getConn();
        ResultSet rest;
        List<userData> list = new ArrayList<userData>();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM student";
            rest = statement.executeQuery(sql);
            while(rest.next()){
                userData user = new userData();
                user.setId(rest.getString(1));
                user.setName(rest.getString(2));
                user.setSex(rest.getString(3));
                user.setAge(rest.getInt(4));
                user.setQq(rest.getString(5));
                user.setPhone(rest.getString(6));
                user.setMail(rest.getString(7));
                list.add(user);
            }
            rest.close();
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Query Successful!");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    public List<userData> getPartInfo(String id, String name, String sex, String age, String qq, String phone, String mail) {
        conn = getConn();
        ResultSet rest;
        List<userData> list = new ArrayList<userData>();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM student WHERE 1=1";
            if(!id.equals("")){
                sql = sql + " AND ID='" + id + "'";
            }
            if(!name.equals("")){
                sql = sql + " AND NAME='" + name + "'";
            }
            if(!sex.equals("")){
                sql = sql + " AND SEX='" + sex + "'";
            }
            if(!age.equals("")){
                sql = sql + " AND AGE=" + age + "";
            }
            if(!qq.equals("")){
                sql = sql + " AND QQ='" + qq + "'";
            }
            if(!phone.equals("")){
                sql = sql + " AND PHONE='" + phone + "'";
            }
            if(!mail.equals("")){
                sql = sql + " AND MAIL='" + mail + "'";
            }
            rest = statement.executeQuery(sql);
            while(rest.next()){
                userData user = new userData();
                user.setId(rest.getString(1));
                user.setName(rest.getString(2));
                user.setSex(rest.getString(3));
                user.setAge(rest.getInt(4));
                user.setQq(rest.getString(5));
                user.setPhone(rest.getString(6));
                user.setMail(rest.getString(7));
                list.add(user);
            }
            rest.close();
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Query Successfully!");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    public List<userData> insertInfo(String id, String name, String sex, String age, String qq, String phone, String mail) {
        conn = getConn();
        ResultSet rest;
        List<userData> list = new ArrayList<userData>();
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO student values(";
            if(!id.equals("")){
                sql = sql + "'" + id + "',";
            }else {
                sql = sql + "'',";
            }
            if(!name.equals("")){
                sql = sql + "'" + name + "',";
            }else {
                sql = sql + "'',";
            }
            if(!sex.equals("")){
                sql = sql + "'" + sex + "',";
            }else {
                sql = sql + "'',";
            }
            if(!age.equals("")){
                sql = sql + age + ",";
            }else{
                sql = sql + "null,";
            }
            if(!qq.equals("")){
                sql = sql + "'" + qq + "',";
            }else {
                sql = sql + "'',";
            }
            if(!phone.equals("")){
                sql = sql + "'" + phone + "',";
            }else {
                sql = sql + "'',";
            }
            if(!mail.equals("")){
                sql = sql + "'" + mail + "'";
            }else {
                sql = sql + "''";
            }
            sql = sql + ")";
            rest = statement.executeQuery(sql);
            while(rest.next()){
                userData user = new userData();
                user.setId(rest.getString(1));
                user.setName(rest.getString(2));
                user.setSex(rest.getString(3));
                user.setAge(rest.getInt(4));
                user.setQq(rest.getString(5));
                user.setPhone(rest.getString(6));
                user.setMail(rest.getString(7));
                list.add(user);
            }
            rest.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    // no
    public List<userData> updateInfo(String id, String name, String sex, String age, String qq, String phone, String mail) {
        conn = getConn();
        ResultSet rest;
        List<userData> list = new ArrayList<userData>();
        try {
            Statement statement = conn.createStatement();
            String sqlmain = "UPDATE student set";
            String sql = "";
            if(!name.equals("")){
                sql = sql + " NAME='" + name + "'";
            }
            if(!sex.equals("")){
                if(sql.equals("")){
                    sql = sql + " SEX='" + sex + "'";
                }else {
                    sql = sql + " , SEX='" + sex + "'";
                }
            }
            if(!age.equals("")){
                if(sql.equals("")){
                    sql = sql + " AGE=" + age + "";
                }else {
                    sql = sql + " , AGE=" + age + "";
                }
            }
            if(!qq.equals("")){
                if(sql.equals("")){
                    sql = sql + " QQ='" + qq + "'";
                }else {
                    sql = sql + " , QQ='" + qq + "'";
                }
            }
            if(!phone.equals("")){
                if(sql.equals("")){
                    sql = sql + " PHONE='" + phone + "'";
                }else {
                    sql = sql + " , PHONE='" + phone + "'";
                }
            }
            if(!mail.equals("")){
                if(sql.equals("")){
                    sql = sql + " MAIL='" + mail + "'";
                }else {
                    sql = sql + " , MAIL='" + mail + "'";
                }
            }
            sqlmain = sqlmain + sql + " WHERE ID='" + id + "'";
            System.out.println(sqlmain);
            rest = statement.executeQuery(sqlmain);
            while(rest.next()){
                userData user = new userData();
                user.setId(rest.getString(1));
                user.setName(rest.getString(2));
                user.setSex(rest.getString(3));
                user.setAge(rest.getInt(4));
                user.setQq(rest.getString(5));
                user.setPhone(rest.getString(6));
                user.setMail(rest.getString(7));
                list.add(user);
            }
            rest.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    public List<userData> deleteInfo(String id, String name, String sex, String age, String qq, String phone, String mail) {
        conn = getConn();
        ResultSet rest;
        List<userData> list = new ArrayList<userData>();
        try {
            Statement statement = conn.createStatement();
            String sql = "DELETE FROM student WHERE 1=1";
            if(!id.equals("")){
                sql = sql + " AND ID='" + id + "'";
            }
            if(!name.equals("")){
                sql = sql + " AND NAME='" + name + "'";
            }
            if(!sex.equals("")){
                sql = sql + " AND SEX='" + sex + "'";
            }
            if(!age.equals("")){
                sql = sql + " AND AGE=" + age + "";
            }
            if(!qq.equals("")){
                sql = sql + " AND QQ='" + qq + "'";
            }
            if(!phone.equals("")){
                sql = sql + " AND PHONE='" + phone + "'";
            }
            if(!mail.equals("")){
                sql = sql + " AND MAIL='" + mail + "'";
            }
            rest = statement.executeQuery(sql);
            while(rest.next()){
                userData user = new userData();
                user.setId(rest.getString(1));
                user.setName(rest.getString(2));
                user.setSex(rest.getString(3));
                user.setAge(rest.getInt(4));
                user.setQq(rest.getString(5));
                user.setPhone(rest.getString(6));
                user.setMail(rest.getString(7));
                list.add(user);
            }
            rest.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }
    // public static void main(String[] args) {
    //     JDBCUtil util = new JDBCUtil();
    //     util.getConn();
    // }
}
