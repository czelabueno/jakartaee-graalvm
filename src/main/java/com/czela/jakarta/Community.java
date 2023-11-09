package com.czela.jakarta;

import java.util.List;

public class Community {
    private String name;
    private List<String> members;

    public Community(String name, List<String> members) {
        this.name = name;
        this.members = members;
    }

    public String getName(){
        return this.name;
    }

    public List<String> getMembers(){
        return this.members;
    }

    public void addMember(String member){
        this.members.add(member);
    }

    public void removeMember(String member){
        this.members.remove(member);
    }

}
