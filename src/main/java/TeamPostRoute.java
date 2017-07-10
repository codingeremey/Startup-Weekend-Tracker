import spark.Request;
import spark.Response;

public class TeamPostRoute extends AppRoute {
    public TeamPostRoute() {
        super("templates/team-post.vtl", "templates/layout.vtl");
    }
    @Override
    protected void createModel(Request request, Response response) {
        String name = request.queryParams("name");
        String description = request.queryParams("description");
        Database database = new InMemoryDatabase();
        Team team = database.createTeam(name, description);
        model.put("team", team);
    }
}
