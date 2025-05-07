package com.itshiokou.SmartHomeSystem;
public class Main {
    public static void main(String[] args) {
        boolean[] apps = {false, true};
        appliance[] ae = new appliance[3];
        ae[0] = new Chandelier("sam", false);
        ae[1] = new Washer("Bob", false);
        ae[2] = new Window("Lily", false);
        ControlModule CM = ControlModule.getInstance();
        CM.show_all_status(ae);
    }
}