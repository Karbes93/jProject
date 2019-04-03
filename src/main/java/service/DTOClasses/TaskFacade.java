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

import dhbwka.wwi.vertsys.javaee.jproject.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.jproject.tasks.jpa.Task;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nils
 */
@Stateless
public class TaskFacade {
        @EJB
    private TaskBean taskBean;


    public List<TaskDTO> getAll(){    

      List<Task> tasks = taskBean.findAll();


      return tasks.stream().map((task) -> {

            TaskDTO taskdto = new TaskDTO(task);



            return taskdto;

           
        }).collect(Collectors.toList());

    }
}
