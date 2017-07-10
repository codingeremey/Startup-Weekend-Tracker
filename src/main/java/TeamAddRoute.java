import spark.Request;
import spark.Response;

public class TeamAddRoute extends AppRoute {
    public TeamAddRoute() {
        super("templates/team-add.vtl", "templates/layout.vtl");
    }
    @Override
    protected void createModel(Request request, Response response) {
    }
}
