# Marketplace para Comércio Local

Sistema de Vendas Online para Comércio Local desenvolvido em Java, demonstrando conceitos de Programação Orientada a Objetos.

## 📋 Descrição

Este projeto implementa um sistema de marketplace completo com as seguintes características:

- **Superclasse**: `ItemVenda` - classe abstrata base para todos os itens vendáveis
- **Subclasses**:
  - `ProdutoFisico` - produtos físicos com peso, dimensões e estoque
  - `Servico` - serviços como entrega e instalação
  - `ProdutoDigital` - produtos digitais como vouchers e ingressos
- **Agregação**: Classe `Loja` que possui um catálogo de `ItemVenda`
- **Interface**: `CarrinhoDeCompras` com implementação completa de operações de compra

## 🏗️ Estrutura do Projeto

```
marketplace-sd/
├── src/
│   ├── main/java/com/marketplace/
│   │   ├── ItemVenda.java              # Superclasse abstrata
│   │   ├── ProdutoFisico.java          # Subclasse para produtos físicos
│   │   ├── Servico.java                # Subclasse para serviços
│   │   ├── ProdutoDigital.java         # Subclasse para produtos digitais
│   │   ├── CarrinhoDeCompras.java      # Interface do carrinho
│   │   ├── CarrinhoDeComprasImpl.java  # Implementação do carrinho
│   │   ├── Loja.java                   # Classe de agregação
│   │   └── MarketplaceDemo.java        # Demonstração do sistema
│   └── test/java/com/marketplace/
│       ├── ItemVendaTest.java          # Testes das classes de item
│       ├── LojaTest.java               # Testes da loja
│       ├── CarrinhoDeComprasTest.java  # Testes do carrinho
│       └── TestRunner.java             # Executor de testes
├── .gitignore
├── LICENSE
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 8 ou superior

### Compilação

```bash
# Compilar código principal
javac -d bin -sourcepath src/main/java src/main/java/com/marketplace/*.java

# Compilar testes
javac -d bin -cp bin -sourcepath src/test/java src/test/java/com/marketplace/*.java
```

### Executar Testes

```bash
java -ea -cp bin com.marketplace.TestRunner
```

### Executar Demonstração

```bash
java -cp bin com.marketplace.MarketplaceDemo
```

## 📚 Conceitos de POO Implementados

### 1. Herança
- `ItemVenda` é a superclasse abstrata
- `ProdutoFisico`, `Servico` e `ProdutoDigital` herdam de `ItemVenda`

### 2. Polimorfismo
- Método abstrato `obterInformacoes()` implementado de forma específica em cada subclasse
- Diferentes tipos de itens podem ser tratados de forma uniforme através da superclasse

### 3. Encapsulamento
- Atributos privados com getters e setters públicos
- Lógica interna protegida

### 4. Agregação
- A classe `Loja` possui uma coleção de `ItemVenda`
- Os itens podem existir independentemente da loja

### 5. Interface
- `CarrinhoDeCompras` define contrato para operações de compra
- `CarrinhoDeComprasImpl` fornece implementação concreta

## 🎯 Funcionalidades

### Loja
- Adicionar itens ao catálogo
- Remover itens do catálogo
- Buscar itens por ID
- Listar todo o catálogo

### Carrinho de Compras
- Adicionar itens com quantidade
- Remover itens
- Calcular total
- Finalizar compra
- Limpar carrinho

### Tipos de Itens
- **Produto Físico**: peso, dimensões, estoque
- **Serviço**: duração estimada, tipo de serviço
- **Produto Digital**: formato, link de download, validade

## 📝 Exemplo de Uso

```java
// Criar loja
Loja loja = new Loja("L001", "Loja do João", "Rua Principal, 123");

// Criar produtos
ProdutoFisico notebook = new ProdutoFisico(
    "P001", "Notebook Dell", "Notebook 16GB RAM", 
    3500.00, 2.5, "35x25x2 cm", 10
);

Servico entrega = new Servico(
    "S001", "Entrega Express", "Entrega em 2h", 
    25.00, 120, "entrega"
);

// Adicionar ao catálogo
loja.adicionarItem(notebook);
loja.adicionarItem(entrega);

// Criar carrinho e adicionar itens
CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
carrinho.adicionarItem(notebook, 1);
carrinho.adicionarItem(entrega, 1);

// Calcular e finalizar
double total = carrinho.calcularTotal();
carrinho.finalizarCompra();
```

## ✅ Testes

O projeto inclui testes abrangentes para todas as classes principais:
- Testes de criação e manipulação de itens
- Testes de operações da loja
- Testes de operações do carrinho
- Validação de regras de negócio

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👥 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.