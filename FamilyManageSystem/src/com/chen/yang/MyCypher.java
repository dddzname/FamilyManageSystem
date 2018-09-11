/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chen.yang;

import java.io.Serializable;

/**
 *
 * @author dugang
 */
public class MyCypher implements Serializable{
    private byte[] data;
    MyCypher(byte[] data){
        this.data=data;
    }

    /**
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(byte[] data) {
        this.data = data;
    }
    
}
