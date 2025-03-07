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
public class  Client {

    String nome;
    String colore;
    Socket socket;
    public static final String PURPLE = "\u001B[35m";
    public static final String RED = "\u001B[31m";


    public Client(String nome){
        this.nome = nome;
        this.colore = colore;

    }

    public void connetti(String S, int portaServer){
        try {
            socket = new Socket(S, portaServer);
            System.out.println(PURPLE+"Connessione al server avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(RED+"Errore: Connessione con server non avvenuta");
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
            System.err.println(RED+"Errore: Messaggio non ricevuto");
        }
    }

    public void scrivi() {
        OutputStream os;
        BufferedWriter bw;
        String mess="Client attivo";
        try{
            os=socket.getOutputStream();
            bw=new BufferedWriter(new OutputStreamWriter(os));
            bw.write(mess+"\n");
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chiudi() {
        if (socket!=null) {
            try {
                socket.close();
                System.out.println("\n Chiusura socket avvenuta");
            } catch (IOException e) {
                System.err.println(RED+"Errore nella chiusura con il client");
            }
        } else {
            System.out.println(RED+"Il Socket non è stato istanziato");
        }
    }
}