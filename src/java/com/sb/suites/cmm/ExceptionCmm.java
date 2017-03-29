/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.cmm;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author fabiam molar
 */
public class ExceptionCmm extends Exception{
    /**
     * default constructor
     */
    public ExceptionCmm() {
    }

    /**
     * ExceptionWrapper's reference an exception
     */
   protected Throwable _throwable = null;
   private int AuditoriaBssId;
   private int AuditoriaDaoId;
    
    

    /**
     * Constructs a default CommonException .
     * 
     * @param msg error message.
     */
    public ExceptionCmm(String msg) {
        _throwable = new Exception(msg);

    }

    public ExceptionCmm(String msg, Exception innerException) {
        _throwable = new Exception(msg, innerException);
    }
    /**
     * Constructs a default CommonException . *
     * 
     * @param throwable the throwable object to wrap.
     */
    public ExceptionCmm(Throwable throwable) {
            _throwable = throwable;
    }

    /**
     * Fills in the execution stack trace.
     * 
     * @return the stack trace for the wrapped throwable object.
     */
    @Override
    public Throwable fillInStackTrace() {
            if (_throwable == null) {
                    return super.fillInStackTrace();
            }
            return _throwable.fillInStackTrace();
    }

    /**
     * Creates a localized description of the wrapped throwable object.
     * 
     * @return the LocalizedMessage value.
     */
    @Override
    public String getLocalizedMessage() {
            return _throwable.getLocalizedMessage();
    }

    /**
     * Returns the error message string of the wrapped throwable object.
     * 
     * @return the Message value.
     */
    @Override
    public String getMessage() {
            return _throwable.getMessage();
    }

    /**
     * Returns the root cause of the exception.
     * 
     * @return The Root Cause
     */

    public Throwable getRootCause() {
            return _throwable;
    }

    @Override
    public Throwable getCause() {
        return _throwable.getCause();
    }

    /**
     * Prints the wrapped Throwable and its backtrace to the standard error
     * stream.
     */
    @Override
    public void printStackTrace() {
            _throwable.printStackTrace();
    }

    /**
     * Prints the wrapped throwable object and its backtrace to the specified
     * print stream.
     * 
     * @param stream the printstream to print to.
     */
    @Override
    public void printStackTrace(PrintStream stream) {
            _throwable.printStackTrace(stream);
    }

    /**
     * Prints the wrapped throwable object and its backtrace to the specified
     * print writer.
     * 
     * @param stream the printwriter to print to.
     */
    @Override
    public void printStackTrace(PrintWriter stream) {
            _throwable.printStackTrace(stream);
    }
    
    /**
     * @return the AuditoriaBssId
     */
    public int getAuditoriaBssId() {
        return AuditoriaBssId;
    }

    /**
     * @param AuditoriaBssId the AuditoriaBssId to set
     */
    public void setAuditoriaBssId(int AuditoriaBssId) {
        this.AuditoriaBssId = AuditoriaBssId;
    }

    /**
     * @return the AuditoriaDaoId
     */
    public int getAuditoriaDaoId() {
        return AuditoriaDaoId;
    }

    /**
     * @param AuditoriaDaoId the AuditoriaDaoId to set
     */
    public void setAuditoriaDaoId(int AuditoriaDaoId) {
        this.AuditoriaDaoId = AuditoriaDaoId;
    }
}
