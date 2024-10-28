package br.mattsousa.simpleBattle.strategies;

import java.util.Arrays;

import br.mattsousa.base.enums.BattleAttack;
import br.mattsousa.base.protocols.strategies.BattleAttackSelectStrategy;

public class HigherDamageAttackSelectStrategy implements BattleAttackSelectStrategy {

    @Override
    public BattleAttack getAttack() {
        return Arrays.stream(BattleAttack.values()).max((a, b) -> a.getDamage() - b.getDamage()).get();
    }
    
}
