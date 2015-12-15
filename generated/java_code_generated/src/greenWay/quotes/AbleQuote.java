package greenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class AbleQuote {
    private static int hc = 0;
    private static AbleQuote instance = null;

    public AbleQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static AbleQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new AbleQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof AbleQuote;
    }

    public String toString() {
        return "<Able>";
    }
}
