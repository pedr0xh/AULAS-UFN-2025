/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emailrmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author laboratorio
 */
public class Gerador extends UnicastRemoteObject implements IGeraDados {

    public Gerador() throws RemoteException {
        super();
    }

    @Override
    public String gerarEmail(String nomeCompleto) throws RemoteException {

        if(nomeCompleto == null || nomeCompleto.trim().isEmpty()){
            return "nome invalido";
        }
        String[] partes = nomeCompleto.trim().toLowerCase().split(" ");
        if(partes.length < 2 ){
            return "informe nome e sobrenome";
        }
       String nome = partes[0];
       String sobrenome = partes[partes.length-1];
       return nome + "." + sobrenome + "@ufn.edu.br";
    }

    @Override
    public String gerarHash(String nomeCompleto) throws RemoteException {
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(nomeCompleto.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RemoteException("Erro ao gerar hash", e);
        }
    }
    
}
