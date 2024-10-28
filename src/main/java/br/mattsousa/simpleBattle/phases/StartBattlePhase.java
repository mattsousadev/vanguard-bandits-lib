package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.TurnManager;
import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.CharacterStatus;
import br.mattsousa.base.protocols.phases.AbstractBattlePhase;

public class StartBattlePhase extends AbstractBattlePhase {
    private TurnManager turnManager;

    public StartBattlePhase(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    @Override
    protected void executePhase(BattleContext context) {
        BattleCharacter character = turnManager.nextTurn();
        while (character.getStatus() == CharacterStatus.STUNNED) {
            character = turnManager.nextTurn();
        }
        context.setAttacker(character);
        context.setCurrentTurn(turnManager.getTurnCount());
    }

}
