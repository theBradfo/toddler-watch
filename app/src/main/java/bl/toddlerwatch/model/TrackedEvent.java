package bl.toddlerwatch.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Date;

import bl.toddlerwatch.service.State;

/**
 * Created by theBr on 7/30/2016.
 */

public final class TrackedEvent implements Parcelable {
    public final int id;
    public final @NonNull Date eventTime;
    public final @NonNull State action;

    public TrackedEvent(int id, final Date eventTime, String action) {
        this.id = id;
        this.eventTime = eventTime;
        this.action = State.fromAction(action);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackedEvent that = (TrackedEvent) o;

        if (id != that.id) return false;
        if (eventTime != null ? !eventTime.equals(that.eventTime) : that.eventTime != null)
            return false;
        return action == that.action;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (eventTime != null ? eventTime.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrackedEvent{" +
                "id=" + id +
                ", eventTime=" + eventTime +
                ", action=" + action +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeLong(this.eventTime != null ? this.eventTime.getTime() : -1);
        dest.writeInt(this.action == null ? -1 : this.action.ordinal());
    }

    protected TrackedEvent(Parcel in) {
        this.id = in.readInt();
        long tmpEventTime = in.readLong();
        this.eventTime = tmpEventTime == -1 ? null : new Date(tmpEventTime);
        int tmpAction = in.readInt();
        this.action = tmpAction == -1 ? null : State.values()[tmpAction];
    }

    public static final Creator<TrackedEvent> CREATOR = new Creator<TrackedEvent>() {
        @Override
        public TrackedEvent createFromParcel(Parcel source) {
            return new TrackedEvent(source);
        }

        @Override
        public TrackedEvent[] newArray(int size) {
            return new TrackedEvent[size];
        }
    };
}
