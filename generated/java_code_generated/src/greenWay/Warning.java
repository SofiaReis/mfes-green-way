package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Warning {
    public String type;

    public Warning(final String t) {
        cg_init_Warning_1(t);
    }

    public Warning() {
    }

    public void cg_init_Warning_1(final String t) {
        type = t;

        return;
    }

    public String toString() {
        return "Warning{" + "type := " + Utils.toString(type) + "}";
    }
}
