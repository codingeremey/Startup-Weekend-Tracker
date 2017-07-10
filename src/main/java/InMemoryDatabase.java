import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database {
    private static ArrayList<Member> mMemberList = new ArrayList<>();
    private static ArrayList<Team> mTeamList = new ArrayList<>();

    public InMemoryDatabase() {
        if (mMemberList.isEmpty() && mTeamList.isEmpty()) {
            fillTestData();
        }
    }

    public List<Member> getMembers() {
        return mMemberList;
    }

    public Member getMember(int id) {
        return mMemberList.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public Member createMember(String firstName, String lastName, String role) {
        int id = mMemberList.stream().mapToInt(m -> m.getId()).max().orElse(0) + 1;
        Member member = new Member(id, firstName, lastName, role);
        mMemberList.add(member);
        return member;
    }

    public List<Team> getTeams() {
        return mTeamList;
    }

    public Team getTeam(int id) {
        return mTeamList.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public Team createTeam(String name, String description) {
        int id = mTeamList.stream().mapToInt(t -> t.getId()).max().orElse(0) + 1;
        Team team = new Team(id, name, description);
        mTeamList.add(team);
        return team;
    }

    private void fillTestData() {
            Team zipCargoTeam = createTeam("ZipCargo", "Optimize space in cargo trucks. We provide a way for cargo trucks to optimize the leftover space that they have inside their trucks and generate new clients.");
            zipCargoTeam.addMember(createMember("Ivan", "Ivanov", "Leader"));
            zipCargoTeam.addMember(createMember("Peter", "Petrov", "Architect"));
            zipCargoTeam.addMember(createMember("Fedor", "Fedorov", "Marketing"));
            zipCargoTeam.addMember(createMember("Anna", "Kuznetsova", "Front-end Developer"));
            zipCargoTeam.addMember(createMember("Irina", "Vasilyeva", "Back-end Developer"));
            zipCargoTeam.addMember(createMember("Maria", "Ivanova", "Business development"));

            Team urbanBeatTeam = createTeam("UrbanBeat", "App for users to get discounts and opportunities from brands when they are close to the brand’s location.");
            urbanBeatTeam.addMember(createMember("Ivan", "Ivanov", "Leader"));
            urbanBeatTeam.addMember(createMember("Peter", "Petrov", "Architect"));
            urbanBeatTeam.addMember(createMember("Fedor", "Fedorov", "Marketing"));
            urbanBeatTeam.addMember(createMember("Anna", "Kuznetsova", "Front-end Developer"));
            urbanBeatTeam.addMember(createMember("Irina", "Vasilyeva", "Back-end Developer"));
            urbanBeatTeam.addMember(createMember("Maria", "Ivanova", "Business development"));

            Team noMeRobesTeam = createTeam("NoMeRobes", "App that alerts you if your bicycle is getting stolen and allows you to track it to get it back.");
            noMeRobesTeam.addMember(createMember("Ivan", "Ivanov", "Leader"));
            noMeRobesTeam.addMember(createMember("Peter", "Petrov", "Architect"));
            noMeRobesTeam.addMember(createMember("Fedor", "Fedorov", "Marketing"));
            noMeRobesTeam.addMember(createMember("Anna", "Kuznetsova", "Front-end Developer"));
            noMeRobesTeam.addMember(createMember("Irina", "Vasilyeva", "Back-end Developer"));
            noMeRobesTeam.addMember(createMember("Maria", "Ivanova", "Business development"));
    }
}
