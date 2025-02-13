/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
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
        } catch(BindException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Un server è già in esecuzione sulla porta");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Errore del server, nella fase di ascolto");
        } catch(SecurityException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Non si ha il permesso ad accedere a serversocket");
        } catch(IllegalArgumentException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Il metodo ha ricevuto un parametro non valido");
        }
    }
        
       public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Data Socket creato, connessione avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Problemi di connessione con il client");
        } catch(SecurityException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Non si ha il permesso per accedere a socket");
        } /*catch(UnknownHostException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("IP host non individuabile");
        }*/catch(IllegalArgumentException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Il metodo ha ricevuto un parametro non valido");
        }


           return clientSocket;
           
       }

       public void leggi(){
        InputStream i;
        BufferedReader br;
        String mess;
          try {
            i=clientSocket.getInputStream();
            br=new BufferedReader(new InputStreamReader(i));
            mess=br.readLine();
            System.out.println("Ricevuto il messaggio: "+mess);
          } catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Messaggio non ricevuto");
          }

       }
        
       public void invia(){
           
           
       }
       
       public void ricevi(){

       }
       
       public void chiudi(){
           try {
               clientSocket.close();
               System.out.println("Chiusura socket con client avvenuta");
           } catch (IOException e) {
               System.err.println("Errore nella chiusura con il server");
           } catch(SecurityException e){
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
               System.err.println("Errore: Non si ha il permesso per accedere a chiudi");
           }
       }

       public void termina(){
        if (serverSocket!=null) {
            try {
                serverSocket.close();
                System.out.println("Chiusura socket server avvenuta");
            } catch (IOException e) {
                System.err.println("Il socket server non può terminarsi");
            }/*catch (NullPointerException e){
                System.err.println("");
            }*/catch(SecurityException e){
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
                System.err.println("Errore: Non si ha il permesso per accedere a termina");
            }
        } else{
            System.out.println("Non terminabile perché non istanziato");
        }
       }
    }

