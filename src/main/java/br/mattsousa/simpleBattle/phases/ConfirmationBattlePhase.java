package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.protocols.phases.AbstractConfirmationPhase;
import br.mattsousa.base.protocols.strategies.BattleConfirmationStrategy;

public class ConfirmationBattlePhase extends AbstractConfirmationPhase  {
    
    private BattleConfirmationStrategy confirmationStrategy;

    public ConfirmationBattlePhase(BattleConfirmationStrategy confirmationStrategy) {
        this.confirmationStrategy = confirmationStrategy;
    }

    @Override
    protected boolean useAlternative(BattleContext context) {
        return !confirmationStrategy.confirm(context);
    }

    @Override
    protected void executePhase(BattleContext context) {}

    public BattleConfirmationStrategy getConfirmationStrategy() {
        return confirmationStrategy;
    }

    public void setConfirmationStrategy(BattleConfirmationStrategy confirmationStrategy) {
        this.confirmationStrategy = confirmationStrategy;
    }

}