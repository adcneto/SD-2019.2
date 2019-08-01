# Introdução ao Apache Zookeeper
*Retirado do roteiro de aula do Prof. Gustavo S. Pavani, CMCC/UFABC.*

## Roteiro

- Instale o [ZooKeeper], versão [3.4.14].
- As atividades a seguir fazem parte do Projeto Final, a ser apresentado
  conforme estipulado.

[ZooKeeper]: http://zookeeper.apache.org/
[3.4.14]: http://ftp.unicamp.br/pub/apache/zookeeper/zookeeper-3.4.14/zookeeper-3.4.14.tar.gz

## Exercícios

1. *Ephemeral versus Persistent (Regular) znodes*.
   1. Inicie a interface de comando de linha (CLI):

      ```console
      $ bin/zkCli.sh -server 127.0.0.1:2181
      ```

   2. Crie um *znode* persistente para este exercício:

      ```console
      > create /mcta025 data
      ```

   3. Crie um outro *znode* persistente:

      ```console
      > create /mcta025/ex1 data
      ```

   4. Crie um *znode* efêmero:

      ```console
      > create -e /mcta025/ex1/ephemeral data
      ```

   5. Liste os filhos do seu sistema de arquivo (na API, *getChildren*):

      ```console
      > ls <path>
      ```

   6. Saia do cliente usando o comando `quit`.
   7. Reinicie a CLI e liste novamente os filhos do sistema de arquivo.
      O que aconteceu?
   8. Crie um novo *znode* efêmero:

      ```console
      > create -e /mcta025/ex1/ephemeral1 data
      ```

      Então, crie um filho para o *znode* que acabou de ser criado:

      ```console
      > create /mcta025/ex1/ephemeral1/child data
      ```

      O que aconteceu?
2. *Sequential suffix*.
   1. Crie um outro *znode* persistente:

      ```console
      > create /mcta025/ex2 data
      ```

   2. Crie *znodes* sequenciais (com sufixo sequencial):

      ```console
      > create -s /mcta025/ex2/child data
      ```

      Repita o comando várias vezes. Qual o comprimento do sufixo?
   3. Crie *znodes* sequenciais efêmeros:

      ```console
      > create -s -e /mcta025/ex2/child data
      ```

      Repita o comando várias vezes.
   4. Remova alguns *znodes* com o comando:

      ```console
      > delete <path>
      ```

   5. Crie mais alguns *znodes* sequenciais. Como fica a numeração deles?
   6. Crie *znodes* sequenciais com outro prefixo:

      ```console
      > create -s /mcta025/ex2/son data
      ```

      Como fica a numeração deles?

   7. Crie outros *znodes* sequenciais em `/mcta025`. A numeração (isto é,
      o escopo) está relacionada com a numeração anterior?
3. *Watches*.
   1. Todas as operações de leitura no ZooKeeper tem a opção de se
      configurar um *watch*. Abra um segundo cliente em paralelo, que
      chamaremos de Cliente 2. O cliente inicial será chamado de Cliente 1.
   2. Crie um novo *znode* através do Cliente 1:

      ```console
      > create /mcta025/ex3 data
      ```

   3. Configure um *watch* de dados do nó que acabou de ser criado no
      Cliente 1:

      ```console
      > get /mcta025/ex3 true
      ```

   4. No Cliente 2, modifique os dados do nó:

      ```console
      > set /mcta025/ex3 newData
      ```

      O que acontece no Cliente 1?

   5. Replita no Cliente 2 o comando anterior. O que aconteceu no
      Cliente 1? Justifique.
   6. É possível instalar *watch* de filhos de um nó. No Cliente 1:

      ```console
      > ls /mcta025/ex3 true
      ```

      Então, no Cliente 2, crie um novo filho dentro de `/mcta025/ex3`.
      O que aconteceu?
   7. Crie um *watch* de dados para `/mcta025/ex3`. No Cliente 2, crie um
      filho em `/mcta025/ex3`. O que aconteceu? Justifique.
   8. Crie um *watch* de filhos para o nó `/mcta025/ex3` e um *watch* de
      filhos para um filho dele usando o Cliente 1. No Cliente 2, crie um
      filho no nó filho criado anteriormente. O que aconteceu? Agora crie
      um filho em `/mcta025/ex3`. O que podemos concluir dessas operações?
   9. Crie um *watch* de dados de um filho de `/mcta025/ex3` e um *watch*
      de filhos para `/mcta025/ex3` no Cliente 1. No Cliente 2, remova
      esse nó filho de `/mcta025/ex3`. O que aconteceu?
4. [ZooKeeper Java Example].
   1. Execute o `run.sh` depois de acertar o valor da variável `ZK` para o
      diretório de instalação do ZooKeeper em seu computador.
   2. Em uma CLI, crie um *znode*:

      ```console
      > create /mcta025/ex4 aData
      ```

      O que aconteceu?
   3. Depois, mude o valor do nó:

      ```console
      > set /mcta025/ex4 newData
      ```

      O que aconteceu?
   4. Delete o nó:

      ```console
      > delete /mcta025/ex4
      ```

      O que aconteceu?

[ZooKeeper Java Example]: https://zookeeper.apache.org/doc/r3.4.14/javaExample.html
