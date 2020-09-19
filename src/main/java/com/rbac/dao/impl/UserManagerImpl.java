package com.rbac.dao.impl;

import com.rbac.constants.BusinessConstants;
import com.rbac.dao.UserManager;
import com.rbac.exception.BusinessException;
import com.rbac.model.Person;

import java.util.HashMap;
import java.util.Map;

public class UserManagerImpl implements UserManager {
    private Map<String,Person> personMap=new HashMap<>();

    @Override
    public void createUser(Person person) {

       if(personMap.containsKey(person.getUserId())){
           throw new BusinessException(BusinessConstants.CUSTOMER_EXISTS.name(),BusinessConstants.CUSTOMER_EXISTS.getCode());
        }
        personMap.put(person.getUserId(),person);
    }

    @Override
    public Person getUser(String userId) {
        if(!personMap.containsKey(userId)){
            throw new BusinessException(BusinessConstants.CUSTOMER_NOT_EXISTS.name(),BusinessConstants.CUSTOMER_NOT_EXISTS.getCode());
        }
        return personMap.get(userId);
    }
}
