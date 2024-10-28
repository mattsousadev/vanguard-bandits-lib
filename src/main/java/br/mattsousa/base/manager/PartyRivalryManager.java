package br.mattsousa.base.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.Party;

public class PartyRivalryManager {
    private Map<Party, Set<Party>> rivalries;

    public PartyRivalryManager() {
        this.rivalries = new HashMap<>();
    }

    public void addRivalry(Party party1, Party party2) {
        rivalries.computeIfAbsent(party1, k -> new HashSet<>()).add(party2);
        rivalries.computeIfAbsent(party2, k -> new HashSet<>()).add(party1);
    }

    public boolean areRivals(Party party1, Party party2) {
        return rivalries.getOrDefault(party1, new HashSet<>()).contains(party2);
    }

    public Set<Party> getRivals(Party party) {
        return rivalries.getOrDefault(party, new HashSet<>());
    }

    public Set<Party> getRivals(BattleCharacter character) {
        return getRivals(rivalries
                .values()
                .stream()
                .flatMap(Set::stream)
                .filter(party -> party.getMembers().contains(character))
                .findFirst().orElse(null));
    }

    public Party getParty(BattleCharacter attacker) {
        return rivalries
                .values()
                .stream()
                .flatMap(Set::stream)
                .filter(party -> party.getMembers().contains(attacker))
                .findFirst().orElse(null);
    }
}
