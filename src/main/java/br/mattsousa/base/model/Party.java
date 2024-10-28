package br.mattsousa.base.model;

import java.util.Arrays;
import java.util.List;

public class Party {

    private String name;
    private List<BattleCharacter> members;

    public Party(BattleCharacter... members) {
        this.members = Arrays.asList(members);
    }

    public Party(List<BattleCharacter> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BattleCharacter> getMembers() {
        return members;
    }

    public void setMembers(List<BattleCharacter> members) {
        this.members = members;
    }

    public boolean hasMember(BattleCharacter currentCharacter) {
        return members.contains(currentCharacter);
    }

}