import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Carro> carros = new ArrayList<>();
    private static List<Moto> motos = new ArrayList<>();
    private static List<Pessoa> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static List<Caminhao> caminhoes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        carregarDadosTeste();

        do {
            try {
                System.out.println("\n=== MENU DA CONCESSIONÁRIA ===");
                System.out.println("1 - Mostrar Veículos");
                System.out.println("2 - Comprar Veículo");
                System.out.println("3 - Vender Veículo");
                System.out.println("4 - Cadastrar Cliente");
                System.out.println("5 - Mostrar Clientes");
                System.out.println("6 - Gerar Relatório");
                System.out.println("7 - Sugerir Veículo por Biotipo");
                System.out.println("8 - Carregar Dados de Teste");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        mostrarVeiculos();
                        break;
                    case 2:
                        comprarVeiculo(scanner);
                        break;
                    case 3:
                        venderVeiculo(scanner);
                        break;
                    case 4:
                        cadastrarCliente(scanner);
                        break;
                    case 5:
                        mostrarClientesDetalhado();
                        break;
                    case 6:
                        gerarRelatorio();
                        break;
                    case 7:
                        sugerirVeiculoPorBiotipo(scanner);
                        break;
                    case 0:
                        System.out.println("Fechando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro entrada inválida, certifique-se de inserir os dados corretos");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro desconhecido" + e.getMessage());
            }
        } while (escolha != 0);

        scanner.close();
    }

    // implementacao para o exer 2!!!!!
    private static void mostrarClientesDetalhado() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n=== CLIENTES CADASTRADOS ===");
        System.out.println("Total de clientes: " + clientes.size());
        System.out.println("================================");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("\n--- CLIENTE " + (i + 1) + " ---");
            clientes.get(i).exibirInformacoes();
            System.out.println("--------------------------------");
        }
    }

    // ex4
    private static void sugerirVeiculoPorBiotipo(Scanner scanner) {
        try {
            if (clientes.isEmpty()) {
                throw new ClienteNaoEncontradoException("Nenhum cliente cadastrado para análise");
            }

            if (carros.isEmpty() && motos.isEmpty() && caminhoes.isEmpty()) {
                throw new VeiculoIndisponivelException("Nenhum veículo disponível para sugestão");
            }

            // Mostrar clientes
            System.out.println("\n=== SUGESTÃO DE VEÍCULO ===");
            mostrarClients();

            System.out.print("Escolha o cliente (número): ");
            int escolhaCliente = scanner.nextInt() - 1;
            scanner.nextLine();

            if (escolhaCliente < 0 || escolhaCliente >= clientes.size()) {
                throw new ClienteNaoEncontradoException("Cliente selecionado não existe");
            }

            Pessoa cliente = clientes.get(escolhaCliente);
            analisarESugerir(cliente);

        } catch (ClienteNaoEncontradoException e) {
            System.out.println(" ERRO - Cliente: " + e.getMessage());
        } catch (VeiculoIndisponivelException e) {
            System.out.println(" ERRO - Veículo: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("ERRO - Entrada inválida. Digite apenas números.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(" ERRO - Erro inesperado: " + e.getMessage());
        }
    }

    // ex4
    private static void analisarESugerir(Pessoa cliente) {
        System.out.println("\n=== ANÁLISE DO CLIENTE ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Idade: " + cliente.getIdade() + " anos");
        System.out.println("Altura: " + cliente.getAltura() + "m");
        System.out.println("Peso: " + cliente.getPeso() + "kg");

        // calcular IMC
        double imc = cliente.getPeso() / (cliente.getAltura() * cliente.getAltura());
        System.out.printf("IMC: %.1f\n", imc);

        System.out.println("\n=== SUGESTÕES PERSONALIZADAS ===");

        // simples de sugestão
        sugerirPorIdade(cliente);
        sugerirPorAltura(cliente);
        sugerirPorIMC(imc);

        System.out.println("\n=== VEÍCULOS RECOMENDADOS ===");
        mostrarVeiculosRecomendados(cliente, imc);
    }

    // ex4!1

    private static void sugerirPorIdade(Pessoa cliente) {
        int idade = cliente.getIdade();

        if (idade >= 18 && idade <= 25) {
            System.out.println("• Perfil jovem: Motos esportivas ou carros compactos");
        } else if (idade >= 26 && idade <= 40) {
            System.out.println("• Perfil adulto: Carros médios ou SUVs");
        } else if (idade >= 41 && idade <= 60) {
            System.out.println("• Perfil maduro: Carros confortáveis ou sedans");
        } else {
            System.out.println("• Perfil sênior: Carros automáticos e confortáveis");
        }
    }

    // ex 4

    private static void sugerirPorAltura(Pessoa cliente) {
        double altura = cliente.getAltura();

        if (altura < 1.60) {
            System.out.println("• Altura baixa: Carros compactos, evitar SUVs altos");
        } else if (altura >= 1.60 && altura <= 1.80) {
            System.out.println("• Altura média: Qualquer tipo de veículo");
        } else {
            System.out.println("• Altura alta: SUVs, carros espaçosos, evitar carros baixos");
        }
    }

    // ex4

    private static void sugerirPorIMC(double imc) {
        if (imc < 18.5) {
            System.out.println("• Biotipo magro: Motos ou carros compactos");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("• Biotipo normal: Qualquer tipo de veículo");
        } else if (imc >= 25.0 && imc <= 29.9) {
            System.out.println("• Biotipo robusto: Carros com bancos largos, SUVs");
        } else {
            System.out.println("• Biotipo grande: SUVs, carros espaçosos, evitar motos");
        }
    }

    // ex4 mostar os veiculos recomendados!!

    private static void mostrarVeiculosRecomendados(Pessoa cliente, double imc) {
        int idade = cliente.getIdade();
        double altura = cliente.getAltura();
        boolean temRecomendacao = false;

        if (!carros.isEmpty()) {
            System.out.println("\nCARROS RECOMENDADOS:");
            for (Carro carro : carros) {

                if ((idade >= 18 && idade <= 30) ||
                        (idade >= 31 && idade <= 50 && carro.getnPortas() == 4) ||
                        (altura >= 1.60 && altura <= 1.90) ||
                        (imc >= 18.5 && imc <= 35.0)) {

                    System.out.println(carro.getMarca() + " " + carro.getModelo() +
                            " (" + carro.getAno() + ") - R$ " + carro.getPreco());
                    temRecomendacao = true;
                }
            }
        }

        if (!motos.isEmpty()) {
            System.out.println("\nMOTOS RECOMENDADAS:");
            for (Moto moto : motos) {
                // Regras simples para motos
                if (idade >= 18 && idade <= 45 &&
                        altura >= 1.50 && altura <= 1.90 &&
                        imc >= 18.5 && imc <= 30.0) {

                    System.out.println(moto.getMarca() + " " + moto.getModelo() +
                            " (" + moto.getAno() + ") - R$ " + moto.getPreco());
                    temRecomendacao = true;
                }
            }
        }

        if (!caminhoes.isEmpty()) {
            System.out.println("\nCAMINHÕES RECOMENDADOS:");
            for (Caminhao caminhao : caminhoes) {
                // Regras simples para caminhões
                if (idade >= 25 && idade <= 65 &&
                        altura >= 1.65 &&
                        imc >= 20.0 && imc <= 35.0) {

                    System.out.println(caminhao.getMarca() + " " + caminhao.getModelo() +
                            " (" + caminhao.getAno() + ") - R$ " + caminhao.getPreco());
                    temRecomendacao = true;
                }
            }
        }

        // Mensagem caso nenhum veículo seja recomendado
        if (!temRecomendacao) {
            System.out.println("\nNenhum veículo específico recomendado para este perfil.");
            System.out.println("Sugerimos uma consulta personalizada com nossos vendedores!");
        }
    }

    private static void comprarVeiculo(Scanner scanner) {
        try {
            System.out.println("\n=== CADASTRO DE VEÍCULO ===");

            System.out.println("Qual veículo deseja cadastrar?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Caminhao");
            System.out.println("0 - Voltar ao Menu");
            System.out.print("Escolha: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 0)
                return;
            if (escolha > 3) {
                throw new InputMismatchException();
            }
            // Dados comuns
            System.out.print("Digite a marca: ");
            String marca = scanner.nextLine();

            System.out.print("Digite o modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("Digite o ano: ");
            int ano = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite a cor: ");
            String cor = scanner.nextLine();

            System.out.print("Digite o preço: R$ ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o número de portas: ");
                    int nPortas = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o tipo de combustível: ");
                    String tipoCombustivel = scanner.nextLine();

                    System.out.print("Digite a capacidade do porta-malas: ");
                    double capacidadePortaMalas = scanner.nextDouble();
                    scanner.nextLine();

                    Carro carro = new Carro(marca, modelo, ano, cor, preco, nPortas, tipoCombustivel,
                            capacidadePortaMalas);
                    carros.add(carro);
                    System.out.println("Carro cadastrado com sucesso!");
                    escolha = 0;
                    break;

                case 2:

                    System.out.print("Digite as cilindradas: ");
                    int cilindradas = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("A moto possui partida elétrica? (S/N): ");
                    String partida = scanner.nextLine();
                    boolean partidaEletrica = partida.equalsIgnoreCase("S");

                    System.out.print("Digite a categoria: ");
                    String categoria = scanner.nextLine();

                    Moto moto = new Moto(marca, modelo, ano, cor, preco, cilindradas, partidaEletrica, categoria);
                    motos.add(moto);
                    System.out.println("Moto cadastrada com sucesso!");
                    escolha = 0;
                    break;
                case 3:
                    System.out.print("Digite a capacidade de carga (toneladas): ");
                    double capacidadeCarga = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite o numero de eixos: ");
                    int numeroEixos = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o tipo de carroceria: ");
                    String tipoCarroceria = scanner.nextLine();

                    Caminhao caminhao = new Caminhao(marca, modelo, ano, cor, preco,
                            capacidadeCarga, numeroEixos, tipoCarroceria);
                    caminhoes.add(caminhao);
                    System.out.println("Caminhao cadastrado com sucesso!");
                    escolha = 0;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro entrada inválida, certifique-se de inserir os dados corretos");
        } catch (Exception e) {
            System.out.println("Erro desconhecido" + e.getMessage());
        }
    }

    // aleterei o mostrar veiculos
    private static void mostrarVeiculos() {
        try {
            System.out.println("\n=== VEÍCULOS CADASTRADOS ===");

            // Verificar se há veículos cadastrados
            if (carros.isEmpty() && motos.isEmpty() && caminhoes.isEmpty()) {
                throw new VeiculoIndisponivelException("Nenhum veículo cadastrado no sistema");
            }

            int totalVeiculos = carros.size() + motos.size() + caminhoes.size();
            System.out.println("Total: " + totalVeiculos + " veículos");
            System.out.println("================================");

            // Mostrar carros
            if (!carros.isEmpty()) {
                exibirTipoVeiculo("CARROS", carros);
            }

            // Mostrar motos
            if (!motos.isEmpty()) {
                exibirTipoVeiculo("MOTOS", motos);
            }

            // Mostrar caminhões
            if (!caminhoes.isEmpty()) {
                exibirTipoVeiculo("CAMINHÕES", caminhoes);
            }

        } catch (VeiculoIndisponivelException e) {
            System.out.println(" ERRO - Veículo: " + e.getMessage());
            System.out.println(" Dica: Cadastre alguns veículos primeiro usando a opção 2 do menu");
        } catch (Exception e) {
            System.out.println("ERRO - Erro inesperado: " + e.getMessage());
        }
    }

    private static void exibirTipoVeiculo(String tipo, List<? extends Veiculo> lista) {
        if (!lista.isEmpty()) {
            System.out.println("\n" + tipo + " (" + lista.size() + "):");
            for (int i = 0; i < lista.size(); i++) {
                Veiculo v = lista.get(i);
                System.out.println((i + 1) + " - " + v.getMarca() + " " +
                        v.getModelo() + " (" + v.getAno() + ") - R$ " + v.getPreco());
            }
        } else {
            System.out.println("\n" + tipo + " (0): Nenhum cadastrado");
        }
    }

    private static void mostrarCarros() {
        if (!carros.isEmpty()) {
            System.out.println("CARROS:");
            for (int i = 0; i < carros.size(); i++) {
                Carro carro = carros.get(i);
                System.out.println((i + 1) + " - " + carro.getMarca() + " " +
                        carro.getModelo() + " (" + carro.getAno() + ") - R$ " + carro.getPreco());
            }
        } else {
            System.out.println("Nenhum carro cadastrado.");
        }
    }

    private static void mostrarMotos() {
        if (!motos.isEmpty()) {
            System.out.println("MOTOS:");
            for (int i = 0; i < motos.size(); i++) {
                Moto moto = motos.get(i);
                System.out.println((i + 1) + " - " + moto.getMarca() + " " +
                        moto.getModelo() + " (" + moto.getAno() + ") - R$ " + moto.getPreco());
            }
        } else {
            System.out.println("Nenhuma moto cadastrada.");
        }
    }

    private static void mostrarCaminhoes() {
        if (!caminhoes.isEmpty()) {
            System.out.println("CAMINHOES:");
            for (int i = 0; i < caminhoes.size(); i++) {
                Caminhao caminhao = caminhoes.get(i);
                System.out.println((i + 1) + " - " + caminhao.getMarca() + " " +
                        caminhao.getModelo() + " (" + caminhao.getAno() + ") - R$ " + caminhao.getPreco());
            }
        } else {
            System.out.println("Nenhum caminhao cadastrado.");
        }
    }

    private static void venderVeiculo(Scanner scanner) {
        try {
            if (clientes.isEmpty() || (carros.isEmpty() && motos.isEmpty() && caminhoes.isEmpty())) {
                if (clientes.isEmpty()) {
                    System.out.println("Não há clientes na base de dados");
                }
                if (carros.isEmpty()) {
                    System.out.println("Não há carros disponiveis para vendas");
                }
                if (motos.isEmpty()) {
                    System.out.println("Não há motos disponiveis para vendas");
                }
                if (caminhoes.isEmpty()) { // nova para caminhao q eu adicionei
                    System.out.println("Não há caminhoes disponiveis para vendas");
                }
            } else {
                mostrarClients();

                Pessoa comprador = clientes.get(scanner.nextInt() - 1);
                scanner.nextLine();
                System.out.println("Informe o valor da venda: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                int escolha;

                System.out.println("Qual novo veiculo deseja vender?");
                System.out.println("1 - Carro");
                System.out.println("2 - Moto");
                System.out.println("3 - Caminhao"); // NOVA LINHA
                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        mostrarCarros();
                        Carro carroParaVenda = carros.get(scanner.nextInt() - 1);
                        scanner.nextLine(); // interrompe o buffer

                        Venda novaVendaCarro = new Venda(carroParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaCarro);
                        carros.remove(carroParaVenda);
                        break;
                    case 2:
                        mostrarMotos();
                        Moto motoParaVenda = motos.get(scanner.nextInt() - 1);
                        scanner.nextLine(); // interrompe o buffer

                        Venda novaVendaMoto = new Venda(motoParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaMoto);
                        motos.remove(motoParaVenda);
                        break;
                    case 3:
                        mostrarCaminhoes();
                        Caminhao caminhaoParaVenda = caminhoes.get(scanner.nextInt() - 1);
                        scanner.nextLine();

                        Venda novaVendaCaminhao = new Venda(caminhaoParaVenda, comprador, valor, LocalDateTime.now());
                        vendas.add(novaVendaCaminhao);
                        caminhoes.remove(caminhaoParaVenda);
                        break;
                }

                System.out.println("Venda executada com sucesso");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro entrada inválida, certifique-se de inserir os dados corretos");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("erro indice invalida. certifique-se de escolher uma opção correta");
        } catch (Exception e) {
            System.out.println("Erro desconhecido" + e.getMessage());
        }
    }

    private static void mostrarClients() {
        if (!clientes.isEmpty()) {
            System.out.println("Lista de clientes");
            for (int i = 0; i < clientes.size(); i++) {
                Pessoa cliente = clientes.get(i);
                System.out.println((i + 1) + " - " + cliente.getNome() + " " +
                        cliente.getTelefone());
            }
        } else {
            System.out.println("Nenhuma pessoa cadastrada.");
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        try {
            System.out.println("\n=== CADASTRO DE CLIENTE ===");

            // Dados pessoais básicos
            System.out.print("Digite o nome completo: ");
            String nome = scanner.nextLine();

            // verificar se nome não está vazio
            if (nome.trim().isEmpty()) {
                throw new ClienteNaoEncontradoException("Nome do cliente não pode estar vazio");
            }

            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            // verificar idade válida
            if (idade < 18 || idade > 100) {
                throw new ClienteNaoEncontradoException("Idade deve estar entre 18 e 100 anos");
            }

            System.out.print("Digite o endereço completo: ");
            String endereco = scanner.nextLine();

            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Digite o email: ");
            String email = scanner.nextLine();

            System.out.print("Digite a altura (em metros, ex: 1.75): ");
            double altura = scanner.nextDouble();

            // verificar altura válida
            if (altura < 1.0 || altura > 2.5) {
                throw new ClienteNaoEncontradoException("Altura deve estar entre 1.0m e 2.5m");
            }

            System.out.print("Digite o peso (em kg): ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            // verificar peso válido
            if (peso < 30 || peso > 300) {
                throw new ClienteNaoEncontradoException("Peso deve estar entre 30kg e 300kg");
            }

            // Criar pessoa
            Pessoa novoCliente = new Pessoa(nome, idade, endereco, telefone, email, altura, peso);
            clientes.add(novoCliente);

            System.out.println(" O cliente " + nome + " foi cadastrado com sucesso");

        } catch (ClienteNaoEncontradoException e) {
            System.out.println(" ERRO - Cliente: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("ERRO - Entrada inválida. Certifique-se de inserir os dados corretos");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(" ERRO - Erro inesperado: " + e.getMessage());
        }
    }

    private static void gerarRelatorio() {
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas");
            return;
        }

        System.out.println("\n=== RELATÓRIO DE VENDAS ===");
        System.out.println("Total de vendas: " + vendas.size());

        double totalVendas = 0;
        double totalLucro = 0;
        int vendasComLucro = 0;
        int vendasComPrejuizo = 0;

        System.out.println("\n--- DETALHES DAS VENDAS ---");

        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            double lucro = venda.calcularLucro();

            System.out.println("\n" + (i + 1) + ". " + venda.getVeiculo().getMarca() + " " +
                    venda.getVeiculo().getModelo());
            System.out.println("   Comprador: " + venda.getComprador().getNome());
            System.out.println("   Preço original: R$ " + String.format("%.2f", venda.getVeiculo().getPreco()));
            System.out.println("   Valor da venda: R$ " + String.format("%.2f", venda.getValor()));
            System.out.println("   " + venda.getTipoResultado() + ": R$ " + String.format("%.2f", Math.abs(lucro)));

            // Calcular totais
            totalVendas += venda.getValor();
            totalLucro += lucro;

            if (lucro > 0) {
                vendasComLucro++;
            } else if (lucro < 0) {
                vendasComPrejuizo++;
            }
        }

        // Resumo financeiro
        System.out.println("\n=== RESUMO FINANCEIRO ===");
        System.out.println("Total em vendas: R$ " + String.format("%.2f", totalVendas));
        System.out.println("Lucro/Prejuízo total: R$ " + String.format("%.2f", totalLucro));
        System.out.println("Vendas com lucro: " + vendasComLucro);
        System.out.println("Vendas com prejuízo: " + vendasComPrejuizo);

        if (totalLucro > 0) {
            System.out.println("RESULTADO GERAL: LUCRO");
        } else if (totalLucro < 0) {
            System.out.println("RESULTADO GERAL: PREJUÍZO");
        } else {
            System.out.println("RESULTADO GERAL: NEUTRO");
        }
        System.out.println("========================");
    }

    // teste-----------------

    private static void carregarDadosTeste() {
        System.out.println("Carregando dados de teste...");

        // === CARROS ===
        carros.add(new Carro("Toyota", "Corolla", 2023, "Prata", 85000.0, 4, "Flex", 470.0));
        carros.add(new Carro("Honda", "Civic", 2022, "Preto", 95000.0, 4, "Flex", 519.0));
        carros.add(new Carro("Volkswagen", "Golf", 2023, "Branco", 78000.0, 4, "Turbo", 380.0));
        carros.add(new Carro("Ford", "Ka", 2021, "Vermelho", 45000.0, 2, "Flex", 300.0));
        carros.add(new Carro("Chevrolet", "Onix", 2023, "Azul", 55000.0, 4, "Flex", 300.0));

        // === MOTOS ===
        motos.add(new Moto("Honda", "CB 600F", 2023, "Vermelha", 35000.0, 600, true, "Sport"));
        motos.add(new Moto("Yamaha", "XTZ 250", 2022, "Azul", 18000.0, 250, false, "Trail"));
        motos.add(new Moto("Kawasaki", "Ninja 300", 2023, "Verde", 28000.0, 300, true, "Sport"));
        motos.add(new Moto("Honda", "PCX 150", 2023, "Branca", 12000.0, 150, true, "Scooter"));
        motos.add(new Moto("Yamaha", "Fazer 250", 2022, "Preta", 16000.0, 250, true, "Naked"));

        // === CAMINHÕES ===
        caminhoes.add(new Caminhao("Volvo", "FH540", 2023, "Branco", 450000.0, 25.0, 3, "Baú"));
        caminhoes.add(new Caminhao("Scania", "R450", 2022, "Azul", 420000.0, 30.0, 3, "Graneleiro"));
        caminhoes.add(new Caminhao("Mercedes", "Actros", 2023, "Prata", 480000.0, 28.0, 3, "Tanque"));
        caminhoes.add(new Caminhao("DAF", "XF105", 2021, "Vermelho", 380000.0, 20.0, 2, "Carga Seca"));

        // === CLIENTES ===
        clientes.add(new Pessoa("João Silva", 35, "Rua das Flores, 123 - São Paulo/SP",
                "(11) 99999-1111", "joao.silva@email.com", 1.75, 80.0));

        clientes.add(new Pessoa("Maria Santos", 28, "Av. Paulista, 456 - São Paulo/SP",
                "(11) 88888-2222", "maria.santos@email.com", 1.65, 60.0));

        clientes.add(new Pessoa("Pedro Oliveira", 45, "Rua Augusta, 789 - São Paulo/SP",
                "(11) 77777-3333", "pedro.oliveira@email.com", 1.80, 90.0));

        clientes.add(new Pessoa("Ana Costa", 22, "Rua Oscar Freire, 321 - São Paulo/SP",
                "(11) 66666-4444", "ana.costa@email.com", 1.58, 55.0));

        clientes.add(new Pessoa("Carlos Ferreira", 52, "Av. Faria Lima, 654 - São Paulo/SP",
                "(11) 55555-5555", "carlos.ferreira@email.com", 1.85, 95.0));

        clientes.add(new Pessoa("Lucia Mendes", 19, "Rua da Consolação, 987 - São Paulo/SP",
                "(11) 44444-6666", "lucia.mendes@email.com", 1.62, 52.0));

        // === VENDAS (Algumas vendas já realizadas) ===
        vendas.add(new Venda(new Carro("Fiat", "Uno", 2020, "Branco", 35000.0, 4, "Flex", 280.0),
                clientes.get(0), 33000.0, LocalDateTime.of(2024, 1, 15, 14, 30)));

        vendas.add(new Venda(new Moto("Honda", "CG 160", 2021, "Vermelha", 9000.0, 160, false, "Street"),
                clientes.get(1), 8500.0, LocalDateTime.of(2024, 2, 20, 10, 15)));

        vendas.add(new Venda(new Carro("Chevrolet", "Prisma", 2019, "Prata", 42000.0, 4, "Flex", 300.0),
                clientes.get(2), 40000.0, LocalDateTime.of(2024, 3, 10, 16, 45)));

        System.out.println("Dados de teste carregados com sucesso!");
        System.out.println(carros.size() + " carros, " + motos.size() + " motos, " +
                caminhoes.size() + " caminhões");
        System.out.println(clientes.size() + " clientes cadastrados");
        System.out.println(vendas.size() + " vendas registradas");
    }
}