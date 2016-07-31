package bl.toddlerwatch.model;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by theBr on 7/31/2016.
 */

public final class ProcessedData<I> {
    public final I key;
    public final int onTime; // in seconds
    public final TimeUnit onTimeUnit;
    public final int bootCount;
    public final int sleepCount;
    public final List<TrackedEvent> data;

    public ProcessedData(I key, int onTime, TimeUnit onTimeUnit, int bootCount, int sleepCount, final List<TrackedEvent> data) {
        this.key = key;
        this.onTime = onTime;
        this.onTimeUnit = onTimeUnit;
        this.bootCount = bootCount;
        this.sleepCount = sleepCount;
        this.data = Collections.unmodifiableList(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcessedData<?> that = (ProcessedData<?>) o;

        if (onTime != that.onTime) return false;
        if (bootCount != that.bootCount) return false;
        if (sleepCount != that.sleepCount) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (onTimeUnit != that.onTimeUnit) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + onTime;
        result = 31 * result + (onTimeUnit != null ? onTimeUnit.hashCode() : 0);
        result = 31 * result + bootCount;
        result = 31 * result + sleepCount;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProcessedData{" +
                "key=" + key +
                ", onTime=" + onTime +
                ", onTimeUnit=" + onTimeUnit +
                ", bootCount=" + bootCount +
                ", sleepCount=" + sleepCount +
                ", data=" + data +
                '}';
    }
}
