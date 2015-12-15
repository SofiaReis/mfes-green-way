package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class ServiceProvider {
    public Object type = greenWay.quotes.NoneQuote.getInstance();
    public Number xs;
    public Number ys;

    public ServiceProvider(final Object t, final Number x, final Number y) {
        cg_init_ServiceProvider_1(((Object) t), x, y);
    }

    public ServiceProvider() {
    }

    public void cg_init_ServiceProvider_1(final Object t, final Number x,
        final Number y) {
        type = t;
        xs = x;
        ys = y;
    }

    public String toString() {
        return "ServiceProvider{" + "type := " + Utils.toString(type) +
        ", xs := " + Utils.toString(xs) + ", ys := " + Utils.toString(ys) +
        "}";
    }
}
