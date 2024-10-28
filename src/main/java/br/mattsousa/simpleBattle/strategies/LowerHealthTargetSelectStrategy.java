package br.mattsousa.simpleBattle.strategies;

import java.util.Set;

import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.Party;
import br.mattsousa.base.protocols.strategies.TargetSelectStrategy;

public class LowerHealthTargetSelectStrategy implements TargetSelectStrategy {

    @Override
    public BattleCharacter getTarget(Set<Party> rivalParties) {
        // Get the BattleCharacter with the lowest health
        return rivalParties.stream().findFirst().get().getMembers().stream()
                .min((a, b) -> a.getHealth() - b.getHealth()).get();
    }

}
