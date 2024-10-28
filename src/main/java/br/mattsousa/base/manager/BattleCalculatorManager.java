package br.mattsousa.base.manager;

import br.mattsousa.base.model.BattleContext;

public class BattleCalculatorManager {

    
    public int calculateDamage(BattleContext context) {
        return context.getAttackSelected().getDamage();
    }

    public int calculateAttackerFatigue(BattleContext context) {
        return context.getAttackSelected().getFatigueCost();
    }

    public int calculateTargetFatigue(BattleContext context) {
        return context.getAttackSelected().getFatigueCost();
    }

    public int calculateExperience(BattleContext context) {
        if (context.getAttacker().getExperience() < context.getTarget().getExperience()) {
            return 75;
        }
        if (context.getAttacker().getExperience() > context.getTarget().getExperience()) {
            return 25;
        }
        return 50;
    }

    public String calculateHitChance(BattleContext context) {
        if (context.getAttacker().getDexterity() < context.getTarget().getAgility()) {
            return "0.25";
        }
        if(context.getAttacker().getDexterity() > context.getTarget().getAgility()) {
            return "0.75";
        }
        return "0.5";
    }
}
