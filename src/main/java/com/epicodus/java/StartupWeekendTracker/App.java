package com.epicodus.java.StartupWeekendTracker;

import com.epicodus.java.StartupWeekendTracker.data.InMemoryDatabase;
import com.epicodus.java.StartupWeekendTracker.routes.*;
import spark.template.velocity.VelocityTemplateEngine;
import spark.Spark;

public class App {
    public static void main(String[] args){
        ProcessBuilder process = new ProcessBuilder();
        if (process.environment().get("PORT") != null) {
            Spark.port(Integer.parseInt(process.environment().get("PORT")));
        } else {
            Spark.port(4567);
        }

        //spark.Spark.staticFileLocation("/public");

        Spark.get("/", new IndexRoute(new InMemoryDatabase()), new VelocityTemplateEngine());
        Spark.get("/teams/new", new TeamAddRoute(), new VelocityTemplateEngine());
        Spark.get("/teams/:id/members/new", new MemberAddRoute(new InMemoryDatabase()), new VelocityTemplateEngine());
        Spark.get("/teams/:id", new TeamViewRoute(new InMemoryDatabase()), new VelocityTemplateEngine());
        Spark.get("/teams", new TeamsViewRoute(new InMemoryDatabase()), new VelocityTemplateEngine());

        Spark.post("/teams", new TeamPostRoute(new InMemoryDatabase()), new VelocityTemplateEngine());
        Spark.post("/members", new MemberPostRoute(new InMemoryDatabase()), new VelocityTemplateEngine());
    }
}