package br.mattsousa.base.manager;

import br.mattsousa.base.model.BattleCharacter;
import br.mattsousa.base.model.BattleContext;

public class BattleExecutorManager {

    public void applyFatigue(BattleContext context) {
        BattleCharacter attacker = context.getAttacker();
        int newFatigue = attacker.getFatigue() + context.getPreview().getAttackerFatigue();
        attacker.setFatigue(newFatigue);

        BattleCharacter target = context.getTarget();
        newFatigue = target.getFatigue() + context.getPreview().getTargetFatigue();
        target.setFatigue(newFatigue);
    }

    public void applyDamage(BattleContext context) {
        BattleCharacter target = context.getTarget();
        int newHealth = target.getHealth() - context.getPreview().getDamage();
        target.setHealth(newHealth);
    }
    
}
