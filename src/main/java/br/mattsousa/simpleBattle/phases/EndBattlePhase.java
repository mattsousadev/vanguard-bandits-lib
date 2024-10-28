package br.mattsousa.simpleBattle.phases;

import java.util.HashMap;
import java.util.Map;

import br.mattsousa.base.enums.BattleResultStatus;
import br.mattsousa.base.manager.EndGameManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.model.Party;
import br.mattsousa.base.protocols.phases.BattlePhase;

public class EndBattlePhase implements BattlePhase {
    
    private EndGameManager endGameManager;

    public EndBattlePhase(EndGameManager endGameManager) {
        this.endGameManager = endGameManager;
    }

    @Override
    public void setNext(BattlePhase phase) {}

    @Override
    public BattleResult handle(BattleContext context) {
        BattleResult output = new BattleResult();
        Map<Party, BattleResultStatus> results = new HashMap<>();
        endGameManager.checkGameOver(context, results);
        output.setResults(results);
        return output;
    }
}
