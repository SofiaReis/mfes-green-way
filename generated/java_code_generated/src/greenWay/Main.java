package greenWay;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Main {
    public Main() {
    }

    public static void Run() {
        new TestGreenWay().Run();
    }

    public String toString() {
        return "Main{}";
    }

    public static void main(String[] args) {
        Run();
        IO.println(Utils.toString(Utils.VOID_VALUE));
    }
}
