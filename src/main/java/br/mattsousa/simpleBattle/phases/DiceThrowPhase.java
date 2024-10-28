package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.ProbabilityManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.protocols.phases.AbstractBattlePhase;

public class DiceThrowPhase extends AbstractBattlePhase  {
    private ProbabilityManager probabilityManager;

    public DiceThrowPhase(ProbabilityManager probabilityManager) {
        this.probabilityManager = probabilityManager;
    }

    @Override
    protected void executePhase(BattleContext context) {
        boolean[] probabilityChance = probabilityManager.getChance(context.getPreview().getHitChance());
        
        int randomSelection = (int) (Math.random() * probabilityChance.length);
        
        context.setHit(probabilityChance[randomSelection]);
    }

}
