package greenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class McDriveQuote {
    private static int hc = 0;
    private static McDriveQuote instance = null;

    public McDriveQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static McDriveQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new McDriveQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof McDriveQuote;
    }

    public String toString() {
        return "<McDrive>";
    }
}
