package com.or2go.volleylibrary;

import java.util.concurrent.Callable;

public abstract class CommApiCallback implements Callable<Void> {
    public Integer result;

    public String response;

    public void setResult (Integer result) {
        this.result = result;
    }

    public void setResponse(String res) { this.response = res;}

    public abstract Void call ();
}
