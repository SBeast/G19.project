package tests;

import libs.DataBaseData;
import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class WorKWithDB {

    Logger logger = Logger.getLogger(getClass());
    Database db;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        db = new Database("MySQL_PADB_DB", "MySQL");
    }

    @Test
    public void testWithDb() throws SQLException, IOException, ClassNotFoundException {
        List<Map<String, String>> testData = db.selectTable("select * from table_selenium where login = 'login3'");
        logger.info("values = " + testData.get(1));
//        db.changeDataInDataBase("insert into table_selenium values (105,'KatyaKaLogin', '1212121212')");
        logger.info(DataBaseData.getPassForLogin("KatyaKaLogin"));
    }

    @After
    public void tearDown() throws SQLException {
        db.quit();
    }
}

