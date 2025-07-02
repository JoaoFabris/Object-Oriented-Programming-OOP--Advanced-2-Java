# 🚗 Sistema de Concessionária - POO Java

Sistema completo de gerenciamento de concessionária desenvolvido em Java, aplicando todos os conceitos fundamentais de Programação Orientada a Objetos (POO).

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Conceitos POO Aplicados](#conceitos-poo-aplicados)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar](#como-executar)
- [Exercícios Implementados](#exercícios-implementados)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Capturas de Tela](#capturas-de-tela)
- [Contribuição](#contribuição)
- [Licença](#licença)

## 🎯 Sobre o Projeto

Este projeto foi desenvolvido como parte de um exercício acadêmico para demonstrar a aplicação prática dos conceitos de POO em Java. O sistema simula o funcionamento de uma concessionária de veículos, permitindo o cadastro de diferentes tipos de veículos, clientes e realização de vendas.

### 🌟 Destaques do Sistema

- **Sistema Inteligente de Recomendação**: Sugere veículos baseado no biotipo físico do cliente
- **Análise Financeira Completa**: Calcula lucro/prejuízo automaticamente
- **Tratamento Robusto de Erros**: Exceções personalizadas para diferentes cenários
- **Interface Amigável**: Menu interativo com validações completas

## 🚀 Funcionalidades

### 📊 Gestão de Veículos
- ✅ Cadastro de **Carros**, **Motos** e **Caminhões**
- ✅ Listagem detalhada com informações específicas
- ✅ Controle de estoque automático

### 👥 Gestão de Clientes
- ✅ Cadastro completo com dados pessoais e físicos
- ✅ Validação de dados (idade, altura, peso)
- ✅ Listagem detalhada de clientes

### 💰 Sistema de Vendas
- ✅ Processo de venda interativo
- ✅ Cálculo automático de lucro/prejuízo
- ✅ Histórico completo de vendas
- ✅ Relatórios financeiros detalhados

### 🎯 Sugestão Inteligente
- ✅ Análise de biotipo (IMC, idade, altura)
- ✅ Recomendação personalizada de veículos
- ✅ Algoritmo de compatibilidade cliente-veículo

## 🏗️ Conceitos POO Aplicados

### 1. **Herança**
```java
public abstract class Veiculo {
    // Classe pai abstrata
}

public class Carro extends Veiculo {
    // Classe filha específica
}
```

### 2. **Polimorfismo**
```java
private static void exibirTipoVeiculo(String tipo, List<? extends Veiculo> lista) {
    // Método genérico que funciona para qualquer tipo de veículo
}
```

### 3. **Encapsulamento**
```java
private String marca;
private String modelo;

public String getMarca() { return marca; }
public void setMarca(String marca) { this.marca = marca; }
```

### 4. **Abstração**
```java
public abstract void exibirInformacoes(); // Método abstrato
```

### 5. **Tratamento de Exceções**
```java
public class ClienteNaoEncontradoException extends Exception {
    // Exceção personalizada
}
```

## 📁 Estrutura do Projeto

```
sistema-concessionaria/
├── src/
│   ├── Main.java                           # Classe principal com menu
│   ├── Veiculo.java                        # Classe abstrata pai
│   ├── Carro.java                          # Classe filha - Carro
│   ├── Moto.java                           # Classe filha - Moto
│   ├── Caminhao.java                       # Classe filha - Caminhão
│   ├── Pessoa.java                         # Classe Cliente
│   ├── Venda.java                          # Classe Venda
│   ├── ClienteNaoEncontradoException.java  # Exceção personalizada
│   └── VeiculoIndisponivelException.java   # Exceção personalizada
├── README.md
└── .gitignore
```

## 🔧 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- IDE Java (Eclipse, IntelliJ IDEA, VS Code) ou terminal

### Passos para execução

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/sistema-concessionaria.git
cd sistema-concessionaria
```

2. **Compile o projeto**
```bash
javac *.java
```

3. **Execute o programa**
```bash
java Main
```

4. **Navegue pelo menu**
```
=== MENU DA CONCESSIONÁRIA ===
1 - Mostrar Veículos
2 - Comprar Veículo
3 - Vender Veículo
4 - Cadastrar Cliente
5 - Mostrar Clientes
6 - Gerar Relatório
7 - Sugerir Veículo por Biotipo
8 - Carregar Dados de Teste
0 - Sair
```

## 📚 Exercícios Implementados

### 🏗️ **Exercício 1: Herança**
- Implementação de classe abstrata `Veiculo`
- Criação de classes filhas: `Carro`, `Moto`, `Caminhao`
- Uso de `super()` e métodos abstratos

### 👥 **Exercício 2: Exibição Detalhada**
- Método `mostrarClientesDetalhado()`
- Formatação organizada de informações
- Listagem completa de dados dos clientes

### 🔄 **Exercício 3: Polimorfismo**
- Método genérico `exibirTipoVeiculo()`
- Uso de wildcards (`List<? extends Veiculo>`)
- Tratamento uniforme de diferentes tipos

### 🎯 **Exercício 4: Sugestão por Biotipo**
- Sistema inteligente de recomendação
- Cálculo automático de IMC
- Análise por idade, altura e biotipo
- Filtro de veículos compatíveis

### 💰 **Exercício 5: Relatório Financeiro**
- Cálculo automático de lucro/prejuízo
- Métodos `calcularLucro()` e `getTipoResultado()`
- Resumo financeiro completo
- Estatísticas de vendas

### ⚠️ **Exercício 6: Exceções Personalizadas**
- `ClienteNaoEncontradoException`
- `VeiculoIndisponivelException`
- Validações robustas de entrada
- Tratamento específico de erros

### 🐛 **Exercício 7: Correção de Bugs**
- Correção de 7+ bugs identificados
- Validação de entrada do Scanner
- Proteção contra divisão por zero
- Verificação de índices de listas
- Mensagens de erro padronizadas

## 🛠️ Tecnologias Utilizadas

- **Java 8+** - Linguagem principal
- **Collections Framework** - ArrayList para gerenciamento de dados
- **LocalDateTime** - Controle de data/hora das vendas
- **Scanner** - Entrada de dados do usuário
- **Exception Handling** - Tratamento robusto de erros

## 📸 Capturas de Tela

### Menu Principal
```
=== MENU DA CONCESSIONÁRIA ===
1 - Mostrar Veículos
2 - Comprar Veículo
3 - Vender Veículo
4 - Cadastrar Cliente
5 - Mostrar Clientes
6 - Gerar Relatório
7 - Sugerir Veículo por Biotipo
8 - Carregar Dados de Teste
0 - Sair
Escolha uma opção: 
```

### Sugestão por Biotipo
```
=== ANÁLISE DO CLIENTE ===
Cliente: João Silva
Idade: 35 anos
Altura: 1.75m
Peso: 80.0kg
IMC: 26.1

=== SUGESTÕES PERSONALIZADAS ===
• Perfil adulto: Carros médios ou SUVs
• Altura média: Qualquer tipo de veículo
• Biotipo robusto: Carros com bancos largos, SUVs

=== VEÍCULOS RECOMENDADOS ===
CARROS RECOMENDADOS:
Toyota Corolla (2023) - R$ 85000.0
Honda Civic (2022) - R$ 95000.0
```

### Relatório Financeiro
```
=== RELATÓRIO DE VENDAS ===
Total de vendas: 3

--- DETALHES DAS VENDAS ---

1. Toyota Corolla
   Comprador: João Silva
   Preço original: R$ 85.000,00
   Valor da venda: R$ 90.000,00
   LUCRO: R$ 5.000,00

=== RESUMO FINANCEIRO ===
Total em vendas: R$ 582.000,00
Lucro/Prejuízo total: R$ 12.000,00
Vendas com lucro: 2
Vendas com prejuízo: 1
RESULTADO GERAL: LUCRO
```

## 🎓 Aprendizados

### Este projeto demonstra a aplicação prática de:

| - **Herança e Polimorfismo** - Hierarquia de classes bem estruturada |
|---|


- **Encapsulamento** - Proteção de dados com getters/setters
- **Abstração** - Uso de classes e métodos abstratos
- **Tratamento de Exceções** - Criação de exceções personalizadas
- **Validação de Dados** - Entrada segura e robusta
- **Algoritmos de Recomendação** - Lógica de negócio inteligente
- **Análise Financeira** - Cálculos automáticos de lucro/prejuízo

## 🤝 Contribuição

### Contribuições são bem-vindas! Para contribuir:

| 1. Faça um fork do projeto |
|---|


2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Seu Nome**
- GitHub: [@seu-usuario](https://github.com/seu-usuario)
- LinkedIn: [Seu Nome](https://linkedin.com/in/seu-perfil)
- Email: seu.email@exemplo.com

---

⭐ **Se este projeto te ajudou, deixe uma estrela!** ⭐

## 🔗 Links Úteis

- [Documentação Java](https://docs.oracle.com/javase/8/docs/)
- [Conceitos de POO](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Exception Handling](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

---

<div align="center">
  <strong>Desenvolvido com ❤️ e ☕ durante o aprendizado de POO</strong>
</div>
