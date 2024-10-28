package br.mattsousa.base.protocols.callbacks;

import java.util.Set;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.Party;

public abstract class AbstractPhaseCallback implements PhaseCallback {
    private Set<Party> parties;

    public AbstractPhaseCallback(Party[] targetParties) {
        this.parties = Set.of(targetParties);
    }

    @Override
    public void callback(BattleContext context) {
        if(!this.isApplicable(context.getAttackerParty())) {
            return;
        }
        this.execute(context);
    }

    public boolean isApplicable(Party party) {
        return parties.contains(party);
    }

    protected abstract void execute(BattleContext context);
}
