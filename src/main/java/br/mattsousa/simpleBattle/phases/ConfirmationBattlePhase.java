package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.phases.BattlePhase;
import br.mattsousa.base.protocols.phases.ConfirmationPhase;
import br.mattsousa.base.protocols.strategies.BattleConfirmationStrategy;

public class ConfirmationBattlePhase implements ConfirmationPhase {
    private BattlePhase confirmationPhase;
    private BattlePhase alternativePhase;
    private BattleConfirmationStrategy confirmationStrategy;

    public ConfirmationBattlePhase(BattleConfirmationStrategy confirmationStrategy) {
        this.confirmationStrategy = confirmationStrategy;
    }

    @Override
    public void setNext(BattlePhase next) {
        this.confirmationPhase = next;
    }

    @Override
    public void setAlternative(BattlePhase alternative) {
        this.alternativePhase = alternative;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        if (confirmationStrategy.confirm(context)) {
            return confirmationPhase.handle(context);
        }
        return alternativePhase.handle(context);
    }

    public BattleConfirmationStrategy getConfirmationStrategy() {
        return confirmationStrategy;
    }

    public void setConfirmationStrategy(BattleConfirmationStrategy confirmationStrategy) {
        this.confirmationStrategy = confirmationStrategy;
    }

}