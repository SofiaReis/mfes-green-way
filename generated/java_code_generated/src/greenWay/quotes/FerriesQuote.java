package greenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class FerriesQuote {
    private static int hc = 0;
    private static FerriesQuote instance = null;

    public FerriesQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static FerriesQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new FerriesQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof FerriesQuote;
    }

    public String toString() {
        return "<Ferries>";
    }
}
