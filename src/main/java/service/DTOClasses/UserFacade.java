/*
 * Copyright © 2019 Jonathan Martin, Nicolas Waguet, Nils Karbstein
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package service.DTOClasses;

import dhbwka.wwi.vertsys.javaee.jproject.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.jproject.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.jproject.tasks.ejb.TaskBean;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nils
 */

@Stateless
public class UserFacade {


    @EJB
    private UserBean userBean;


    public List<UserDTO> getAll(){    

      List<User> users = userBean.findAll();


      return users.stream().map((user) -> {

            UserDTO userdto = new UserDTO(user);



            return userdto;

           
        }).collect(Collectors.toList());

    }

}

