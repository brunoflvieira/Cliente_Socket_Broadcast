package Principal;

import java.net.*;
import java.io.*;
import javax.swing.*;

public class Principal {

    public static void main(String args[]) {
        try {
            DatagramSocket con = new DatagramSocket();//cria o objeto
            System.out.println("Inicio cliente");
            String mensagem = "";
            while (!mensagem.equals("fim")) {
                mensagem = JOptionPane.showInputDialog("Digite a Mensagem ou fim para sair");
//Converte a mensagem em um vetor de byte
                byte dado[] = mensagem.getBytes();
//Configura o pacote
                DatagramPacket pacote = new DatagramPacket(dado,
                        dado.length, InetAddress.getByName("localhost"), 4444);
                con.send(pacote); //envia o pacote
            }
        } catch (IOException io) {
            System.err.println("Problemas de IO");
        }
    }
}
