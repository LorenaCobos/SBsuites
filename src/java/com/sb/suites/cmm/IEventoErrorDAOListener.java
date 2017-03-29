/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sb.suites.cmm;

import java.util.EventListener;

/**
 *
 * @author fabiam molar
 */
public interface IEventoErrorDAOListener extends EventListener {
    void capturarEventoErrorDAO( EventoError evt ) throws ExceptionCmm;
}
