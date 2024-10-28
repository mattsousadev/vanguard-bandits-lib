package br.mattsousa.base.protocols.callbacks;

import br.mattsousa.base.model.BattleContext;

public interface PhaseCallback {
    void callback(BattleContext context);
}
