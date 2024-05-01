package com.example.addressbook.tammy2.TammyDatabase;

import tammy.Tammys;
public interface ITammyDAO {

    public void addTammy(Tammys tammys);

    public void updateTammy(Tammys tammys);

    public void getTammy(int id);

    public void createTable();
}
