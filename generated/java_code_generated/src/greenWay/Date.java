package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Date {
    public Number day;
    public Number month;
    public Number year;
    public Number hour;
    public Number minutes;
    public Number seconds;

    public Date(final Number d, final Number m, final Number y, final Number h,
        final Number min, final Number sec) {
        cg_init_Date_1(d, m, y, h, min, sec);
    }

    public Date() {
    }

    public void cg_init_Date_1(final Number d, final Number m, final Number y,
        final Number h, final Number min, final Number sec) {
        day = d;
        month = m;
        year = y;
        hour = h;
        minutes = min;
        seconds = sec;

        return;
    }

    public String toString() {
        return "Date{" + "day := " + Utils.toString(day) + ", month := " +
        Utils.toString(month) + ", year := " + Utils.toString(year) +
        ", hour := " + Utils.toString(hour) + ", minutes := " +
        Utils.toString(minutes) + ", seconds := " + Utils.toString(seconds) +
        "}";
    }
}
