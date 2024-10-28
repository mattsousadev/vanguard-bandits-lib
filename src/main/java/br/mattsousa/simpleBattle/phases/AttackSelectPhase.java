package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.phases.BattlePhase;
import br.mattsousa.base.protocols.strategies.BattleAttackSelectStrategy;

public class AttackSelectPhase implements BattlePhase {
    private BattlePhase phase;
    private BattleAttackSelectStrategy attackSelectStrategy;

    public AttackSelectPhase(BattleAttackSelectStrategy attackSelectStrategy) {
        this.attackSelectStrategy = attackSelectStrategy;
    }

    public AttackSelectPhase(BattlePhase phase) {
        this.phase = phase;
    }

    @Override
    public void setNext(BattlePhase phase) {
        this.phase = phase;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        context.setAttackSelected(attackSelectStrategy.getAttack());
        return phase.handle(context);
    }

    public BattleAttackSelectStrategy getAttackSelectStrategy() {
        return attackSelectStrategy;
    }

    public void setAttackSelectStrategy(BattleAttackSelectStrategy attackSelectStrategy) {
        this.attackSelectStrategy = attackSelectStrategy;
    }

}
