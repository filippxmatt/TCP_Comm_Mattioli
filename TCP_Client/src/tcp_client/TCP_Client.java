/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_client;

/**
 *
 * @author Filippo Mattioi
 */
public class TCP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client c = new Client("Filippo");
        c.connetti("localhost", 2000);
        c.scrivi();
        c.leggi();
        c.chiudi();
    }
}