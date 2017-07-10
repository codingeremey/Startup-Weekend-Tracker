import spark.Request;
import spark.Response;

public class TeamViewRoute extends AppRoute {
    public TeamViewRoute() {
        super("templates/team-view.vtl", "templates/layout.vtl");
    }

    @Override
    protected void createModel(Request request, Response response) {
        Database database = new InMemoryDatabase();
        Team team = database.getTeam(Integer.parseInt(request.params(":id")));
        model.put("team", team);
    }
}
