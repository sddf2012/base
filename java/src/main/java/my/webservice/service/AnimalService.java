package my.webservice.service;


import my.domain.Cat;


/**
 * @author liu peng bo
 * @date 2022-7-15 14:49
 */
//@WebService
public interface AnimalService {
    //@WebMethod
    Cat getCat(String id);
}
