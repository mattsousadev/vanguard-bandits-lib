package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.BattleCalculatorManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattlePreview;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.phases.BattlePhase;

public class PreBattlePhase implements BattlePhase {
    private BattlePhase next;
    private BattleCalculatorManager battleCalculationStrategy;

    public PreBattlePhase(BattleCalculatorManager battleCalculationStrategy) {
        this.battleCalculationStrategy = battleCalculationStrategy;
    }

    @Override
    public void setNext(BattlePhase next) {
        this.next = next;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        BattlePreview preview = new BattlePreview();
        preview.setDamage(battleCalculationStrategy.calculateDamage(context));
        preview.setAttackerFatigue(battleCalculationStrategy.calculateAttackerFatigue(context));
        preview.setTargetFatigue(battleCalculationStrategy.calculateTargetFatigue(context));
        preview.setExperience(battleCalculationStrategy.calculateExperience(context));
        preview.setHitChance(battleCalculationStrategy.calculateHitChance(context));
        context.setPreview(preview);
        return next.handle(context);
    }

    public BattleCalculatorManager getBattleCalculationStrategy() {
        return battleCalculationStrategy;
    }

    public void setBattleCalculationStrategy(BattleCalculatorManager battleCalculationStrategy) {
        this.battleCalculationStrategy = battleCalculationStrategy;
    }

}
