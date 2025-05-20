# 🎮 Jogo das Letras: A Batalha do Lago Lexis

<div align="center">
  <img src="https://img.shields.io/badge/Java-11-orange" alt="Java 11">
  <img src="https://img.shields.io/badge/Licença-MIT-blue" alt="Licença MIT">
  <img src="https://img.shields.io/badge/Versão-1.0-green" alt="Versão 1.0">
</div>

## 📖 A História

No coração do reino Alfabético, existe um lago encantado de águas cristalinas e límpidas. Este lago, conhecido como Lago Lexis, é o ponto de divisão entre duas cidades rivais: a cidade das letras MAIÚSCULAS, forte e imponente, e a cidade das letras minúsculas, ágil e engenhosa.

A cidade das letras MAIÚSCULAS é conhecida por suas construções grandiosas e sua engenharia robusta. As letras MAIÚSCULAS são vistas como líderes e pioneiras, sempre se destacando em cima de seus equivalentes minúsculos. Em contraste, a cidade das letras minúsculas é um exemplo de criatividade e flexibilidade. Suas construções podem não ser tão imponentes, mas são conhecidas por sua eficiência e inovação.

Ambas as cidades desejam construir uma ponte magnífica que atravessará o Lago Lexis, conectando as duas metades do reino e simbolizando a supremacia de uma cidade sobre a outra. A cidade que conseguir completar a ponte primeiro será celebrada como a mais habilidosa e engenhosa, ganhando respeito e reconhecimento em todo o reino Alfabético.

## 🎯 Objetivo do Jogo

O objetivo é formar uma sequência de 3 letras em linha horizontal, vertical ou diagonal no tabuleiro 3x3, representando o Lago Lexis. Cada jogador deve usar suas letras estrategicamente para construir sua ponte e vencer o adversário.

## 🎲 Como Jogar

### Regras Básicas
1. O jogo é jogado em um tabuleiro 3x3
2. Existem dois jogadores:
   - Jogador das minúsculas (usa letras a-z)
   - Jogador das maiúsculas (usa letras A-Z)
3. A jogadora das minúsculas sempre começa primeiro

### Durante o Jogo
1. Em cada turno, o jogador deve:
   - Escolher uma posição no tabuleiro (linha e coluna)
   - Escolher uma letra disponível
2. Uma letra só pode ser usada uma vez por jogador
3. Uma letra minúscula pode substituir uma letra maiúscula se for maior que ela
4. Uma letra maiúscula pode substituir uma letra minúscula se for maior que ela

### Regras de Superioridade
- Uma letra superior é aquela localizada mais para o final do alfabeto
- Exemplos:
  - M é superior a F
  - B é inferior a D
  - Z é superior a todas as outras letras

### Condições de Vitória
O jogo termina quando:
- Um jogador forma uma linha, coluna ou diagonal com três letras do mesmo tipo
- Um jogador usa todas as suas letras disponíveis
- Os jogadores empatam

## 🚀 Como Executar

### Pré-requisitos
- Java 11 ou superior
- Maven

### Instalação
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/letter_game.git
cd letter_game
```

2. Compile o projeto:
```bash
mvn clean package
```

3. Execute o jogo:
```bash
java -jar target/letter-game-1.0-SNAPSHOT.jar
```

## 🎮 Controles do Jogo

### Menu Principal
- 1: Começar um novo jogo
- 2: Continuar um jogo salvo
- 3: Sair

### Durante o Jogo
- Digite a linha (0-2) onde deseja jogar
- Digite a coluna (0-2) onde deseja jogar
- Digite a letra que deseja usar
- Digite '@' a qualquer momento para salvar e sair

## 📁 Estrutura do Projeto

```
letter_game/
├── src/
│   ├── models/
│   │   └── Matriz.java
│   ├── utils/
│   │   └── EscritaArquivo.java
│   └── game/
│       └── LetterGame.java
├── pom.xml
└── README.md
```

## 💾 Salvamento do Jogo

O jogo é salvo automaticamente em um arquivo `save.txt` quando você digita '@' durante o jogo. Você pode continuar o jogo posteriormente usando a opção 2 no menu principal.

## ⚠️ Restrições

- O uso de letras com diacríticos não é permitido (acentos, cedilha, etc.)
- Cada letra só pode ser usada uma vez por jogador
- As posições válidas no tabuleiro são de 0 a 2 (tanto para linhas quanto para colunas)

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👥 Autores

- Seu Nome - Desenvolvimento Inicial

## 🙏 Agradecimentos

- A todos os jogadores que testaram e contribuíram com feedback
- À comunidade Java por fornecer as ferramentas necessárias

## UPPERCASE vs LOWERCASE
Java-based uppercase vs lowercase letter game using matrices.

<details> 

<summary> Como jogar | How to play</summary>

Este jogo é jogado no terminal e envolve duas jogadoras: uma utilizando letras minúsculas e a outra utilizando letras MAIÚSCULAS. O objetivo é formar uma sequência de 3 letras em linha horizontal, vertical ou diagonal no tabuleiro 3x3, representando o lago.

------------------------------------------------------

This game is played in the terminal and involves two players: one using lowercase letters and the other using UPPERCASE letters. The objective is to form a sequence of 3 letters in a horizontal, vertical, or diagonal line on the 3x3 board, representing the lake.
</details>

<details>

<summary> História | History</summary>

No coração do reino Alfabético, existe um lago encantado de águas cristalinas e límpidas. Este lago, conhecido como Lago Lexis, é o ponto de divisão entre duas cidades rivais: a cidade das letras MAIÚSCULAS, forte e imponente, e a cidade das letras minúsculas, ágil e engenhosa. Ambas as cidades desejam construir uma ponte magnífica que atravessará o Lago Lexis, conectando as duas metades do reino e simbolizando a supremacia de uma cidade sobre a outra.

A cidade das letras MAIÚSCULAS é conhecida por suas construções grandiosas e sua engenharia robusta. As letras MAIÚSCULAS são vistas como líderes e pioneiras, sempre se destacando em cima de seus equivalentes minúsculos. Em contraste, a cidade das letras minúsculas é um exemplo de criatividade e flexibilidade. Suas construções podem não ser tão imponentes, mas são conhecidas por sua eficiência e inovação. As letras minúsculas são apreciadas por sua versatilidade e agilidade.

Observando de fora, os números se abstêm de participar dessa competição. Eles preferem manter sua neutralidade e focar em suas próprias paixões e lógicas, deixando a engenharia civil para as letras.

A construção da ponte não é apenas uma obra de engenharia, mas também uma demonstração de competência profissional que será lembrada pelas gerações futuras. A cidade que conseguir completar a ponte primeiro será celebrada como a mais habilidosa e engenhosa, ganhando respeito e reconhecimento em todo o reino Alfabético. Assim, a grande competição das letras começou, com cada cidade determinada a mostrar que suas habilidades e inteligência são superiores.

------------------------------------------------------

In the heart of the Alphabet Kingdom lies an enchanted lake with crystal-clear waters known as Lake Lexis. This lake serves as the dividing line between two rival cities: the city of UPPERCASE letters, strong and imposing, and the city of lowercase letters, agile and ingenious. Both cities aspire to construct a magnificent bridge spanning Lake Lexis, connecting the two halves of the kingdom and symbolizing the supremacy of one city over the other.

The city of UPPERCASE letters is renowned for its grand structures and robust engineering. UPPERCASE letters are seen as leaders and pioneers, always standing out above their lowercase counterparts. In contrast, the city of lowercase letters exemplifies creativity and flexibility. While their constructions may not be as imposing, they are known for their efficiency and innovation. Lowercase letters are valued for their versatility and agility.

Watching from the sidelines, the numbers choose to remain neutral in this competition. They prefer to focus on their own passions and logic, leaving civil engineering to the letters.

Building the bridge is not just an engineering feat; it is also a demonstration of professional competence that will be remembered by future generations. The city that completes the bridge first will be celebrated as the most skilled and ingenious, earning respect and recognition throughout the Alphabet Kingdom. Thus, the great competition of letters began, with each city determined to prove that their skills and intelligence are superior.

</details>
    

<details>
  <summary>Instruções | Instructions</summary>
  
O estado inicial do jogo é completamente vazio. A jogadora das minúsculas joga sempre primeiro, colocando uma letra qualquer em um espaço qualquer do lago. Depois disso, a jogadora das MAIÚSCULAS pode escolher colocar uma letra em um espaço não ocupado do lago ou colocar uma letra MAIÚSCULA superior sobre um espaço de uma letra minúscula que já está no lago (veja os detalhes abaixo).

Depois, a jogadora das minúsculas pode escolher colocar uma letra em um espaço não ocupado ou colocar uma letra minúscula superior sobre um espaço de uma letra MAIÚSCULA que já está no lago. O jogo segue dessa forma na alternância de turnos entre as jogadoras. Depois que uma jogadora usa uma letra, ela não pode usar aquela letra novamente.

Uma jogadora ganha quando completar uma sequência de 3 letras que controla na horizontal, na vertical ou na diagonal.

O uso de letras com diacríticos (sinais gráficos que alteram o papel ou a fonética das letras) não é permitido, ou seja, nada de acentos circunflexos (letras com chapéu), til (letras com penteado extravagante), cedilha (letras com rabinho) etc.

Uma letra superior é aquela localizada mais para o final do alfabeto. Por exemplo:

- M é superior a F
- B é inferior a D
- Z é superior a todas as outras letras (então use-o com sabedoria).

------------------------------------------------------

The initial state of the game is completely empty. The lowercase player always goes first, placing any letter in any empty space on the lake. After that, the UPPERCASE player can choose to place a letter in an unoccupied space on the lake or place a superior UPPERCASE letter over a space occupied by a lowercase letter (see details below).

Next, the lowercase player can choose to place a letter in an unoccupied space or place a superior lowercase letter over a space occupied by an UPPERCASE letter. The game continues in this alternating manner between the players. Once a player uses a letter, that letter cannot be used again.

A player wins by completing a sequence of 3 controlled letters horizontally, vertically, or diagonally.

The use of letters with diacritics (graphic signs that alter the role or phonetics of letters) is not allowed, meaning no circumflex accents (letters with hats), tildes (letters with fancy hair), cedillas (letters with tails), etc.

A superior letter is one located later in the alphabet. For example:

- M is superior to F
- B is inferior to D
- Z is superior to all other letters (so use it wisely).







  
</details>


<details>

<summary> Interface </summary>

still under construction

</details>




