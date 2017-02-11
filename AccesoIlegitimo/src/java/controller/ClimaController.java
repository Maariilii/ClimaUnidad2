/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClimaDAO;
import dao.ClimaDAOImp;
import model.Clima;

/**
 *
 * @author Marili
 */
public class ClimaController extends HttpServlet {
    
     
    private static final String LISTA_CLIMA = "/listarClima.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/climas.jsp";
    private ClimaDAO dao;
    
    public ClimaController() {
        dao = new  ClimaDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_CLIMA;
            
            
            int id = Integer.parseInt(request.getParameter("id"));
            dao.borrarClima(id);
            request.setAttribute("climas", dao.desplegarClima());
            
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int id = Integer.parseInt(request.getParameter("id"));
            Clima clima = dao.elegirClima(id);
            request.setAttribute("clima", clima);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_CLIMA;
            request.setAttribute("climas", dao.desplegarClima());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Clima clima = new Clima();
        String id = request.getParameter("id");
        clima.setState(request.getParameter("state")); 
        clima.setVestimenta(request.getParameter("vestimenta"));
        clima.setEstacionAno(request.getParameter("estacionAno"));
        
        
        if (id == null || id.isEmpty()) {
            dao.agregarClima(clima);
        } else {
            clima.setId(Integer.parseInt(id));
            dao.cambiarClima(clima);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIMA);
        request.setAttribute("climas", dao.desplegarClima());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}
