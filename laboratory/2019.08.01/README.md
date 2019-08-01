# Sincronização e coordenação no ZooKeeper
*Retirado do roteiro de aula do Prof. Gustavo S. Pavani, CMCC/UFABC.*

## Apache ZooKeeper

- Desenvolvendo aplicações com o [ZooKeeper].
  - [Linhas gerais] do ZooKeeper.
  - [Receitas e soluções] para programação do ZooKeeper.
  - [API do ZooKeeper].
- Preparação do laboratório.
  - Inicialize o servidor do ZooKeeper:

    ```console
    $ bin/zkServer.sh start-foreground
    ```

[ZooKeeper]: https://zookeeper.apache.org/
[Linhas gerais]: http://zookeeper.apache.org/doc/r3.4.14/zookeeperOver.html
[Receitas e soluções]: http://zookeeper.apache.org/doc/r3.4.14/recipes.html
[API do ZooKeeper]: http://zookeeper.apache.org/doc/r3.4.14/api/index.html

## Roteiro

1. [Barrier and Queue Tutorial].
   1. Modificar a variável `ZK` de acordo com a instalação do ZooKeeper em
      `run_barrier.sh`.
   2. O que significa a variável `SIZE` em `run_barrier.sh`?
   3. Executar `run_barrier.sh`. O que aconteceu?
   4. Modificar a variável `ZK` de acordo com a instalação do ZooKeeper em
      `run_queue_producer.sh`.
   5. Modificar a variável `ZK` de acordo com a instalação do ZooKeeper em
      `run_queue_consumer.sh`.
   6. O que significa a variável `SIZE` em `run_queue_producer.sh`?
      E em `run_queue_consumer.sh`?
   7. Executar `run_queue_consumer.sh` e depois `run_queue_producer.sh`.
      O que aconteceu? Alterne a execução dos *scripts*.
2. Tutorial de *lock* baseado no [Barrier and Queue Tutorial].
   1. Modificar a variável `ZK` de acordo com a instalação do ZooKeeper em
      `run_lock.sh`.
   2. O que significa a variável `WAIT` em `run_lock.sh`?
   3. Executar várias instâncias de `run_lock.sh`. O que aconteceu?
   4. Executar várias instâncias de `run_lock.sh` e, em seguida, matar
      alguma instância intermediária. O que aconteceu?

[Barrier and Queue Tutorial]: http://zookeeper.apache.org/doc/r3.4.14/zookeeperTutorial.html
