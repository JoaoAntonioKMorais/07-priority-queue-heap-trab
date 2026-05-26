# Fila de Prioridade com Heap Binário

Trabalho M2 da disciplina de Estrutura de Dados.

O projeto simula a triagem do Hospital São Binário. Os pacientes não são atendidos pela ordem de chegada, mas sim pela prioridade clínica calculada a partir de três critérios:

1. maior nível de urgência;
2. maior tempo de espera, quando o nível de urgência é igual;
3. paciente de grupo vulnerável, quando urgência e tempo de espera são iguais.

A fila de prioridade foi implementada com Heap Binário de máximo.

## Níveis de urgência

| Nível | Cor | Classificação |
| --- | --- | --- |
| 5 | Vermelho | Imediato |
| 4 | Laranja | Muito urgente |
| 3 | Amarelo | Urgente |
| 2 | Verde | Pouco urgente |
| 1 | Azul | Não urgente |

## Estrutura do projeto

```text
src/
├── Main.java
├── entidades/
│   ├── Paciente.java
│   └── Pessoa.java
├── estatica/
│   ├── FilaComPrioridade.java
│   └── FilaEstatica.java
└── heap/
    └── FilaComPrioridadeHeap.java
```

## Requisitos

- Java JDK 8 ou superior
- Git, caso queira clonar o repositório

## Compilação

No terminal, dentro da pasta do projeto, execute:

```bash
javac -encoding UTF-8 -d out src/entidades/*.java src/estatica/*.java src/heap/*.java src/Main.java
```

## Execução

```bash
java -cp out Main
```

## Saída esperada

A aplicação insere os 6 pacientes de teste e mostra o estado interno do heap após cada inserção. Depois, remove todos os pacientes em ordem de prioridade.

Ordem de atendimento esperada:

```text
1. Maria
2. Pedro
3. Beatriz
4. João
5. Helena
6. Carlos
```

## Como funciona o heap

### Enfileirar

O paciente é inserido na última posição livre do vetor. Depois disso, o algoritmo Sobe Heap compara o paciente inserido com o pai. Se o paciente novo tiver prioridade maior, os dois trocam de posição. Esse processo continua até o paciente chegar à posição correta.

### Desenfileirar

O paciente da raiz, que possui maior prioridade, é removido. O último elemento do heap vai para a raiz. Depois disso, o algoritmo Desce Heap compara esse elemento com os filhos e troca com o filho de maior prioridade até restaurar a propriedade do heap.

## Gerar Javadoc localmente

```bash
javadoc -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 -d doc -sourcepath src -subpackages entidades:estatica:heap
```

Depois, abra o arquivo:

```text
doc/index.html
```

## GitHub Pages

O projeto possui um workflow em `.github/workflows/javadoc.yaml` para publicar o Javadoc automaticamente no GitHub Pages.

Para o deploy funcionar, no GitHub acesse:

```text
Settings → Pages → Source → GitHub Actions
```
