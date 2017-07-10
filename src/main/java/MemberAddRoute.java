import spark.Request;
import spark.Response;

public class MemberAddRoute extends AppRoute {
    public MemberAddRoute() {
        super("templates/member-add.vtl", "templates/layout.vtl");
    }

    @Override
    protected void createModel(Request request, Response response) {
        Database database = new InMemoryDatabase();
        Team team = database.getTeam(Integer.parseInt(request.params(":id")));
        model.put("team", team);
    }
}
