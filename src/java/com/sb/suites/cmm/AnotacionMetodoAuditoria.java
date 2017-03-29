/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.cmm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author fabiam molar
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnotacionMetodoAuditoria {
  String Value();
}
