package br.mattsousa.base.manager;

import java.util.ArrayList;
import java.util.List;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;
import br.mattsousa.base.protocols.phases.BattlePhase;
import br.mattsousa.base.protocols.phases.ConfirmationPhase;

public class BattleManager {
    private List<BattlePhase> phases;
    private List<BattlePhase> alternativePhases;
    private final BattleContext context;

    public BattleManager(BattlePhase firstPhase) {
        this.context = new BattleContext();
        this.phases = new ArrayList<>();
        this.alternativePhases = new ArrayList<>();
        this.phases.add(firstPhase);
    }

    public void addPhase(BattlePhase phase) {
        addPhase(phase, null);
    }

    public void addPhase(BattlePhase phase, BattlePhase alternative) {
        phases.get(phases.size() - 1).setNext(phase);
        phases.add(phase);
        if (alternative != null && phase instanceof ConfirmationPhase) {
            ((ConfirmationPhase) phase).setAlternative(alternative);
            if (phases.indexOf(alternative) == -1) {
                alternativePhases.add(alternative);
            }
        }
    }

    public BattleResult performTurn() {
        return phases.get(0).handle(context);
    }

}
