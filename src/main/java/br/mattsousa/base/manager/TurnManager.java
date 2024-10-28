package br.mattsousa.base.manager;

import java.util.List;

import br.mattsousa.base.model.BattleCharacter;

public class TurnManager {
    private List<BattleCharacter> turnOrder;
    private int currentTurnIndex = 0;
    private int turnCount = 0;

    public TurnManager(List<BattleCharacter> turnOrder) {
        this.turnOrder = turnOrder;
    }

    public BattleCharacter nextTurn() {
        BattleCharacter currentCharacter = getCurrentCharacter();
        turnCount++;
        currentTurnIndex = (currentTurnIndex + 1) % turnOrder.size();
        return currentCharacter;
    }

    public BattleCharacter getCurrentCharacter() {
        return turnOrder.get(currentTurnIndex);
    }

    public int getTurnCount() {
        return turnCount;
    }

}
