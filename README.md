# Caixa-Branca-Parte-1-Análise Estrutural 

**link do MIRO: https://miro.com/welcomeonboard/Tkx1M0hIVkpYWENoM09sYVBBU0syNEp5OE5MWEN6SUI1WFkzSnRjUVNDOU1kS2dJOEt3SDdnUGRFNTdhTy9SeHdyQVF2UnQvZlVMdGhRK0oyVm0yZENrN1ZXV2hhRDd3NDhQVmpsbzdyamxCZ2xWQW5BbkpQbGpuS0cwVXBVcGh3VHhHVHd5UWtSM1BidUtUYmxycDRnPT0hdjE=?share_link_id=968854975211**


**Teste de Caixa Branca Estática: [PLANO DE TESTE.xlsx](https://github.com/user-attachments/files/23553848/PLANO.DE.TESTE.xlsx)
**


**Grafo de Fluxo**

![Grafo de Fluxo](https://github.com/user-attachments/assets/98de8f9b-26c6-455c-a216-7f5b596494c4)

![NÓS E ARESTAS](https://github.com/user-attachments/assets/210e4c8a-2f18-48af-9126-d014c8ac182b)

![Grafo de fluxo lógico](https://github.com/user-attachments/assets/79f61e67-daf1-4ed4-ac5a-3c333efe8386)


**Descrição dos Nós (N)**

* **N1**: Inicialização de variáveis e construção da query SQL.
* **N2**: Início do bloco try (criação do Statement).
* **N3**: Ponto de Decisão: if (rs.next()).
* **N4**: Bloco if (condição verdadeira): result = true; nome = rs.getString("nome");.
* **N5**: Fim do bloco try / Início do bloco catch.
* **N6**: Bloco catch (tratamento de exceção).
* **N7**: Ponto de Saída: return result;.

**Arestas (E)**

* **E1**: N1 -> N2
* **E2**: N2 -> N3
* **E3**: N3 -> N4 (True)
* **E4**: N3 -> N5 (False)
* **E5**: N4 -> N5
* **E6**: N5 -> N7 (Fluxo de sucesso)
* **E7**: N2 -> N6 (Fluxo de Exceção)
* **E8**: N6 -> N7

---

**Complexidade Ciclomática**

V(G) = E - N + 2P

* E = 8 (Arestas)
* N = 7 (Nós)
* P = 1
  
V(G) = 8 - 7 + 2 * 1
V(G) = 1 + 2
V(G) = 3

A Complexidade Ciclomática é **3**.

---

**Caminhos Básicos do Código**

Com base na Complexidade Ciclomática de 3, identificamos 3 caminhos básicos independentes:

1.  **Caminho 1 (Sucesso - Usuário Encontrado):**
    * **Fluxo**: N1 → N2 → N3 (True) → N4 → N5 → N7
    * **Cenário de Teste**: Fornecer um login e senha válidos que resultem em um registro encontrado no ResultSet.

2.  **Caminho 2 (Sucesso - Usuário Não Encontrado):**
    * **Fluxo**: N1 → N2 → N3 (False) → N5 → N7
    * **Cenário de Teste**: Fornecer um login e senha que não resultem em nenhum registro no ResultSet (ou seja, usuário não existe).

3.  **Caminho 3 (Falha - Exceção):**
    * **Fluxo**: N1 → N2 → N6 → N7
    * **Cenário de Teste**: Simular uma falha na execução da query (ex: erro de sintaxe) que force o fluxo para o bloco catch.

---
**Análise de Complexidade Ciclomática da Reformulação do código**


**Cálculo da Complexidade Ciclomática:**
* E = 4 (Arestas)
* N = 4 (Nós)
* P = 1

V(G) = 4 - 4 + 2 * 1
V(G) = 0 + 2
V(G) = 2

A Complexidade Ciclomática é **2**.

**Caminhos:**
1.  Caminho 1: Conexão bem-sucedida.
2.  Caminho 2: Falha na conexão.
