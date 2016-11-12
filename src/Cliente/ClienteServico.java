/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Mensagem.ChatMensagem;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bismark
 */
public class ClienteServico {
    
    private Socket socket;
    private ObjectOutputStream output;
  
    public Socket connect() {
            String ip = JOptionPane.showInputDialog("Entre com o IP do Servidor!");
            if(!ip.isEmpty()){
                try {
                    this.socket = new Socket(ip, 5555);
                    this.output = new ObjectOutputStream(socket.getOutputStream());
                } catch (UnknownHostException ex) {
                    Logger.getLogger(ClienteServico.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ClienteServico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.exit(0);
            }
        return socket;
    }
    public void send(ChatMensagem message) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
