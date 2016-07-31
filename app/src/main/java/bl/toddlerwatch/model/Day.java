package bl.toddlerwatch.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by theBr on 7/31/2016.
 */

public final class Day {
    public final int month;
    public final int year;
    public final int dayOfMonth;

    public Day(int month, int year, int dayOfMonth) {
        this.month = month;
        this.year = year;
        this.dayOfMonth = dayOfMonth;
    }

    public static Day fromDate(Date date) {
        return new Day(date.getMonth(), date.getYear(), date.getDate());
    }

    public Date toDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        return calendar.getTime();
    }
}
