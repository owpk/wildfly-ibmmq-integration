package com.example.service;

import javax.ejb.Stateless;

/**
 * @author Vorobyev Vyacheslav
 */
@Stateless(name = "aliveInfoService")
public class AliveInfoService {

    public String getInfo(String message) {
        return "HELLO WORLD " + message;
    }
}
