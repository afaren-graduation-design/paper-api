package com.thoughtworks.twars.mapper;

import com.thoughtworks.twars.util.DatabaseUtil;
import com.thoughtworks.twars.util.EnvUtil;
import org.apache.ibatis.session.SqlSessionManager;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;

import javax.sql.DataSource;

public class TestBase {

    protected  SqlSessionManager session;

    Flyway flyway = new Flyway();

    {
        String env =  EnvUtil.getVariable("ci_test") != null ? "ci_test" : "test";
        session = DatabaseUtil.getSession(env);
        DataSource ds = session.getConfiguration().getEnvironment().getDataSource();
        flyway.setDataSource(ds);
    }


    @Before
    public void setUp() throws Exception {
        session.startManagedSession();
        flyway.clean();
        flyway.migrate();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
}
