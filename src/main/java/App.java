import spark.template.velocity.VelocityTemplateEngine;
import spark.Spark;

public class App {
    public static void main(String[] args){
        ProcessBuilder process = new ProcessBuilder();
        if (process.environment().get("PORT") != null) {
            port(Integer.parseInt(process.environment().get("PORT")));
        } else {
            port(4567);
        }

        //spark.Spark.staticFileLocation("/public");

        Spark.get("/", new IndexRoute(), new VelocityTemplateEngine());
        Spark.get("/teams/new", new TeamAddRoute(), new VelocityTemplateEngine());
        Spark.get("/teams/:id/members/new", new MemberAddRoute(), new VelocityTemplateEngine());
        Spark.get("/teams/:id", new TeamViewRoute(), new VelocityTemplateEngine());
        Spark.get("/teams", new TeamsViewRoute(), new VelocityTemplateEngine());

        Spark.post("/teams", new TeamPostRoute(), new VelocityTemplateEngine());
        Spark.post("/members", new MemberPostRoute(), new VelocityTemplateEngine());
    }
}