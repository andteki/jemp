package controllers;

import models.MainModel;
import views.MainFrame;

public class MainController {

    MainFrame mainFrame;
    MainModel mainModel;

    public MainController() {
        mainFrame = new MainFrame();
        mainModel = new MainModel();
        setEvents();
        mainFrame.employeeTable.setModel(mainModel.employeeModel);
    }

    public void setEvents() {
        this.mainFrame.goButton.addActionListener(e -> {
            onClickGoButton();
        });
    }

    public void onClickGoButton() {
        this.mainFrame.setTitle("Működik");
    }
    
}
