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
    
    public void connetti(String S, int portaServer){
        try {
            socket = new Socket(S, 2000);
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
        if (socket!=null) {
            try {
                socket.close();
                System.out.println("Chiusura socket avvenuta");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura con il client");
            }
        } else {
            System.out.println("Il Socket non è stato istanziato");
        }
    }
    }