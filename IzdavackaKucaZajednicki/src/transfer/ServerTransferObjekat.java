/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author miljan
 */
public class ServerTransferObjekat implements Serializable{
    Object podaci;
    boolean signal;
    Object poruka;
    
    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public boolean isSignal() {
        return signal;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public Object getPoruka() {
        return poruka;
    }

    public void setPoruka(Object poruka) {
        this.poruka = poruka;
    }
    
}
