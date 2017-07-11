package com.epicodus.java.StartupWeekendTracker.routes;

import com.epicodus.java.StartupWeekendTracker.data.Database;
import spark.Request;
import spark.Response;

public class IndexRoute extends AppRoute {

    public IndexRoute(Database database) {
        super("templates/index.vtl", "templates/layout.vtl", database);
    }

    protected void createModel(Request request, Response response) {
        mModel.put("teams", mDatabase.getTeams());
    }
}