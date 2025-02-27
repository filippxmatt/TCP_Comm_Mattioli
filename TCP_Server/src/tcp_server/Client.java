/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_server;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Mattioli
 */
public class Client implements Runnable{

    String nome;
    String colore;
    Socket socket;
    String nomeServer;
    int porta;
    public static final String PURPLE = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";


    public Client(String nome, String nomeServer, int porta){
        this.nome = nome;
        this.nomeServer=nomeServer;
        this.porta=porta;

    }

    @Override
    public void run(){
        connetti(nomeServer, porta);
        scrivi();
        leggi();
        chiudi();
    }

    public void connetti(String S, int portaServer){
        try {
            socket = new Socket(S, portaServer);
            System.out.println(PURPLE+"Connessione al server avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(GREEN+"Errore: Connessione con server non avvenuta");
        }

    }
    public void leggi() {
        InputStream i;
        BufferedReader br;
        String mess;

        try {
            i=socket.getInputStream();
            br=new BufferedReader(new InputStreamReader(i));
            mess=br.readLine();
            System.out.println("Ricevuto il messaggio: "+mess);
        } catch(IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Messaggio non ricevuto");
        }
    }

    public void scrivi() {
        String mess;
        BufferedReader br;
        System.out.println("Messaggio da inserire al server: \n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            mess=br.readLine();
        } catch (IOException e) {
            System.err.println("Errore nell'inserimento del messaggio");
        }


    }

    public void chiudi() {
        if (socket!=null) {
            try {
                socket.close();
                System.out.println("\n Chiusura socket avvenuta");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura con il client");
            }
        } else {
            System.out.println("Il Socket non è stato istanziato");
        }
    }
}