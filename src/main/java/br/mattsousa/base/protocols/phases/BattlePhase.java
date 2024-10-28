package br.mattsousa.base.protocols.phases;

import br.mattsousa.base.model.BattleContext;
import br.mattsousa.base.model.BattleResult;

public interface BattlePhase {
    void setNext(BattlePhase next);

    BattleResult handle(BattleContext context);
}