package com.example.service;

import javax.ejb.Stateless;

/**
 * @author Vorobyev Vyacheslav
 */
@Stateless(name = "clusterTest")
public class ClusterTest {

    public String getServerName() {
        return System.getProperty("server.name");
    }
}
