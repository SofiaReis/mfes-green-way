package greenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class HighWayQuote {
    private static int hc = 0;
    private static HighWayQuote instance = null;

    public HighWayQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static HighWayQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new HighWayQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof HighWayQuote;
    }

    public String toString() {
        return "<HighWay>";
    }
}
