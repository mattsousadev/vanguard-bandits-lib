package br.mattsousa.simpleBattle.phases;

import java.util.Set;

import br.mattsousa.base.manager.PartyRivalryManager;
import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.model.Party;
import br.mattsousa.base.protocols.phases.BattlePhase;
import br.mattsousa.base.protocols.strategies.TargetSelectStrategy;

public class TargetSelectPhase implements BattlePhase {
    private BattlePhase phase;
    private PartyRivalryManager partyRivalryManager;
    private TargetSelectStrategy targetSelectStrategy;

    public TargetSelectPhase(PartyRivalryManager partyRivalryManager, TargetSelectStrategy targetSelectStrategy) {
        this.partyRivalryManager = partyRivalryManager;
        this.targetSelectStrategy = targetSelectStrategy;
    }

    @Override
    public void setNext(BattlePhase phase) {
        this.phase = phase;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        Set<Party> rivalParties = partyRivalryManager.getRivals(context.getAttacker());

        BattleCharacter target = targetSelectStrategy.getTarget(rivalParties);
        context.setTarget(target);

        Party attackerParty = partyRivalryManager.getParty(context.getAttacker());
        context.setAttackerParty(attackerParty);

        Party targetParty = partyRivalryManager.getParty(target);
        context.setTargetParty(targetParty);

        return phase.handle(context);
    }

    public TargetSelectStrategy getTargetSelectStrategy() {
        return targetSelectStrategy;
    }

    public void setTargetSelectStrategy(TargetSelectStrategy targetSelectStrategy) {
        this.targetSelectStrategy = targetSelectStrategy;
    }

}
