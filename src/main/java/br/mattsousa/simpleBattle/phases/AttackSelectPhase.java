package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.protocols.phases.AbstractBattlePhase;
import br.mattsousa.base.protocols.strategies.BattleAttackSelectStrategy;

public class AttackSelectPhase extends AbstractBattlePhase {
    
    private BattleAttackSelectStrategy attackSelectStrategy;

    public AttackSelectPhase(BattleAttackSelectStrategy attackSelectStrategy) {
        this.attackSelectStrategy = attackSelectStrategy;
    }

    @Override
    protected void executePhase(BattleContext context) {
        context.setAttackSelected(attackSelectStrategy.getAttack());
    }

    public BattleAttackSelectStrategy getAttackSelectStrategy() {
        return attackSelectStrategy;
    }

    public void setAttackSelectStrategy(BattleAttackSelectStrategy attackSelectStrategy) {
        this.attackSelectStrategy = attackSelectStrategy;
    }

}
