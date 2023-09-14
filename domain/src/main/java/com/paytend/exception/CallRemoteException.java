package com.paytend.exception;

import sun.awt.CausedFocusEvent;

/**
 * @author Sunny
 * @create 2023/9/12 14:17
 */
public class CallRemoteException extends RuntimeException {

    public CallRemoteException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
