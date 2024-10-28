package br.mattsousa.base.protocols.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.callbacks.PhaseCallback;

public abstract class AbstractConfirmationPhase implements ConfirmationPhase {
    private BattlePhase next;
    private BattlePhase alternative;
    private PhaseCallback callback;

    @Override
    public void setAlternative(BattlePhase alternative) {
        this.alternative = alternative;
    }

    @Override
    public void setNext(BattlePhase next) {
        this.next = next;
    }

    @Override
    public BattleResult handle(BattleContext context) {
        BattlePhase nextPhase = next;
        this.executePhase(context);
        if (useAlternative(context)) {
            nextPhase = alternative;
        }
        if(callback != null) {
            callback.callback(context);
        }
        return nextPhase.handle(context);
    }
    
    protected abstract boolean useAlternative(BattleContext context);

    protected abstract void executePhase(BattleContext context);

    public PhaseCallback getCallback() {
        return callback;
    }

    public void setCallback(PhaseCallback callback) {
        this.callback = callback;
    }

}
