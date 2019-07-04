# RMI e Serialização
*Retirado do roteiro de aula do Prof. Gustavo S. Pavani, CMCC/UFABC.*

## *Remote Method Invocation (RMI)*

- Permite que um objeto que está sendo executado em uma JVM 
  (*Java Virtual Machine*) invoque métodos de um objeto sendo executado
  em outra JVM.
  - Tutorial sobre [Java RMI].
- O Java também possui uma tecnologia para objetos distribuídos que
  independe da linguagem de implementação desses objetos: [Java IDL].

[Java RMI]: https://docs.oracle.com/javase/tutorial/rmi/
[Java IDL]: https://docs.oracle.com/javase/8/docs/technotes/guides/idl/GShome.html

## Serialização em Java

- Conversão do estado do objeto para um fluxo de bytes, que pode ser mais
  tarde revertido para uma cópia do objeto.
- Um objeto Java é serializável se sua classe/superclasse implementa
  `java.io.Serializable` ou `java.io.Externalizable`.
- Palavra-chave `transient`.
  - Indica que a variável não irá participar do processo de serialização.
  - Útil quando a variável é usada para recursos fixos, como um
    descritor de arquivo.
  - Variáveis tipo `static` também não sofrem serialização.
- Controle de versão com `serialVersionUID`.
  - O processo de serialização depende do valor correto de `serialVersionUID`
    para recuperar o estado do objeto. A exceção `java.io.InvalidClassException`
    é lançada se o valor atual de `serialVersionUID` for diferente no
    objeto serializado.
- Maiores informações podem ser obtidas no documento 
  *[Java Object Serialization Specification]*.

[Java Object Serialization Specification]: https://docs.oracle.com/javase/7/docs/platform/serialization/spec/serialTOC.html

## Roteiro

1. Seguir o [tutorial de RMI].
   1. Servidor: executar o `rmi.bat` e depois o `server.bat`.
   2. Cliente: executar o `client.bat`. Discorra sobre os tempos
      obtidos na execução de forma remota e local.
2. Executar a classe `serialization.SerialObject` com os parâmetros
   adequados (nome de arquivo e operação).
   1. Qual o papel de cada operação (`write`, `read` e `diff`)?
3. Implementar um sistema [cliente-servidor] em que o cliente envia
   seu objeto [Properties] a um servidor por meio de *socket*. O servidor
   compara o objeto enviado com seu próprio *Properties* e devolve
   o resultado da operação `diff` ao cliente, que é impresso na tela.

[tutorial de RMI]: https://docs.oracle.com/javase/tutorial/rmi/
[cliente-servidor]: http://www.javacodex.com/Networking/Reading-and-Writing-to-Sockets
[Properties]: https://docs.oracle.com/javase/7/docs/api/java/util/Properties.html
