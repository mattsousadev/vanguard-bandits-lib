package br.mattsousa.base.model;

public class BattlePreview {
    private int damage;
    private int attackerFatigue;
    private int targetFatigue;
    private int experience;
    private String hitChance;

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getAttackerFatigue() {
        return attackerFatigue;
    }
    public void setAttackerFatigue(int attackerFatigue) {
        this.attackerFatigue = attackerFatigue;
    }
    public int getTargetFatigue() {
        return targetFatigue;
    }
    public void setTargetFatigue(int targetFatigue) {
        this.targetFatigue = targetFatigue;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public String getHitChance() {
        return hitChance;
    }
    public void setHitChance(String hitChance) {
        this.hitChance = hitChance;
    }
    @Override
    public String toString() {
        return "BattlePreview [damage=" + damage + ", attackerFatigue=" + attackerFatigue + ", targetFatigue="
                + targetFatigue + ", experience=" + experience + ", hitChance=" + hitChance + "]";
    }
    
}