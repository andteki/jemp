package models;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MainModel {

    public DefaultTableModel employeeModel;
    public ApiService api;

    public MainModel() {
        api = new ApiService();
        Vector<Vector<String>> tableModel = api.getEmployees();
        Vector<String> tableHead = new Vector<>();
        tableHead.add("Id");
        tableHead.add("Név");
        tableHead.add("Település");
        tableHead.add("Fizetés");
        this.employeeModel = new DefaultTableModel(tableModel, tableHead);   
    }


    
}
