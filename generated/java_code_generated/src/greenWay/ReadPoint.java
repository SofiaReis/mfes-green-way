package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class ReadPoint {
    public Number quota;
    public ServiceProvider service;
    public Device device;
    public Date date;
    public Number xr;
    public Number yr;
    public Warning w1;
    public String plate;
    public Number ok;

    public ReadPoint(final ServiceProvider s, final Number q, final Device d,
        final Date dat, final Number x, final Number y, final String p) {
        cg_init_ReadPoint_1(s, q, d, dat, x, y, p);
    }

    public ReadPoint() {
    }

    public void cg_init_ReadPoint_1(final ServiceProvider s, final Number q,
        final Device d, final Date dat, final Number x, final Number y,
        final String p) {
        service = s;
        quota = q;
        device = d;
        date = dat;
        xr = x;
        yr = y;
        plate = p;
        verifyDevice(d);

        return;
    }

    public void setQuota(final Number q) {
        quota = q;
    }

    public void verifyDevice(final Device d) {
        Boolean orResult_1 = false;

        if (Utils.equals(d.status, greenWay.quotes.DisableQuote.getInstance())) {
            orResult_1 = true;
        } else {
            orResult_1 = !(SetUtil.inSet(d, GreenWay.gwdevices));
        }

        if (orResult_1) {
            IO.println("Device disabled using services");
            w1 = new Warning("Device disabled using services");
            d.newWarning(w1);
            ok = 0L;
        } else {
            Boolean andResult_2 = false;

            if (!(Utils.equals(service.xs, xr))) {
                if (!(Utils.equals(service.ys, yr))) {
                    andResult_2 = true;
                }
            }

            if (andResult_2) {
                IO.println(
                    "The service Provider is not in the same place as the read point");
                w1 = new Warning(
                        "The service Provider is not in the same place as the read point");
                d.newWarning(w1);
                ok = 0L;
            } else {
                if (!(Utils.equals(d.plate, plate))) {
                    IO.println("Device plate different than read plate");
                    w1 = new Warning("Device plate different than read plate");
                    d.newWarning(w1);
                    ok = 0L;
                } else {
                    IO.println("Tudo OK!");
                    ok = 1L;
                }
            }
        }
    }

    public String toString() {
        return "ReadPoint{" + "quota := " + Utils.toString(quota) +
        ", service := " + Utils.toString(service) + ", device := " +
        Utils.toString(device) + ", date := " + Utils.toString(date) +
        ", xr := " + Utils.toString(xr) + ", yr := " + Utils.toString(yr) +
        ", w1 := " + Utils.toString(w1) + ", plate := " +
        Utils.toString(plate) + ", ok := " + Utils.toString(ok) + "}";
    }
}
