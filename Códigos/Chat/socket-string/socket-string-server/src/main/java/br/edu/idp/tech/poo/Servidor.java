package br.edu.idp.tech.poo;

import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static Scanner scanner;

    public String entradaMensagem() {
        String msg = scanner.nextLine();
        return msg;
    }

    public void iniciar(int porta) {
        ObjectOutputStream saida;
        ObjectInputStream entrada;
        boolean sair = false;
        String mensagem = "";

        try {
            // criando um socket para ouvir na porta e com uma fila de tamanho 10
            ServerSocket servidor = new ServerSocket(porta, 10);
            Socket conexao;
            while (!sair) {
                System.out.println("Ouvindo na porta: " + porta);

                //ficarah bloqueado aqui ate' alguem cliente se conectar
                conexao = servidor.accept();

                System.out.println("Conexao estabelecida com: " + conexao.getInetAddress().getHostAddress());

                //obtendo os fluxos de entrada e de saida
                saida = new ObjectOutputStream(conexao.getOutputStream());
                entrada = new ObjectInputStream(conexao.getInputStream());

                //enviando a mensagem abaixo ao cliente
                saida.writeObject("Conexao estabelecida com sucesso...\nPrograma criado por Gabriel Queiroz Teles\n\n>> Eru Ilúvatar e Melkor são personagens criados pelo autor J.R.R. Tolkien\n\n");

                do {//fica aqui ate' o cliente enviar a mensagem FIM
                    try {
                        //obtendo a mensagem enviada pelo cliente
                        mensagem = (String) entrada.readObject();
                        System.out.println("Mensagem recebida do Eru:");
                        System.out.println("    >> " + mensagem);
                        System.out.print("Resposta para Melkor::: ");
                        saida.writeObject(entradaMensagem());
                    } catch (IOException iOException) {
                        System.err.println("erro: " + iOException.toString());
                    }
                } while (!mensagem.equals("FIM"));

                System.out.println("Conexao encerrada pelo cliente");
                sair = true;
                saida.close();
                entrada.close();
                conexao.close();

            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

    public static void main(String[] args) {
        int porta = -1;

        scanner = new Scanner(System.in);

        //verificando se foi informado 1 argumento de linha de comando
        if (args.length < 1) {
            System.err.println("Uso: java tcp.Servidor <porta>");
            System.exit(1);
        }

        try { // para garantir que somente inteiros serao atribuidos a porta

            porta = Integer.parseInt(args[0]);

        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            System.exit(1);
        }

        if (porta < 1024) {
            System.err.println("A porta deve ser maior que 1024.");
            System.exit(1);
        }

        Servidor s = new Servidor();
        s.iniciar(porta);

        scanner.close();
    }

}
