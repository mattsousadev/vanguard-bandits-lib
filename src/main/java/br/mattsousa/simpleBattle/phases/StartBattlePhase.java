package br.mattsousa.simpleBattle.phases;

import br.mattsousa.base.manager.TurnManager;
import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.model.CharacterStatus;
import br.mattsousa.base.protocols.phases.BattlePhase;

public class StartBattlePhase implements BattlePhase {
    private BattlePhase next;
    private TurnManager turnManager;

    public StartBattlePhase(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    @Override
    public void setNext(BattlePhase next) {
        this.next = next;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        BattleCharacter character = turnManager.nextTurn();
        while (character.getStatus() == CharacterStatus.STUNNED) {
            character = turnManager.nextTurn();
        }
        context.setAttacker(character);
        context.setCurrentTurn(turnManager.getTurnCount());
        return next.handle(context);
    }
}
