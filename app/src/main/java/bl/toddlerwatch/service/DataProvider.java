package bl.toddlerwatch.service;

import android.util.SparseArray;

import bl.toddlerwatch.model.TrackedEvent;

/**
 * Created by theBr on 7/30/2016.
 */

public enum DataProvider {
    INSTANCE;

    private final SparseArray<TrackedEvent> events = new SparseArray<>();

    public void addEvent(final TrackedEvent event) {
        events.put(event.id, event);
    }

    public synchronized int getNextId() {
        return events.size() + 1;
    }

    public SparseArray<TrackedEvent> getEvents() {
        return events;
    }
}
