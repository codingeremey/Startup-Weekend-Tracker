import spark.Request;
import spark.Response;

public class MemberPostRoute extends AppRoute {
    public MemberPostRoute() {
        super("templates/member-post.vtl", "templates/layout.vtl");
    }
    @Override
    protected void createModel(Request request, Response response) {
        Database database = new InMemoryDatabase();

        Team team = database.getTeam(Integer.parseInt(request.queryParams("teamId")));

        String firstName = request.queryParams("firstName");
        String lastName = request.queryParams("lastName");
        String role = request.queryParams("role");

        Member member = database.createMember(firstName,lastName, role);

        team.addMember(member);

        model.put("member", member);
        model.put("team", team);
    }
}
