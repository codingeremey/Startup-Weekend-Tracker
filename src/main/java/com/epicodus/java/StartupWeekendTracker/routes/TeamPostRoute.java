package com.epicodus.java.StartupWeekendTracker.routes;

import com.epicodus.java.StartupWeekendTracker.data.Database;
import spark.Request;
import spark.Response;

public class TeamPostRoute extends AppRoute {
    public TeamPostRoute(Database database) {
        super("templates/team-post.vtl", "templates/layout.vtl", database);
    }
    @Override
    protected void createModel(Request request, Response response) {
        String name = request.queryParams("name");
        String description = request.queryParams("description");
        mModel.put("team", mDatabase.createTeam(name, description));
    }
}
