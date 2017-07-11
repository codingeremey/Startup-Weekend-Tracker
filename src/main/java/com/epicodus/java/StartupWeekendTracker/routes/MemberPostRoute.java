package com.epicodus.java.StartupWeekendTracker.routes;

import com.epicodus.java.StartupWeekendTracker.data.Database;
import com.epicodus.java.StartupWeekendTracker.models.*;
import spark.Request;
import spark.Response;

public class MemberPostRoute extends AppRoute {
    public MemberPostRoute(Database database) {
        super("templates/member-post.vtl", "templates/layout.vtl", database);
    }
    @Override
    protected void createModel(Request request, Response response) {
        Team team = mDatabase.getTeam(Integer.parseInt(request.queryParams("teamId")));

        String firstName = request.queryParams("firstName");
        String lastName = request.queryParams("lastName");
        String role = request.queryParams("role");

        Member member = mDatabase.createMember(firstName,lastName, role);

        team.addMember(member);

        mModel.put("member", member);
        mModel.put("team", team);
    }
}
