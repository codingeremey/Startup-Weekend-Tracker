import spark.Request;
import spark.Response;

public class TeamsViewRoute extends AppRoute {
    public TeamsViewRoute() {
        super("templates/teams-view.vtl", "templates/layout.vtl");
    }

    @Override
    protected void createModel(Request request, Response response) {
        Database database = new InMemoryDatabase();
        model.put("teams", database.getTeams());
    }
}
