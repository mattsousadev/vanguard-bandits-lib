package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.BattleExecutorManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.protocols.phases.AbstractBattlePhase;

public class PostBattlePhase extends AbstractBattlePhase {
    private BattleExecutorManager battleCalculatorManager;

    public PostBattlePhase(BattleExecutorManager battleCalculatorManager) {
        this.battleCalculatorManager = battleCalculatorManager;
    }

    @Override
    protected void executePhase(BattleContext context) {
        battleCalculatorManager.applyFatigue(context);

        if(context.isHit()) {
            battleCalculatorManager.applyDamage(context);
        }
    }

}
