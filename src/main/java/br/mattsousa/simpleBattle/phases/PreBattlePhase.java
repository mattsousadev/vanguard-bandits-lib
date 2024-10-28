package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.BattleCalculatorManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattlePreview;
import br.mattsousa.base.protocols.phases.AbstractBattlePhase;

public class PreBattlePhase extends AbstractBattlePhase {
    private BattleCalculatorManager battleCalculationStrategy;

    public PreBattlePhase(BattleCalculatorManager battleCalculationStrategy) {
        this.battleCalculationStrategy = battleCalculationStrategy;
    }

    @Override
    protected void executePhase(BattleContext context) {
        BattlePreview preview = new BattlePreview();
        preview.setDamage(battleCalculationStrategy.calculateDamage(context));
        preview.setAttackerFatigue(battleCalculationStrategy.calculateAttackerFatigue(context));
        preview.setTargetFatigue(battleCalculationStrategy.calculateTargetFatigue(context));
        preview.setExperience(battleCalculationStrategy.calculateExperience(context));
        preview.setHitChance(battleCalculationStrategy.calculateHitChance(context));
        context.setPreview(preview);
    }

    public BattleCalculatorManager getBattleCalculationStrategy() {
        return battleCalculationStrategy;
    }

    public void setBattleCalculationStrategy(BattleCalculatorManager battleCalculationStrategy) {
        this.battleCalculationStrategy = battleCalculationStrategy;
    }

}
