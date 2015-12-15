package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Invoice {
    public static VDMSet passages = SetUtil.set();
    public Number passagesCount = passages.size();
    public Number month;
    public Number total;
    public Device device;

    public Invoice(final Number m, final Device d) {
        cg_init_Invoice_1(m, d);
    }

    public Invoice() {
    }

    public void cg_init_Invoice_1(final Number m, final Device d) {
        total = 0L;
        month = m;
        device = d;
    }

    public void newPassage(final ReadPoint rp) {
        if (Utils.equals(rp.ok, 1L)) {
            if (Utils.equals(rp.date.month, month)) {
                passages = SetUtil.union(SetUtil.set(rp), Utils.copy(passages));
                passagesCount = passagesCount.longValue() + 1L;
                total = rp.quota.doubleValue() + total.doubleValue();
                IO.println("New Passage registed!");
            } else {
                IO.println("This facture is from another month.");
            }
        } else {
            IO.println("Passage not accepted!");
        }
    }

    public void payment(final Number m, final Number t) {
        device.newMonthPayment(m, t);
        IO.println("Your total Payment of this month!");
    }

    public String toString() {
        return "Invoice{" + "passages := " + Utils.toString(passages) +
        ", passagesCount := " + Utils.toString(passagesCount) + ", month := " +
        Utils.toString(month) + ", total := " + Utils.toString(total) +
        ", device := " + Utils.toString(device) + "}";
    }
}
