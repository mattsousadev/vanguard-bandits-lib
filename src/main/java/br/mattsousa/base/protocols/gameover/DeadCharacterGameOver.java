package br.mattsousa.base.protocols.gameover;

import java.util.HashMap;
import java.util.Map;

import br.mattsousa.base.enums.BattleResultStatus;
import br.mattsousa.base.manager.PartyRivalryManager;
import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.Party;

public class DeadCharacterGameOver implements GameOverVerification {

    private BattleCharacter character;

    private PartyRivalryManager rivalryManager;

    public DeadCharacterGameOver(BattleCharacter character, PartyRivalryManager rivalryManager) {
        this.character = character;
        this.rivalryManager = rivalryManager;
    }

    @Override
    public Map<Party, BattleResultStatus> check(BattleContext context) {
        if(character.getHealth() == 0){
            Map<Party, BattleResultStatus> results = new HashMap<>();
            for(Party party : rivalryManager.getRivals(character)){
                results.put(party, BattleResultStatus.VICTORY);
            }
            results.put(rivalryManager.getParty(character), BattleResultStatus.DEFEAT);
            return results;
        }
        return new HashMap<>();
    }
    
}
