/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marili
 */
public class Clima {
    private int id;
    private String state;
    private String vestimenta;
    private String estacionAno;

    public Clima(int id, String state, String vestimenta, String estacionAno) {
        this.id = id;
        this.state = state;
        this.vestimenta = vestimenta;
        this.estacionAno = estacionAno;
    }
    public Clima(){
        this(0, "","","");
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(String vestimenta) {
        this.vestimenta = vestimenta;
    }

    public String getEstacionAno() {
        return estacionAno;
    }

    public void setEstacionAno(String estacionAno) {
        this.estacionAno = estacionAno;
    }

    @Override
    public String toString() {
        return "Clima{" + "id=" + id + ", state=" + state + ", vestimenta=" + vestimenta + ", estacionAno=" + estacionAno + '}';
    }
    
    
   
    
    
}
