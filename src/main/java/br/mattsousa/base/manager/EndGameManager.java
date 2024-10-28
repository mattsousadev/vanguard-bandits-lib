package br.mattsousa.base.manager;

import java.util.List;
import java.util.Map;

import br.mattsousa.base.enums.BattleResultStatus;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.Party;
import br.mattsousa.base.protocols.gameover.GameOverVerification;

public class EndGameManager {

    private List<GameOverVerification> verifications;

    public EndGameManager(List<GameOverVerification> verifications) {
        this.verifications = verifications;
    }

    public void checkGameOver(BattleContext context, Map<Party, BattleResultStatus> results) {
        for(GameOverVerification verification : verifications) {
            Map<Party, BattleResultStatus> partialResults = verification.check(context);
            results.putAll(partialResults);
            if(!partialResults.isEmpty()) {
                break;
            }
        }
    }
}
