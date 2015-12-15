package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Device {
    public static VDMSet warns = SetUtil.set();
    public Number wcount = warns.size();
    public String plate;
    public Number cardN;
    public Object status = greenWay.quotes.DisableQuote.getInstance();
    public Number moneyDep;
    public VDMMap monthBill = MapUtil.map(new Maplet(1L, 0L),
            new Maplet(2L, 0L), new Maplet(3L, 0L), new Maplet(4L, 0L),
            new Maplet(5L, 0L), new Maplet(6L, 0L), new Maplet(7L, 0L),
            new Maplet(8L, 0L), new Maplet(9L, 0L), new Maplet(10L, 0L),
            new Maplet(11L, 0L), new Maplet(12L, 0L));

    public Device(final String vp, final Number nc, final Number md) {
        cg_init_Device_1(vp, nc, md);
    }

    public Device() {
    }

    public void cg_init_Device_1(final String vp, final Number nc,
        final Number md) {
        plate = vp;
        cardN = nc;
        moneyDep = md;

        return;
    }

    public void setStatus(final Object stat) {
        status = stat;
    }

    public void setMonthBill(final Number m, final Number q) {
        Utils.mapSeqUpdate(monthBill, m, q);
    }

    public void newWarning(final Warning w) {
        warns = SetUtil.union(SetUtil.set(w), Utils.copy(warns));
        wcount = wcount.longValue() + 1L;
        IO.println("New warning registed!");
    }

    public void newMonthPayment(final Number m, final Number b) {
        Utils.mapSeqUpdate(monthBill, m,
            ((Number) Utils.get(monthBill, m)).doubleValue() + b.doubleValue());
    }

    public void addDeposit(final Number d) {
        moneyDep = moneyDep.doubleValue() + d.doubleValue();
    }

    public void subDeposit(final Number d) {
        moneyDep = moneyDep.doubleValue() - d.doubleValue();
    }

    public String toString() {
        return "Device{" + "warns := " + Utils.toString(warns) +
        ", wcount := " + Utils.toString(wcount) + ", plate := " +
        Utils.toString(plate) + ", cardN := " + Utils.toString(cardN) +
        ", status := " + Utils.toString(status) + ", moneyDep := " +
        Utils.toString(moneyDep) + ", monthBill := " +
        Utils.toString(monthBill) + "}";
    }
}
