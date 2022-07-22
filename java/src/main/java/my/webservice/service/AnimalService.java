package my.webservice.service;


import my.domain.Cat;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author liu peng bo
 * @date 2022-7-15 14:49
 */
@WebService
public interface AnimalService {
    @WebMethod
    Cat getCat(String id);
}
