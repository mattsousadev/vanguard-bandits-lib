package br.mattsousa.base.enums;

public enum BattleAttack {
    SLASH(10, 5), THRUST(15, 5), KICK(5, 5);

    private int damage;
    private int fatigueCost;

    BattleAttack(int damage, int fatigueCost) {
        this.damage = damage;
        this.fatigueCost = fatigueCost;
    }

    public int getDamage() {
        return damage;
    }

    public int getFatigueCost() {
        return fatigueCost;
    }
}
