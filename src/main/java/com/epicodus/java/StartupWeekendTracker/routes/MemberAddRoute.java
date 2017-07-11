package com.epicodus.java.StartupWeekendTracker.routes;

import com.epicodus.java.StartupWeekendTracker.data.Database;
import spark.Request;
import spark.Response;

public class MemberAddRoute extends AppRoute {
    public MemberAddRoute(Database database) {
        super("templates/member-add.vtl", "templates/layout.vtl", database);
    }

    @Override
    protected void createModel(Request request, Response response) {
        mModel.put("team", mDatabase.getTeam(Integer.parseInt(request.params(":id"))));
    }
}
