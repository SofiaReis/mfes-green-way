package greenWay.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class ParkingLotQuote {
    private static int hc = 0;
    private static ParkingLotQuote instance = null;

    public ParkingLotQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static ParkingLotQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new ParkingLotQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof ParkingLotQuote;
    }

    public String toString() {
        return "<ParkingLot>";
    }
}
