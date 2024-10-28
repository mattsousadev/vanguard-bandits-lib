package br.mattsousa.base.protocols.phases;

public interface ConfirmationPhase extends BattlePhase {
    void setAlternative(BattlePhase alternative);
}