package com.nixsolutions;

import com.nixsolutions.webservice.SoapControllerUserService;
import com.nixsolutions.webservice.User;
import com.nixsolutions.webservice.UserOperations;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class TestSoapControllerUser {
    protected UserOperations userOperations;
    protected SoapControllerUserService soapControllerUserService;
    User testUser;

    @BeforeEach
    public void setUp() throws DatatypeConfigurationException {
        soapControllerUserService = new SoapControllerUserService();
        userOperations = soapControllerUserService.getSoapControllerUserPort();
        testUser = new User();
        testUser.setLogin("login");
        testUser.setPassword("password");
        testUser.setEmail("a@hmail.com");
        testUser.setFirstName("name");
        testUser.setLastName("fname");
        testUser.setBirthday("2000-10-10");
        testUser.setRoleId(2L);
    }

    @Test
    public void getUsers() {
        Assertions.assertNotNull(userOperations.getUsers());
    }

    @Test
    public void getUser() {
        User user = userOperations.getUser(1L);
        Assertions.assertEquals("admin",user.getLogin());
    }

    @Test
    public void createUser(){
        int size = userOperations.getUsers().size();
        userOperations.createUser(testUser);
        Assertions.assertEquals(++size,userOperations.getUsers().size());
    }
    @Test
    public void removeUser(){
        User user = userOperations.getUser(11014L);
        userOperations.removeUser(user);
        Assertions.assertNull(userOperations.getUser(3L));
    }
    @Test
    public void updateUser(){
        User user = userOperations.getUser(11014L);
        user.setBirthday("1000-10-10");
        userOperations.updateUser(user);
        Assertions.assertNull(userOperations.getUser(3L));
    }

}
