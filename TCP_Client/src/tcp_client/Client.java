/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Mattioli
 */
public class Client {
    
    String nome;
    String colore;
    Socket socket;
    
    public Client(String nome){
        this.nome = nome;
        this.colore = colore;
        
    }
    
    public void connetti(String S, int 1700){
        try {
            socket = new Socket(S, 1700);
            System.out.println("Connessione al server avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void leggi() {
    }

    public void scrivi() {
    }

    public void chiudi() {
        try {
            socket.close();
            System.out.println("4) chiusura comunicazione con server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
}
