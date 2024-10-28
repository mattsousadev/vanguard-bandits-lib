package br.mattsousa.base.protocols.gameover;

import java.util.HashMap;
import java.util.Map;

import br.mattsousa.base.enums.BattleResultStatus;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.Party;

public class DeadPartyGameOver implements GameOverVerification {

    @Override
    public Map<Party, BattleResultStatus> check(BattleContext context) {
        if(context.getTargetParty().getMembers().stream().allMatch(character -> character.getHealth() == 0)){
            Map<Party, BattleResultStatus> results = new HashMap<>();
            results.put(context.getAttackerParty(), BattleResultStatus.VICTORY);
            results.put(context.getAttackerParty(), BattleResultStatus.DEFEAT);
            return results;
        }
        return new HashMap<>();
    }
    
}
