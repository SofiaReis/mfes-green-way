package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GreenWay {
    public static VDMSet gwdevices = SetUtil.set();
    public static VDMSet gwservices = SetUtil.set();
    public Number devicesCount = gwdevices.size();
    public Number servicesCount = gwservices.size();
    public Number total;

    public GreenWay() {
        cg_init_GreenWay_1();
    }

    public void cg_init_GreenWay_1() {
        total = 0L;

        return;
    }

    public void newDevice(final Device device) {
        gwdevices = SetUtil.union(SetUtil.set(device), Utils.copy(gwdevices));
        devicesCount = devicesCount.longValue() + 1L;
        device.setStatus(greenWay.quotes.AbleQuote.getInstance());
        IO.println("New device registed!");
    }

    public void newServiceProvider(final ServiceProvider service) {
        gwservices = SetUtil.union(SetUtil.set(service), Utils.copy(gwservices));
        servicesCount = servicesCount.longValue() + 1L;
        IO.println("New service registed!");
    }

    public void recPayment(final Device d, final Number m) {
        if ((d.moneyDep.doubleValue() -
                ((Number) Utils.get(d.monthBill, m)).doubleValue()) < 0L) {
            d.setStatus(greenWay.quotes.DisableQuote.getInstance());
        } else {
            total = total.doubleValue() +
                ((Number) Utils.get(d.monthBill, m)).doubleValue();
            d.setMonthBill(m, 0L);
            d.setStatus(greenWay.quotes.AbleQuote.getInstance());
        }
    }

    public String toString() {
        return "GreenWay{" + "gwdevices := " + Utils.toString(gwdevices) +
        ", gwservices := " + Utils.toString(gwservices) + ", devicesCount := " +
        Utils.toString(devicesCount) + ", servicesCount := " +
        Utils.toString(servicesCount) + ", total := " + Utils.toString(total) +
        "}";
    }
}
