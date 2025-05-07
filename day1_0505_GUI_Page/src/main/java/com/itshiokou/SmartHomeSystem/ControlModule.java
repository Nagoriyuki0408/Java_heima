package com.itshiokou.SmartHomeSystem;

public class ControlModule {
    private static final ControlModule CONTROL_MODULE=new ControlModule();
    private ControlModule(){};
    public static ControlModule getInstance(){
        return  CONTROL_MODULE;
    }
    public void open(appliance a){
        a.status=true;
    }
    public void close(appliance a){
        a.status=false;
    }
    public void show_status(appliance a){
        System.out.println("The status of "+a.name+" is "+a.status);
    }
    public void show_all_status(appliance[] ae){
        for(appliance a:ae){
            System.out.println("The status of "+a.name+" is "+a.status);
        }
    }
}
