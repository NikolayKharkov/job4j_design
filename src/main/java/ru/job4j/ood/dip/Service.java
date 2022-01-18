package ru.job4j.ood.dip;

import java.sql.Connection;

public class Service {
    private Connection dbConnection;

    public void getDbConnect(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
/*
Нарушение принципа DIP, т.к будет зависимость от конкретной реализации подключения к БД.
 */
