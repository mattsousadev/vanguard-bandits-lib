package br.mattsousa.base.protocols.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.callbacks.PhaseCallback;

public abstract class AbstractEndBattlePhase implements BattlePhase {
    private PhaseCallback callback;

    @Override
    public BattleResult handle(BattleContext context) {
        BattleResult result = this.executePhase(context);
        if (callback != null) {
            callback.callback(context);
        }
        return result;
    }
    
    @Override
    public void setNext(BattlePhase next) {}

    protected abstract BattleResult executePhase(BattleContext context);

    public PhaseCallback getCallback() {
        return callback;
    }

    public void setCallback(PhaseCallback callback) {
        this.callback = callback;
    }
}
