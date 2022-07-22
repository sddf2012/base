package my.webservice;

import my.webservice.service.impl.AnimalServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @author liu peng bo
 * @date 2022-7-15 14:48
 */
public class WebServicePublish {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8000/ws/animal",new AnimalServiceImpl());
    }
}
