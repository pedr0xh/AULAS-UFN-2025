/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emailrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author laboratorio
 */
public interface IGeraDados extends Remote {
    public String gerarEmail(String nomeCompleto) throws RemoteException;
    public String gerarHash(String nomeCompleto) throws RemoteException;
}
