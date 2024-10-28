package br.mattsousa.base.model;

import java.util.Map;

import br.mattsousa.base.enums.BattleResultStatus;

public class BattleResult {
    private Map<Party, BattleResultStatus> results;

    public boolean isEnd() {
        if (results == null) {
            return false;
        }
        if (results.isEmpty()) {
            return false;
        }
        return true;
    }

    public Map<Party, BattleResultStatus> getResults() {
        return results;
    }

    public void setResults(Map<Party, BattleResultStatus> results) {
        this.results = results;
    }
}
