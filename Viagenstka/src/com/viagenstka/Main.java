package com.viagenstka;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.viagenstka.dao.PassagemDAO;
import com.viagenstka.dao.PessoaDAO;
import com.viagenstka.database.DatabaseConnection;
import com.viagenstka.model.Passagem;
import com.viagenstka.model.Pessoa;
import com.viagenstka.utils.Colors;

public class Main {

    public static void main(String[] args) {

        // CONEXÃO COM BANCO DE DADOS
        var connection = DatabaseConnection.createConnection();
        PessoaDAO pessoaDAO = new PessoaDAO(connection);

        // MENU PRINCIPAL
        Scanner scannerMenu = new Scanner(System.in);

        Scanner scannermainMenu = new Scanner(System.in);
        int mainMenu;

        do {
            System.out.println(Colors.YELLOW_BOLD.get() + "BEM VINDO AO SISTEMA - VIAGENSTKA");
            System.out.println("ESCOLHA UMA OPÇÃO:" + Colors.RESET.get());
            System.out.println(Colors.BLACK_BOLD.get() + "1. SISTEMA CLIENTE");
            System.out.println("2. SISTEMA PASSAGEM");
            System.out.println("0. SAIR DO SISTEMA");

            System.out.print("OPÇÃO: " + Colors.RESET.get());
            mainMenu = scannermainMenu.nextInt();
            scannermainMenu.nextLine();

            switch (mainMenu) {
                case 1:
                    showClienteMenu();
                    break;
                case 2:
                	showPassagemMenu();
                    break;
                case 0:
                    System.out.println(Colors.RED_BOLD.get() + "SAINDO DO SISTEMA." + Colors.RESET.get());
                    break;
                default:
                    System.out.println(Colors.RED_BOLD.get() + "OPÇÃO INVÁLIDA. TENTE NOVAMENTE." + Colors.RESET.get());
                    break;
            }
        } while (mainMenu != 0);

        scannermainMenu.close();
    }

    public static void showClienteMenu() {
        var connection = DatabaseConnection.createConnection();
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO(connection);
        Scanner scannerCliente = new Scanner(System.in);
        int mainMenuCliente = 0;

        do {
            System.out.println(Colors.YELLOW_BOLD.get() + "ESCOLHA UMA OPÇÃO:");
            System.out.println(Colors.BLACK_BOLD.get() + "1. CADASTRAR CLIENTE");
            System.out.println("2. EXCLUIR CLIENTE");
            System.out.println("3. ATUALIZAR CLIENTE");
            System.out.println("4. INFORMAÇÕES CLIENTE");
            System.out.println("0. VOLTAR AO MENU PRINCIPAL" + Colors.RESET.get());

            System.out.print(Colors.YELLOW_BOLD.get() + "OPÇÃO: " + Colors.RESET.get());
            mainMenuCliente = scannerCliente.nextInt();
            scannerCliente.nextLine();

            switch (mainMenuCliente) {
                case 1:
                    System.out.println("NOME COMPLETO DO CLIENTE: ");
                    pessoa.setNomeCompletoPessoa(scannerCliente.nextLine());
                    System.out.println("CPF DO CLIENTE: ");
                    pessoa.setCpfPessoa(scannerCliente.nextLine());
                    System.out.println("ENDEREÇO DO CLIENTE: ");
                    pessoa.setEndereçoPessoa(scannerCliente.nextLine());
                    System.out.println("TELEFONE DO CLIENTE: ");
                    pessoa.setTelefonePessoa(scannerCliente.nextLine());
                    System.out.println("RG DO CLIENTE: ");
                    pessoa.setRgPessoa(scannerCliente.nextLine());
                    pessoaDAO.criarPessoa(pessoa);

                    break;
                case 2:
                	System.out.println(Colors.BLACK_BOLD.get() + "DIGITE O ID DO CLIENTE PARA DELETAR DADOS: " + Colors.RESET.get());
                	int idPessoaExcluir = scannerCliente.nextInt();
                	pessoaDAO.deletarPessoa(idPessoaExcluir);
                    break;
                case 3:
                	Pessoa atualizarPessoa = new Pessoa();
                	System.out.println(Colors.BLACK_BOLD.get() + "DIGITE O ID DO CLIENTE PARA ATUALIZAR DADOS: " + Colors.RESET.get());
                	atualizarPessoa.setIdPessoa(scannerCliente.nextInt());
                	scannerCliente.nextLine(); 
                	System.out.println("NOME COMPLETO DO CLIENTE: ");
                	atualizarPessoa.setNomeCompletoPessoa(scannerCliente.nextLine());
                	System.out.println("CPF DO CLIENTE: ");
                	atualizarPessoa.setCpfPessoa(scannerCliente.nextLine());
                	System.out.println("ENDEREÇO DO CLIENTE: ");
                	atualizarPessoa.setEndereçoPessoa(scannerCliente.nextLine());
                	System.out.println("TELEFONE DO CLIENTE: ");
                	atualizarPessoa.setTelefonePessoa(scannerCliente.nextLine());
                	System.out.println("RG DO CLIENTE: ");
                	atualizarPessoa.setRgPessoa(scannerCliente.nextLine());

                	pessoaDAO.atualizarPessoa(atualizarPessoa);
                    break;
                case 4:
                    pessoaDAO.mostrarPessoa();
                    break;
                case 0:
                    System.out.println(Colors.RED_BOLD.get() + "SAINDO DO SISTEMA CLIENTE." + Colors.RESET.get());
                    return;
                default:
                    System.out.println(Colors.RED_BOLD.get() + "OPÇÃO INVÁLIDA. TENTE NOVAMENTE." + Colors.RESET.get());
                    break;
            }

        } while (mainMenuCliente != 0);
    }
    
    public static void showPassagemMenu() {
    	var connection = DatabaseConnection.createConnection();
    	Passagem passagem = new Passagem();
    	PassagemDAO passagemDAO = new PassagemDAO(connection);
        Scanner scannerPassagem = new Scanner(System.in);
        int mainMenuPassagem = 0;

        do {
            System.out.println(Colors.YELLOW_BOLD.get() + "ESCOLHA UMA OPÇÃO:");
            System.out.println(Colors.BLACK_BOLD.get() + "1. CRIAR PASSAGEM");
            System.out.println("2. DELETAR PASSAGEM");
            System.out.println("3. ATUALIZAR PASSAGEM");
            System.out.println("4. LISTAR PASSAGENS");
            System.out.println("0. VOLTAR AO MENU PRINCIPAL" + Colors.RESET.get());

            System.out.print(Colors.YELLOW_BOLD.get() + "OPÇÃO: " + Colors.RESET.get());
            mainMenuPassagem = scannerPassagem.nextInt();
            scannerPassagem.nextLine();

            switch (mainMenuPassagem) {
                case 1:
                    Passagem novaPassagem = new Passagem();

                    System.out.println("ID DO CLIENTE: ");
                    novaPassagem.setIdPessoa(scannerPassagem.nextInt());
                    scannerPassagem.nextLine();
                    System.out.println("DATA DA VIAGEM (FORMATO: DD/MM/YYYY HH:MM)");
                    String dataViagemString = scannerPassagem.nextLine();
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY HH:MM");
                        Date dataViagem = dateFormat.parse(dataViagemString);
                        novaPassagem.setDataViagemPassagem(new Timestamp(dataViagem.getTime()));
                    } catch (ParseException e) {
                        System.out.println(Colors.RED_BOLD.get() + "ERRO: DATA DA VIAGEM EM FORMATO INVÁLIDO." + Colors.RESET.get());
                        break;
                    }
                    System.out.println("PREÇO DA PASSAGEM: (FORMATO: 99.90)");
                    novaPassagem.setPrecoPassagem(Double.parseDouble(scannerPassagem.nextLine()));
                    System.out.println("DESTINO DA PASSAGEM: ");
                    novaPassagem.setDestinoPassagem(scannerPassagem.nextLine());
                    System.out.println("PREÇO PROMOCIONAL: ");
                    novaPassagem.setPrecoPromocionalPassagem(Double.parseDouble(scannerPassagem.nextLine()));
                    System.out.println("ASSENTO: ");
                    novaPassagem.setAssentoPassagem(scannerPassagem.nextLine());
                    System.out.println("ÔNIBUS: ");
                    novaPassagem.setOnibusPassagem(scannerPassagem.nextLine());
                    
                    passagemDAO.criarPassagem(novaPassagem);                
                    break;
                case 2:
                	System.out.println(Colors.BLACK_BOLD.get() + "DIGITE O ID DA PASSAGEM PARA DELETAR: " + Colors.RESET.get());
                	int idPassagemParaExcluir = scannerPassagem.nextInt();
                	passagemDAO.deletarPassagem(idPassagemParaExcluir);                	
                    break;
                case 3:
                	Passagem atualizarPassagem = new Passagem();

                	System.out.println(Colors.BLACK_BOLD.get() + "DIGITE O ID DA PASSAGEM PARA ATUALIZAR: " + Colors.RESET.get());
                	atualizarPassagem.setIdPassagem(scannerPassagem.nextInt());
                	scannerPassagem.nextLine();
                	System.out.println("DATA DA VIAGEM (FORMATO: DD/MM/YYYY HH:MM)");
                	String dataAtualizarString = scannerPassagem.nextLine();
                    try {
                        SimpleDateFormat dataFormato = new SimpleDateFormat("DD/MM/YYYY HH:MM");
                        Date dataViagem = dataFormato.parse(dataAtualizarString);
                        atualizarPassagem.setDataViagemPassagem(new Timestamp(dataViagem.getTime()));
                    } catch (ParseException e) {
                        System.out.println(Colors.RED_BOLD.get() + "ERRO: DATA DA VIAGEM EM FORMATO INVÁLIDO." + Colors.RESET.get());
                        break;
                    }
                	System.out.println("PREÇO DA PASSAGEM: ");
                	atualizarPassagem.setPrecoPassagem(Double.parseDouble(scannerPassagem.nextLine()));
                	System.out.println("DESTINO DA PASSAGEM: ");
                	atualizarPassagem.setDestinoPassagem(scannerPassagem.nextLine());
                	System.out.println("PREÇO PROMOCIONAL: ");
                	atualizarPassagem.setPrecoPromocionalPassagem(Double.parseDouble(scannerPassagem.nextLine()));
                	System.out.println("ASSENTO: ");
                	atualizarPassagem.setAssentoPassagem(scannerPassagem.nextLine());
                	System.out.println("ÔNIBUS: ");
                	atualizarPassagem.setOnibusPassagem(scannerPassagem.nextLine());
                	PassagemDAO passagemAtualizarDAO = new PassagemDAO(connection);
                	passagemAtualizarDAO.atualizarPassagem(atualizarPassagem);

                case 4: 
                	passagemDAO.mostrarPassagem();
                    break;
                case 0:
                    System.out.println(Colors.RED_BOLD.get() + "SAINDO DO SISTEMA PASSAGEM" + Colors.RESET.get());
                    return;
                default:
                    System.out.println(Colors.RED_BOLD.get() + "OPÇÃO INVÁLIDA. TENTE NOVAMENTE." + Colors.RESET.get());
                    break;
            }

        } while (mainMenuPassagem != 0);
    }

    private static void main(Object args) {
        // TODO Auto-generated method stub
    }
}