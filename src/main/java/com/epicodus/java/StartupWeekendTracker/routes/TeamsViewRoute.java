package com.epicodus.java.StartupWeekendTracker.routes;

import com.epicodus.java.StartupWeekendTracker.data.Database;
import spark.Request;
import spark.Response;

public class TeamsViewRoute extends AppRoute {
    public TeamsViewRoute(Database database) {
        super("templates/teams-view.vtl", "templates/layout.vtl", database);
    }

    @Override
    protected void createModel(Request request, Response response) {
        mModel.put("teams", mDatabase.getTeams());
    }
}
