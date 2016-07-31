package bl.toddlerwatch.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import bl.toddlerwatch.model.Day;
import bl.toddlerwatch.model.ProcessedData;
import bl.toddlerwatch.model.TrackedEvent;

/**
 * Created by theBr on 7/30/2016.
 */

public enum DataProvider {
    INSTANCE;

    private final SparseArray<TrackedEvent> events = new SparseArray<>();
    private final TreeMap<Day,ProcessedData<Day>> processedData = new TreeMap<>();

    public void addEvent(@NonNull final TrackedEvent event) {
        events.put(event.id, event);
    }

    public synchronized int getNextId() {
        return events.size() + 1;
    }

    public SparseArray<TrackedEvent> getEvents() {
        return events;
    }

    public synchronized void putProcessedData(@NonNull Day day, @NonNull ProcessedData<Day> data) {
        this.processedData.put(day, data);
    }

    public Map<Day, ProcessedData<Day>> getProcessedData() {
        return processedData;
    }

    public @Nullable Date getMinDate() {
        if (processedData.isEmpty()) {
            return null;
        }
        return processedData.firstKey().toDate();
    }

    public @Nullable Date getMaxDate() {
        if (processedData.isEmpty()) {
            return null;
        }
        return processedData.lastKey().toDate();
    }
}
