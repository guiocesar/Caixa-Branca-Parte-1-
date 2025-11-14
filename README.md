# Caixa-Branca-Parte-1-


->  Notação de Grafo de Fluxo

![Untitled (1)](https://github.com/user-attachments/assets/c661048a-df85-4f20-baac-d9ac782e175c)



N1 -> Inicialização de variáveis e construção da query SQL.

N2 -> Início do bloco try

N3 -> Ponto de Decisão: if 

N4 -> Bloco if (condição verdadeira)

N5 -> Fim do bloco try / Início do bloco catch.

N6 -> Bloco catch.

N7 -> Ponto de Saída: return result;


-> Arestas (E):

E1: N1 -> N2

E2: N2 -> N3

E3: N3 -> N4 (True)

E4: N3 -> N5 (False)

E5: N4 -> N5

E6: N5 -> N7 (Fluxo de sucesso)

E7: N2 -> N6 (Fluxo de Exceção)

E8: N6 -> N7

-> Complexidade Ciclomática 
V(G)=E−N+2P

Cálculo:
$E = 8$ (Arestas)
$N = 7$ (Nós)
$P = 1$ 

V(G)=8−7+2×1
V(G)=1+2
V(G)=3

Resultado: A Complexidade do cod é 3.



-> Caminhos Básicos do código 

Com base na Complexidade Ciclomática de 3:

Caminho 1 (Sucesso - Usuário Encontrado):  N1 → N2 → N3 (True) → N4 → N5 → N7

Cenário de Teste: Fornecer um login e senha válidos que resultem em um registro no ResultSet.

Caminho 2 (Sucesso - Usuário Não Encontrado):  N1 → N2 → N3 (False) → N5 → N7

Cenário de Teste: Fornecer um login e senha que não resultem em nenhum registro no ResultSet.

Caminho 3 (Falha - Exceção): Fluxo: N1 → N2 → N6 → N7

Cenário de Teste: Simular uma falha na execução da query (ex: erro de sintaxe SQL, conexão perdida, conn nulo, etc.) que force o fluxo para o bloco catch.





-> Análisando a complexidade Ciclomática e os caminhos do meu código

Cálculo da Complexidade Ciclomática:
$E = 4$ (Arestas)
$N = 4$ (Nós)
$P = 1$

V(G)=4−4+2×1=2

Resultado: A Complexidade Ciclomática é 2.

Caminhos:
Caminho 1: Conexão bem-sucedida.
Caminho 2: Falha na conexão (exceção capturada).
