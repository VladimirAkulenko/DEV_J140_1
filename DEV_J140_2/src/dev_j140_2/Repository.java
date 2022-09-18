/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_2;

import java.util.List;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Repository implements RepositoryInterface{

    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM users")){
            while(rs.next()){
                int id = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                User user = new User(id, userName, password);
                list.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person")){
            while(rs.next()){
                Integer id = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String firstnamelastname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(id, jobtitle, firstnamelastname, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Person getPersonById(int id) {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person WHERE id=" + id)){
            while(rs.next()){
                int personid = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String firstnamelastname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(personid, jobtitle, firstnamelastname, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Domain> getDomains() {
        List<Domain> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM domains")){
            while(rs.next()){
                int id = rs.getInt(1);
                String webname = rs.getString(2);
                String domainname = rs.getString(3);
                String ip = rs.getString(4);
                Timestamp datereg = rs.getTimestamp(5);
                String countryreg = rs.getString(6);
                
                Person person = getPersonById(id);
                Domain domain = new Domain(id, webname, domainname, ip, datereg, countryreg, person);
                list.add(domain);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Domain> getDomainByPerson(Person person) {
        List<Domain> list = new ArrayList<>();
        if(person!=null){
            try(Connection connection = getConnection();
                    Statement stm = connection.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM domains WHERE personid=" + person.getId())){
                while(rs.next()){
                    int id = rs.getInt(1);
                    String webname = rs.getString(2);
                    String domainname = rs.getString(3);
                    String ip = rs.getString(4);
                    Timestamp datereg = rs.getTimestamp(5);
                    String countryreg = rs.getString(6);
                    Domain domain = new Domain(id, webname, domainname, ip, datereg, countryreg, person);
                    list.add(domain);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    private Connection getConnection() throws SQLException {
        String url = ApplicationProperties.get().getProperty("db.url");
        String dbUser = ApplicationProperties.get().getProperty("db.user");
        String dbPassword = ApplicationProperties.get().getProperty("db.password");
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
}
