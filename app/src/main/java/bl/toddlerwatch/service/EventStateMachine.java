package bl.toddlerwatch.service;

import bl.toddlerwatch.model.TrackedEvent;

/**
 * Created by theBr on 7/30/2016.
 */

public enum EventStateMachine {
    INSTANCE;

    public void nextState(TrackedEvent event) {
        DataProvider.INSTANCE.addEvent(event);

        // go through and calculate duration spent from state A -> B if ending state.
        
    }
}
