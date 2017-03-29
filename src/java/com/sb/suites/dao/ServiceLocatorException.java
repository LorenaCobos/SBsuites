/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.dao;

/**
 *
 * @author fabiam molar
 */
public class ServiceLocatorException extends RuntimeException {

    public ServiceLocatorException() {}
    public ServiceLocatorException(String msg) { super(msg); }
    public ServiceLocatorException(String msg, Throwable cause) { super(msg, cause); }
    public ServiceLocatorException(Throwable cause) { super(cause); }

}
