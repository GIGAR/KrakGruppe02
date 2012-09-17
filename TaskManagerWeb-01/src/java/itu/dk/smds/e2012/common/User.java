/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dk.smds.e2012.common;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author GIGAR
 */
@XmlRootElement(name = "user")
public class User {
    public String name;
    public String password;
}
