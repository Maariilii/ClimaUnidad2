/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Clima;
import util.UtilDB;


/**
 *
 * @author Marili
 */
public class ClimaDAOImp  implements  ClimaDAO{

    
    private Connection connection;
    
    public ClimaDAOImp() {
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarClima(Clima clima) {
         try {
             String query = "INSERT INTO clima(\n" +
"             state, vestimenta, estacion_ano)\n" +
"    VALUES ( ?, ?, ?);";
                    
                 
             
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, clima.getState());
            ps.setString(2, clima.getVestimenta());
            ps.setString(3, clima.getEstacionAno());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarClima(int id) {
        try {
            String query = "DELETE FROM clima WHERE "
                    + " id=?;";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarClima(Clima clima) {
        try {
            String query = "UPDATE clima\n"
                    + "   SET  state=?, vestimenta=?, estacion_ano=?\n"
                    + " WHERE id=?;";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, clima.getState());
            ps.setString(2, clima.getVestimenta());
            ps.setString(3, clima.getEstacionAno());
            ps.setInt(4, clima.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Clima> desplegarClima() {
        List<Clima> climas = new ArrayList<Clima>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM clima");
            while (rs.next()) {
                Clima clima = new Clima(rs.getInt("id"),
                        rs.getString("state"),
                        rs.getString("vestimenta"),
                        rs.getString("estacion_ano"));
        

                climas.add(clima);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return climas;
    }

    @Override
    public Clima elegirClima(int id) {
         Clima clima=null;
        try {
            String query = " SELECT * FROM clima WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                  clima = new Clima(
                        rs.getInt("id"),
                        rs.getString("state"),
                        rs.getString("vestimenta"),
                        rs.getString("estacion_ano"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clima;
       
    }
    
    
}
