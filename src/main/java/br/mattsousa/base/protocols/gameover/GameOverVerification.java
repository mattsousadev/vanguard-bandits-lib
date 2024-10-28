package br.mattsousa.base.protocols.gameover;

import java.util.Map;

import br.mattsousa.base.enums.BattleResultStatus;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.Party;

public interface GameOverVerification {

    Map<Party, BattleResultStatus> check(BattleContext context);
    
}
