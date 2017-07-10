public class Member {
    private int mId;
    private String mFirstName;
    private String mLastName;
    private String mRole;

    public Member(int id, String firstName, String lastName, String role) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mRole = role;
    }

    public int getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getRole() {
        return mRole;
    }
}