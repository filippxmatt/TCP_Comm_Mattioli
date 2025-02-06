/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

        
/**
 *
 * @author Filippo Mattioli
 */
public class Server {
    
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
    
    public Server(int porta){
        
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Il server è in ascolto");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Errore del server, nella fase di ascolto");
        }
    }
        
       public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Data Socket creato, connessione avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Problemi di connessione con il client");
            
        }
           return clientSocket;
           
       } 
        
       public void invia(){
           
           
       }
       
       public void ricevi(){
           
       }
       
       public void chiudi(){
           try {
               clientSocket.close();
               System.out.println("5) chiusura comunicazione con server");
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }
    }

