/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_2;

import java.util.List;

/**
 *
 * @author USER
 */
public interface RepositoryInterface {
    List<Person> getPersons();
    Person getPersonById(int id);
    List<Domain> getDomains();
    List<Domain> getDomainByPerson(Person person);
    
}
