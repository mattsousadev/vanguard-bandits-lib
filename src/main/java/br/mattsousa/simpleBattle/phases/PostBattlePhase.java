package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.BattleExecutorManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.phases.BattlePhase;

public class PostBattlePhase implements BattlePhase {
    private BattlePhase next;
    private BattleExecutorManager battleCalculatorManager;

    public PostBattlePhase(BattleExecutorManager battleCalculatorManager) {
        this.battleCalculatorManager = battleCalculatorManager;
    }

    @Override
    public void setNext(BattlePhase next) {
        this.next = next;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        battleCalculatorManager.applyFatigue(context);

        if(context.isHit()) {
            battleCalculatorManager.applyDamage(context);
        }
        return next.handle(context);
    }
}
