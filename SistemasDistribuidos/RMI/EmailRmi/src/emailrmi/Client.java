/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emailrmi;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author laboratorio
 */
public class Client {

    public static void main(String[] args) {

        try {
            IGeraDados g = (IGeraDados) Naming.lookup("rmi://localhost/Gerador");
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o nome completo: ");
            String nome = sc.nextLine();

            System.out.println("\nE-mail gerado: " + g.gerarEmail(nome));
            System.out.println("Hash gerado: " + g.gerarHash(nome));

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}