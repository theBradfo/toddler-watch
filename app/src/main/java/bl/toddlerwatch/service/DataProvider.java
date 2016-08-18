package bl.toddlerwatch.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Map;

import bl.toddlerwatch.model.ProcessedData;

/**
 * Created by theBr on 8/17/2016.
 */
public interface DataProvider<I> {

    void putProcessedData(@NonNull I day, @NonNull ProcessedData<I> data);

    @Nullable
    ProcessedData<I> getProcessedData(I day);

    Map<I, ProcessedData<I>> getProcessedData();

    @Nullable
    I getMin();

    @Nullable
    I getMax();
}
