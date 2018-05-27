package com.testrtc.api.exceptions;

import com.testrtc.api.domObjects.error.TestRTCError;
import lombok.ToString;


public class TestRTCExcepction extends Exception {

    public int code=0;



    public TestRTCExcepction(TestRTCError error){
        super(error.message);
        if(error.code!=null){
            this.code=error.code;
        }
    }

    public TestRTCExcepction(String message){
        super(message);
    }

    @Override
    public String toString(){

       return "Code:"+code+ " Message:"+getMessage();
    }
}
