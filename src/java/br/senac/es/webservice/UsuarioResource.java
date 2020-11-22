/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.webservice;

import br.senac.es.dao.UsuarioDAO;
import br.senac.es.model.Usuario;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;
    /**
     * Creates a new instance of GenericResource
     */
    public UsuarioResource() {
    }

 
    @GET
    @Path("/login/{usuario}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)    
    public String login(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
        Gson g = new Gson();
       

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario u = usuarioDAO.getUsuarioByLoginAndSenha(usuario, senha);   
            
            return g.toJson(u);
            
        } catch (ClassNotFoundException | SQLException e) {
            String erro = e.getMessage();
            return g.toJson(erro);
        }
    }
    
    
    @GET
    @Path("/usuarios/{usuario}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)    
    public String lista(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
        Gson g = new Gson();
       

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario u = usuarioDAO.getUsuarioByLoginAndSenha(usuario, senha);  
            
            Usuario u2 = new Usuario();
            u2.setCodigo(10);
            u2.setLogin("funcionario");
            u2.setSenha("123");
            
            ArrayList<Usuario> lista = new ArrayList<>();
           
            
            lista.add(u);
            lista.add(u2);
            return g.toJson(lista);
            
        } catch (ClassNotFoundException | SQLException e) {
            String erro = e.getMessage();
            return g.toJson(erro);
        }
    }
 
}
