/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import students.Student;

/**
 *
 * @author Hazal
 */
@Stateless
@CrossOrigin(origins = "http://localhost:8081")
@Path("students.student")
public class StudentFacadeREST extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "com.mycompany_Netas_staj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public StudentFacadeREST() {
        super(Student.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void create(Student entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void edit(@PathParam("id") Integer id, Student entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void remove(@PathParam("id") Integer id) {
        Student s = super.find(id);
        super.remove(s);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Student find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Student> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Student> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
