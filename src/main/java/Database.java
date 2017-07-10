import java.util.List;

public interface Database {
    List<Member> getMembers();
    Member getMember(int id);
    Member createMember(String firstName, String lastName, String role);

    List<Team> getTeams();
    Team getTeam(int id);
    Team createTeam(String name, String description);
}
