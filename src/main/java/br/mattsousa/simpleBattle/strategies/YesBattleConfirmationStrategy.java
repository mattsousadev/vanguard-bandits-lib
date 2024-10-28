package br.mattsousa.simpleBattle.strategies;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.protocols.strategies.BattleConfirmationStrategy;

public class YesBattleConfirmationStrategy implements BattleConfirmationStrategy {
    @Override
    public boolean confirm(BattleContext context) {
        return true;
    }
    
}
