# Processos e *sockets*
*Retirado do roteiro de aula do Prof. Gustavo S. Pavani, CMCC/UFABC.*

## Software

- Pasta `client`.
  - Cliente TCP comum para os três tipos de servidores.
- Pasta `thread`.
  - Implementação do servidor TCP usando múltiplos [threads].
- Pasta `nio`.
  - Implementação do servidor TCP usando [Java Non-blocking IO].
- Pasta `fork`.
  - Implementação do servidor TCP usando [fork].

[threads]: http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
[Java Non-blocking IO]: http://tutorials.jenkov.com/java-nio/index.html
[fork]: http://man7.org/linux/man-pages/man2/fork.2.html

## Java IO vs. NIO

- Diferenças básicas entre Java Input/Output (IO) e Non-blocking
  Input/Output (NIO).

  | IO                          | NIO                                       |
  | --------------------------- | ----------------------------------------- |
  | Stream oriented Blocking IO | Buffer oriented Non-blocking IO Selectors |

- *Stream oriented vs. buffer oriented*.
  - Para se movimentar os dados de um *stream*, é necessário primeiro obtê-lo
    via leitura.
  - Com o buffer isso é mais fácil, mas deve ser feito com alguns cuidados.
    Uso de um *channel* para movimentar dados de um *buffer*.
- *Blocking IO vs. non-blocking IO*.
  - Na versão não-bloqueante, o controle é liberado independentemente se
    há dados para serem lidos/escritos.
- *Selector*.
  - Possibilita que um único *thread* monitore múltiplos canais de entrada.
  - Múltiplos canais são registrados no *selector*.

## Ferramentas

- Visual VM.
  - Uso para monitoramento e análise de desempenho em Java.
  - Disponível para *download* em https://visualvm.github.io/
- Wireshark.
  - Analisador de protocolos (*sniffer*).
  - Disponível para *download* em https://www.wireshark.org/

## Roteiro

1. Executar os diferentes servidores em uma máquina diferente da 
   máquina cliente.

   1. Usar o Visual VM para avaliar o comportamento dos programas em Java,
      incluindo o desempenho.
   2. Fazer a captura dos pacotes usando Wireshark e discutir o protocolo
      de aplicação usado.

2. Modificar o servidor Java *multi-threaded* para usar [pool] de *threads*.

[pool]: http://tutorials.jenkov.com/java-concurrency/thread-pools.html
