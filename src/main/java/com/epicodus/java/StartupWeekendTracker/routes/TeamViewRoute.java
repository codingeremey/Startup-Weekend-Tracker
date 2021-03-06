package com.epicodus.java.StartupWeekendTracker.routes;

import com.epicodus.java.StartupWeekendTracker.data.Database;
import spark.Request;
import spark.Response;

public class TeamViewRoute extends AppRoute {
    public TeamViewRoute(Database database) {
        super("templates/team-view.vtl", "templates/layout.vtl", database);
    }

    @Override
    protected void createModel(Request request, Response response) {
        mModel.put("team", mDatabase.getTeam(Integer.parseInt(request.params(":id"))));
    }
}
