package bl.toddlerwatch.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.TreeMap;

import bl.toddlerwatch.model.Day;
import bl.toddlerwatch.model.ProcessedData;

/**
 * Created by theBr on 7/30/2016.
 */

public final class DayDataProvider implements DataProvider<Day> {

    private final TreeMap<Day,ProcessedData<Day>> processedData = new TreeMap<>();

    @Override
    public synchronized void putProcessedData(@NonNull Day day, @NonNull ProcessedData<Day> data) {
        this.processedData.put(day, data);
    }

    @Override
    public @Nullable ProcessedData<Day> getProcessedData(final Day day) {
        return processedData.get(day);
    }

    @Override
    public Map<Day, ProcessedData<Day>> getProcessedData() {
        return processedData;
    }

    @Override
    public @Nullable Day getMin() {
        if (processedData.isEmpty()) {
            return null;
        }
        return processedData.firstKey();
    }

    @Override
    public @Nullable Day getMax() {
        if (processedData.isEmpty()) {
            return null;
        }
        return processedData.lastKey();
    }
}
