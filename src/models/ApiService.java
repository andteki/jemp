package models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiService {

    String host = "http://localhost:3000/";

    public ApiService() {
    }
    private String getEmployeesText() {
        String res = null;
        try {
            res = tryGetEmployeesText();
        } catch (MalformedURLException e) {
            System.err.println("Hiba! Az url hibás! ");
        } catch(IOException e) {
            System.err.println("Hiba! A lekérés sikertelen! ");
        }
        return res;
    }
    private String tryGetEmployeesText() 
    throws MalformedURLException, IOException{
        String endpoint = "employees";
        URL url = new URL(this.host + endpoint);
        HttpURLConnection http = 
            (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();
        String res = null;

        int responseCode = http.getResponseCode();
        if(responseCode == 200) {
            res = new String(
                http.getInputStream()
                .readAllBytes(),
                StandardCharsets.UTF_8
            );
        }else {
            throw new RuntimeException("Http válasz" +
            responseCode);
        }
        return res;
    }

    public Employee[] getEmployeeArray() {
        String res = this.getEmployeesText();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Employee[] employeeArray =  gson.fromJson(res, Employee[].class);
        return employeeArray;
    }

    public Vector<Vector<String>> getEmployees() {
        Vector<Vector<String>> tableModel = new Vector<>();
        for(Employee employee : this.getEmployeeArray()) {
            Vector<String> row = new Vector<>();
            row.add(employee.id.toString());
            row.add(employee.name);
            row.add(employee.city);
            row.add(employee.salary.toString());
            tableModel.add(row);
        }
        return tableModel;      
    }    

}
