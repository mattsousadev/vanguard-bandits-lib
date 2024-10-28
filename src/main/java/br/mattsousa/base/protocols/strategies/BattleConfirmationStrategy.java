package br.mattsousa.base.protocols.strategies;

import br.mattsousa.base.model.BattleContext;

public interface BattleConfirmationStrategy {
    boolean confirm(BattleContext context);
}