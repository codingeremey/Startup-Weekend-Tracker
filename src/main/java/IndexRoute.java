import spark.Request;
import spark.Response;

public class IndexRoute extends AppRoute {

    public IndexRoute() {
        super("templates/index.vtl", "templates/layout.vtl");
    }

    protected void createModel(Request request, Response response) {
        Database database = new InMemoryDatabase();
        model.put("teams", database.getTeams());
    }
}