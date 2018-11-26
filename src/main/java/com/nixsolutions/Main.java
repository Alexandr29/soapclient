package com.nixsolutions;


import com.nixsolutions.webservice.SoapWebService;
import com.nixsolutions.webservice.User;
import com.nixsolutions.webservice.UserOperations;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        SoapWebService webService = new SoapWebService();
        UserOperations userOperations = webService.getSoapControllerUserPort();
        List<User> users = userOperations.findAll();

        for (User u : users) {
            System.out.println(u.getLogin());
        }
    }

}
