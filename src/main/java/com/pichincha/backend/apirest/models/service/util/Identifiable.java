/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pichincha.backend.apirest.models.service.util;

import java.io.Serializable;

/**
 *
 * @author user
 */
public interface Identifiable<T extends Serializable> {
    T getId();
}
