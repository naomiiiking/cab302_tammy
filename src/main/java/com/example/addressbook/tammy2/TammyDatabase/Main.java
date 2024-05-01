package com.example.addressbook.tammy2.TammyDatabase;

import com.example.addressbook.tammy2.tammy.Tammys;

public class Main {
    public static void main(String[] args) {
        TammyDAO tammyDAO = new TammyDAO();
        //tammydao.createTammyTable();
        Tammys tammy = new Tammys(1,"CaneJR","Study","Fish");
        tammyDAO.addTammy(tammy);
        tammyDAO.close();
    }
}
