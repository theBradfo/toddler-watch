package bl.toddlerwatch.service;

import android.support.annotation.NonNull;
import android.util.SparseArray;

import bl.toddlerwatch.model.TrackedEvent;

/**
 * Created by theBr on 8/17/2016.
 */

public enum DataFactory {
    INSTANCE;

    private final DayDataProvider dayDataProvider = new DayDataProvider();
    private final SparseArray<TrackedEvent> events = new SparseArray<>();

    public DayDataProvider getDayDataProvider() {
        return this.dayDataProvider;
    }

    synchronized void addEvent(final @NonNull TrackedEvent event) {
        this.events.put(event.id, event);
    }

    SparseArray<TrackedEvent> getEvents() {
        return this.events;
    }

    public int getNextId() {
        // assumes a continuous id/growth
        return events.size() + 1;
    }
}
