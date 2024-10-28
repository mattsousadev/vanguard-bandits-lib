package br.mattsousa.simpleBattle.phases;

import java.util.Set;

import br.mattsousa.base.manager.PartyRivalryManager;
import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.Party;
import br.mattsousa.base.protocols.phases.AbstractBattlePhase;
import br.mattsousa.base.protocols.strategies.TargetSelectStrategy;

public class TargetSelectPhase extends AbstractBattlePhase {
    private PartyRivalryManager partyRivalryManager;
    private TargetSelectStrategy targetSelectStrategy;

    public TargetSelectPhase(PartyRivalryManager partyRivalryManager, TargetSelectStrategy targetSelectStrategy) {
        this.partyRivalryManager = partyRivalryManager;
        this.targetSelectStrategy = targetSelectStrategy;
    }

    @Override
    protected void executePhase(BattleContext context) {
        Set<Party> rivalParties = partyRivalryManager.getRivals(context.getAttacker());

        BattleCharacter target = targetSelectStrategy.getTarget(rivalParties);
        context.setTarget(target);

        Party attackerParty = partyRivalryManager.getParty(context.getAttacker());
        context.setAttackerParty(attackerParty);

        Party targetParty = partyRivalryManager.getParty(target);
        context.setTargetParty(targetParty);
    }

    public TargetSelectStrategy getTargetSelectStrategy() {
        return targetSelectStrategy;
    }

    public void setTargetSelectStrategy(TargetSelectStrategy targetSelectStrategy) {
        this.targetSelectStrategy = targetSelectStrategy;
    }

}
