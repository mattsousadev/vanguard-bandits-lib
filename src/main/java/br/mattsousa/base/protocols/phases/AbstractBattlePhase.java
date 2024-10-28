package br.mattsousa.base.protocols.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.callbacks.PhaseCallback;

public abstract class AbstractBattlePhase implements BattlePhase {
    private BattlePhase next;
    private PhaseCallback callback;

    @Override
    public BattleResult handle(BattleContext context) {
        this.executePhase(context);
        if (callback != null) {
            callback.callback(context);
        }
        return next.handle(context);
    }
    
    @Override
    public void setNext(BattlePhase next) {
        this.next = next;
    }

    protected abstract void executePhase(BattleContext context);

    public PhaseCallback getCallback() {
        return callback;
    }

    public void setCallback(PhaseCallback callback) {
        this.callback = callback;
    }

    
}
