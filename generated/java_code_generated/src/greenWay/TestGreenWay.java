package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class TestGreenWay extends MyTestCase {
    public TestGreenWay() {
    }

    public void Run() {
        deviceRegist();
        serviceRegist();
        depositar();
        transferToGreenWay();
        registReadPoints();
        changeQuota();
        checkPlate();
        checkPaymentForGW();
        checkStatusAddingReadPoint();
        checkLocationServiceAndRP();
        checkInvoiceFromOtherMonth();
        registDev();
    }

    public void deviceRegist() {
        GreenWay gw = null;
        Device d1 = null;
        Device d2 = null;
        IO.println("---Test : Create Device ---");
        gw = new GreenWay();
        d1 = new Device("00-BF-34", 107893789L, 1500L);
        d2 = new Device("01-FF-34", 107835628L, 2000L);
        gw.newDevice(d1);
        super.assertTrue(Utils.equals(gw.devicesCount, 1L));
        gw.newDevice(d2);
        super.assertTrue(Utils.equals(gw.devicesCount, 2L));
    }

    public void serviceRegist() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        ServiceProvider s2 = null;
        IO.println("---Test : Create Service ---");
        gw = new GreenWay();
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        s2 = new ServiceProvider(greenWay.quotes.ParkingLotQuote.getInstance(),
                10.59, 4.65);
        gw.newServiceProvider(s1);
        super.assertTrue(Utils.equals(gw.servicesCount, 1L));
        gw.newServiceProvider(s2);
        super.assertTrue(Utils.equals(gw.servicesCount, 2L));
    }

    public void depositar() {
        Device d1 = null;
        IO.println("---Test : Deposite ---");
        d1 = new Device("00-BF-34", 107893789L, 1500L);
        d1.addDeposit(500L);
        super.assertTrue(Utils.equals(d1.moneyDep, 2000L));
    }

    public void transferToGreenWay() {
        GreenWay gw = null;
        Device d1 = null;
        IO.println("---Test : Transfer ---");
        d1 = new Device("00-BF-34", 107893789L, 1500L);
        gw = new GreenWay();
        gw.newDevice(d1);
        d1.newMonthPayment(2L, 750L);
        super.assertTrue(Utils.equals(((Number) Utils.get(d1.monthBill, 2L)),
                750L));
        gw.recPayment(d1, 2L);
        d1.subDeposit(750L);
        super.assertTrue(Utils.equals(gw.total, 750L));
        super.assertTrue(Utils.equals(((Number) Utils.get(d1.monthBill, 2L)), 0L));
        super.assertTrue(Utils.equals(d1.moneyDep, 750L));
    }

    public void registReadPoints() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        ServiceProvider s2 = null;
        Device d1 = null;
        Device d2 = null;
        Date dat1 = null;
        Date dat2 = null;
        ReadPoint rd1 = null;
        ReadPoint rd2 = null;
        Invoice iv1 = null;
        IO.println("---Test : Regist Read Points ---");
        gw = new GreenWay();
        d1 = new Device("00-BF-34", 107893789L, 1500L);
        d2 = new Device("10-FF-34", 107723682L, 2000L);
        gw.newDevice(d1);
        gw.newDevice(d2);
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        s2 = new ServiceProvider(greenWay.quotes.ParkingLotQuote.getInstance(),
                10.59, 4.65);
        gw.newServiceProvider(s1);
        gw.newServiceProvider(s2);
        dat1 = new Date(14L, 12L, 2015L, 21L, 35L, 39L);
        dat2 = new Date(14L, 12L, 2015L, 21L, 40L, 40L);
        rd1 = new ReadPoint(s1, 10L, d1, dat1, 1.89, 2.83, "00-BF-34");
        rd2 = new ReadPoint(s2, 15L, d1, dat2, 10.59, 4.65, "00-BF-34");
        iv1 = new Invoice(12L, d1);
        iv1.newPassage(rd1);
        iv1.newPassage(rd2);
        super.assertTrue(Utils.equals(iv1.passagesCount, 2L));
        super.assertTrue(Utils.equals(iv1.total, 25L));
    }

    public void changeQuota() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        Device d1 = null;
        Date dat1 = null;
        ReadPoint rd1 = null;
        IO.println("---Test : Change Quota ---");
        gw = new GreenWay();
        d1 = new Device("00-BF-34", 107893789L, 1500L);
        gw.newDevice(d1);
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        gw.newServiceProvider(s1);
        dat1 = new Date(14L, 12L, 2015L, 21L, 35L, 39L);
        rd1 = new ReadPoint(s1, 10L, d1, dat1, 1.89, 2.83, "00-BF-34");
        rd1.setQuota(20L);
        super.assertTrue(Utils.equals(rd1.quota, 20L));
    }

    public void checkPlate() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        Device d1 = null;
        Date dat1 = null;
        ReadPoint rd1 = null;
        IO.println("---Test : Check Plate ---");
        gw = new GreenWay();
        d1 = new Device("00-FF-34", 107893789L, 1500L);
        gw.newDevice(d1);
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        gw.newServiceProvider(s1);
        dat1 = new Date(14L, 12L, 2015L, 21L, 35L, 39L);
        rd1 = new ReadPoint(s1, 10L, d1, dat1, 1.89, 2.83, "00-BF-34");
    }

    public void checkPaymentForGW() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        ServiceProvider s2 = null;
        Device d1 = null;
        Date dat1 = null;
        Date dat2 = null;
        ReadPoint rd1 = null;
        ReadPoint rd2 = null;
        Invoice iv1 = null;
        IO.println("---Test : Possible or not possible Transfer for gw ---");
        gw = new GreenWay();
        d1 = new Device("00-BF-34", 107893789L, 10L);
        gw.newDevice(d1);
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        s2 = new ServiceProvider(greenWay.quotes.ParkingLotQuote.getInstance(),
                10.59, 4.65);
        gw.newServiceProvider(s1);
        gw.newServiceProvider(s2);
        dat1 = new Date(14L, 12L, 2015L, 21L, 35L, 39L);
        dat2 = new Date(14L, 12L, 2015L, 21L, 40L, 40L);
        rd1 = new ReadPoint(s1, 10L, d1, dat1, 1.89, 2.83, "00-BF-34");
        rd2 = new ReadPoint(s2, 15L, d1, dat2, 10.59, 4.65, "00-BF-34");
        iv1 = new Invoice(12L, d1);
        iv1.newPassage(rd1);
        iv1.newPassage(rd2);
        iv1.payment(12L, iv1.total);
        super.assertTrue(Utils.equals(d1.moneyDep, 10L));
        super.assertTrue(Utils.equals(((Number) Utils.get(d1.monthBill, 12L)),
                25L));
        gw.recPayment(d1, 12L);
        super.assertTrue(Utils.equals(d1.status,
        		greenWay.quotes.DisableQuote.getInstance()));
    }

    public void checkStatusAddingReadPoint() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        Device d1 = null;
        Date dat1 = null;
        ReadPoint rd1 = null;
        IO.println("---Test : Check Status Disable when add Read Point ---");
        gw = new GreenWay();
        d1 = new Device("00-FF-34", 107893789L, 1500L);
        gw.newDevice(d1);
        d1.setStatus(greenWay.quotes.DisableQuote.getInstance());
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        gw.newServiceProvider(s1);
        dat1 = new Date(14L, 12L, 2015L, 21L, 35L, 39L);
        rd1 = new ReadPoint(s1, 10L, d1, dat1, 1.89, 2.83, "00-BF-34");
    }

    public void checkLocationServiceAndRP() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        Device d1 = null;
        Date dat1 = null;
        ReadPoint rd1 = null;
        IO.println("---Test : Check Location Service and RP ---");
        gw = new GreenWay();
        d1 = new Device("00-FF-34", 107893789L, 1500L);
        gw.newDevice(d1);
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        gw.newServiceProvider(s1);
        dat1 = new Date(14L, 12L, 2015L, 21L, 35L, 39L);
        rd1 = new ReadPoint(s1, 10L, d1, dat1, 1.8, 2.84, "00-FF-34");
    }

    public void checkInvoiceFromOtherMonth() {
        GreenWay gw = null;
        ServiceProvider s1 = null;
        Device d1 = null;
        Date dat1 = null;
        ReadPoint rd1 = null;
        Invoice iv1 = null;
        IO.println("---Test : Check Invoice From Other Month ---");
        gw = new GreenWay();
        d1 = new Device("00-FF-34", 107893789L, 1500L);
        gw.newDevice(d1);
        s1 = new ServiceProvider(greenWay.quotes.HighWayQuote.getInstance(),
                1.89, 2.83);
        gw.newServiceProvider(s1);
        dat1 = new Date(14L, 11L, 2015L, 21L, 35L, 39L);
        rd1 = new ReadPoint(s1, 10L, d1, dat1, 1.89, 2.83, "00-FF-34");
        iv1 = new Invoice(12L, d1);
    }

    public void registDev() {
        GreenWay gw = null;
        Device d1 = null;
        Device d2 = null;
        IO.println("---Test : Regist Device ---");
        gw = new GreenWay();
        d1 = new Device("00-BF-34", 107893789L, 1500L);
        d2 = new Device("01-FF-34", 107835628L, 2000L);
    }

    public String toString() {
        return "TestGreenWay{}";
    }
}
