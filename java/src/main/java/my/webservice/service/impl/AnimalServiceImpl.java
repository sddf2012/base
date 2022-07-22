package my.webservice.service.impl;

import my.domain.Cat;
import my.webservice.service.AnimalService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author liu peng bo
 * @date 2022-7-15 14:50
 */
@WebService(name = "Animal",serviceName = "AnimalWebService",portName = "AnimalPort",endpointInterface = "my.webservice.service.AnimalService")
public class AnimalServiceImpl implements AnimalService {
    @Override
    public Cat getCat(String id) {
        return new Cat("tom","male",2);
    }
}
