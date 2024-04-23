package com.example.addressbook.tammy2.TammyDatabase;

import com.example.addressbook.tammy2.TammyDatabase.TammyDatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = TammyDatabaseConnection.getInstance();
        TammyDAO tammydao = new TammyDAO();
        tammydao.createTable();
    }
}
