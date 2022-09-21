/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_2;

import java.sql.Timestamp;

/**
 *
 * @author USER
 */
public class DomainTable {
    private Integer id;
    private String webname;
    private String domainname;
    private String ip;
    private Timestamp datereg;
    private String countryreg;
    private Person person;
    private String personname;
    private Integer idperson;

    public DomainTable(Integer id, String webname, String domainname, String ip, Timestamp datereg, String countryreg, Person person) {
        this.id = id;
        this.webname = webname;
        this.domainname = domainname;
        this.ip = ip;
        this.datereg = datereg;
        this.countryreg = countryreg;
        this.person = person;
        personname = person.getFirstnamelastname();
        idperson = person.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getDatereg() {
        return datereg;
    }

    public void setDatereg(Timestamp datereg) {
        this.datereg = datereg;
    }

    public String getCountryreg() {
        return countryreg;
    }

    public void setCountryreg(String countryreg) {
        this.countryreg = countryreg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }
    
    
    
}
