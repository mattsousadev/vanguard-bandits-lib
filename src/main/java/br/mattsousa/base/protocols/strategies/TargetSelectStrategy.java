package br.mattsousa.base.protocols.strategies;

import java.util.Set;

import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.Party;

public interface TargetSelectStrategy {
    BattleCharacter getTarget(Set<Party> rivalParties);
}