package greenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class DisableQuote {
    private static int hc = 0;
    private static DisableQuote instance = null;

    public DisableQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static DisableQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new DisableQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof DisableQuote;
    }

    public String toString() {
        return "<Disable>";
    }
}
