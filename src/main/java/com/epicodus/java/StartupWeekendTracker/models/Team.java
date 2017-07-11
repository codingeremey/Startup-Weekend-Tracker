package com.epicodus.java.StartupWeekendTracker.models;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int mId;
    private String mName;
    private String mDescription;
    private List<Member> mMemberList;

    public Team(int id, String name, String description) {
        mId = id;
        mName = name;
        mDescription = description;
        mMemberList = new ArrayList<>();
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void addMember(Member member) {
        mMemberList.add(member);
    }

    public List<Member> getMembers() {
        return mMemberList;
    }
}