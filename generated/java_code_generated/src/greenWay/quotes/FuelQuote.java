package greenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class FuelQuote {
    private static int hc = 0;
    private static FuelQuote instance = null;

    public FuelQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static FuelQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new FuelQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof FuelQuote;
    }

    public String toString() {
        return "<Fuel>";
    }
}
