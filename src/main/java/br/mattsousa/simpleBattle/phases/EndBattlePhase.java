package br.mattsousa.simpleBattle.phases;

import java.util.HashMap;
import java.util.Map;

import br.mattsousa.base.enums.BattleResultStatus;
import br.mattsousa.base.manager.EndGameManager;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.model.Party;
import br.mattsousa.base.protocols.phases.AbstractEndBattlePhase;

public class EndBattlePhase extends AbstractEndBattlePhase {

    private EndGameManager endGameManager;

    public EndBattlePhase(EndGameManager endGameManager) {
        this.endGameManager = endGameManager;
    }

    @Override
    protected BattleResult executePhase(BattleContext context) {
        BattleResult result = new BattleResult();
        Map<Party, BattleResultStatus> results = new HashMap<>();
        endGameManager.checkGameOver(context, results);
        result.setResults(results);
        return result;
    }

}
