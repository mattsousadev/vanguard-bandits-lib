package br.mattsousa.base.model;

import br.mattsousa.base.enums.BattleAttack;

public class BattleContext {
    private int currentTurn;
    private boolean hit;
    private BattleCharacter attacker;
    private BattleCharacter target;
    private Party attackerParty;
    private Party targetParty;
    private BattleAttack attackSelected;
    private BattlePreview preview;

    public BattleCharacter getAttacker() {
        return attacker;
    }

    public void setAttacker(BattleCharacter attacker) {
        this.attacker = attacker;
    }

    public BattleCharacter getTarget() {
        return target;
    }

    public void setTarget(BattleCharacter target) {
        this.target = target;
    }

    public Party getAttackerParty() {
        return attackerParty;
    }

    public void setAttackerParty(Party attackerParty) {
        this.attackerParty = attackerParty;
    }

    public Party getTargetParty() {
        return targetParty;
    }

    public void setTargetParty(Party targetParty) {
        this.targetParty = targetParty;
    }

    public BattleAttack getAttackSelected() {
        return attackSelected;
    }

    public void setAttackSelected(BattleAttack attackSelected) {
        this.attackSelected = attackSelected;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public BattlePreview getPreview() {
        return preview;
    }

    public void setPreview(BattlePreview preview) {
        this.preview = preview;
    }
    
}
