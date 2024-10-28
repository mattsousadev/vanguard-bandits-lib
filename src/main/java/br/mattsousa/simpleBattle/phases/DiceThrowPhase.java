package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.ProbabilityManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.phases.BattlePhase;

public class DiceThrowPhase implements BattlePhase {

    private ProbabilityManager probabilityManager;
    private BattlePhase next;

    public DiceThrowPhase(ProbabilityManager probabilityManager) {
        this.probabilityManager = probabilityManager;
    }

    @Override
    public void setNext(BattlePhase next) {
        this.next = next;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        boolean[] probabilityChance = probabilityManager.getChance(context.getPreview().getHitChance());
        
        int randomSelection = (int) (Math.random() * probabilityChance.length);
        context.setHit(probabilityChance[randomSelection]);


        return next.handle(context);
    }
    
}
