package com.testrtc.api.domObjects.testDefinition;

public class RunOption {
    private String option;
    private String value=null;

    public RunOption(String option,String value){
        this.option=option;
        this.value=value;
    }

    public RunOption(String option){
        this.option=option;
    }

    @Override
    public String toString(){
        if(value==null){
            return "#"+option;
        }
        return "#"+option+":"+value;
    }
}
