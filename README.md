# ElevatorController
This project is a Demo of the 'brain' of the elevator system of a building <br/>
Esse projeto é o cotrolador de um sistemas de elevadores de um prédio.<br/>

This file contains a copy of itself in portuguese at the ending.<br/>
Esse arquivo contém uma cópia em portugues ao final.<br/>

Classes and atributes:<br/>

This project uses Java languase only, and consists on 3 classes, the main class is used to call the others and are beeig used to test the system.<br/>
The Class Elevator is the elevators of the building. To create an elevator you need to inform the minimum and maximum floor it supoused to reach as integers, and give it a name (it can be the same of the object Elevator or not) as an String. An Elevator has some atributes: minFLoor, maxFloor and threadName is the ones you set above, but it also contains an boolean Emerency, which is turned to true when a button is pressed inside the elevator, an ArrayList af destinations (the floors that it is suposed to stop), and an integer that represents an state  witch shouldn't be adressed directly, as there are specific functions to change it, the values it can assume is (-1, when the elevator is goig down, 0 when it is stoped, 1 when it is going up and 2 when it is stoped because of an emergency.<br/>

The Building class is the actual building where the elevators are, and can be created either using a integer with the maximun numbers of elevators it can store, or by passing nothing (so the maximum number is set to 5 by default). An building have an Array of Elevator, and 2 integers, one indicating maximum numbers of elevators and the other (counter) indicating the actual number of elevators.<br/><br/>


Functions:<br/>

The Elevator class have 6 functions: <br/>
start - initialize the Therad if it haven't allready.<br/>
sort - function called every time an new destination is added, to keep the next floor at the first position of the destination array.<br/>
addDestination - it add an destination to the destination Array, and call the sort function. This function expect an integer ( the number of the floor that should be added).<br/>
handleArraval - controls the elevators doors, once it reaches an destination, by default it keep the doors opened for 1.5 seconds.<br/>
handleEmergency - it controls the emergency situations and should be called every time the emergency button is pressed. This fuction expect an boolean that should be true if there is a emergency.<br/>
run - this is the main function of the class, it is called when the destination Array isn't empty and move the elevator through the floors.<br/>

The Building class have 3 functions:<br/>
addElevator - this function add an elevator to the building and expect an elevator as input.<br/>
searchElevator - this function look for the nearest elevator available and it expect 2 integers, one is the floor the person are, and the other is the direction (IMPORTANT) it can only be -1 if you are going down, or 1 if you are going up.<br/>
requestElevator - the main goal of this function is to add an destination to the nearest elevator found by the searchElevator function. You will note, however, that this function can be called with 2 or 3 inputs, both of them uses two integers, one for the floor where the person are (the one added on the elevator's destination Array) and the other is the direction (works the same way of the searchElevator fuction), but one of them you also pass the floor wich the person whants to go, (IMPORTANT) this one is used for testing only, as, besides reducind the performance, it wouln't make sense since you can only choose an floor to go once you are inside the elevator (as designed by the request).<br/><br/>


Instalation:<br/>

- On each floor (as requested) there are two buttons to call the elevator (except the last and the basement floors) indicating the direction you what to go, this buttons should call the requestElevator function of the building, passing the present floor and the direction.<br/>
- Once inside the elevator, there are buttons indicating the floors that you can go, each of this buttons should call the addDestination function of the elevator, and should pass the corresponding floor number.<br/>
- Inside the elevator there is also an emergency button, wich should call the hadleEmergency function of the elevator and pass an boolean true when it is pressed.<br/><br/>



---------------------------------------------------------------------------Portuguese section-----------------------------------------------------------------------------
<br/><br/>
Classes e atributos:<br/>

Esse projeto é feito inteiramente em Java e consiste em 3 classes, a main é utilizada para chamar e iniciar as outras, além de testes.<br/>
A classe Elevator são os elevadores do prédio, para criar um elevador é necessário passar o andar mínimo (minFLoor) como um inteiro, o andar máximo (maxFloor) como um inteiro e o nome do elevaor (threadName) em String (pode ser o mesmo do nome do objeto ou não). Além desses atributos, um elevador também tem um boolean Emergency, que fica como true quando um botão é acionado dentro do elevador, um ArrayList destinations, que contém inteiros que representam os andares destinos do elevador(onde ele vai parar) e um inteiro que representa o estado do elevador (state) e pode ser igual a -1 (se o elevador estiver descendo), 0 (se estiver parado), 1 (se estiver subindo) ou 2 (se estiver parado devido a uma emergência).<br/>

A classe Buildig consiste no prédio onde se encontram os elevadores, e pode ser criada passando um iteiro que indica o número máximo de elevadores que o prédio pode ter ( se esse número não for passado ele assume o valor default de 5). Além desse número máximo, um building também tem o número atual de elevadores (counter) e um array de elevadores.
<br/><br/>
Funções:<br/>

A classe Elevator têm 6 funções:<br/>
start - Inicializa o Thread.<br/>
sort - Função chamada toda vez que um novo destino é adicionado, para manter a próxima parada do elevador sempre na primeira posição do Array.<br/>
addDestination - Adiciona um novo destino (andar) no destination Array, e chama a função sort. Essa função espera como entrada um inteiro (o número do andar a ser adicionado).<br/>
handleArraval - Controla as portas do elevador quando ele chega no andar de destino. O tempo que a porta permanece aberto é default de 1.5 segundos.<br/>
handleEmergency - Controla as situações de emergências, e é chamado toda vez que o botão de emergência é acionado. Essa função espera como entrada um boolean que deve ser verdadeiro em caso de emergência.<br/>
run - Essa é a principal função da classe, roda enquanto o destination Array não está vazio e é responsável por mover o elevador pelos andares do prédio.<br/>

A classe Building tem 3 funções:<br/>
addElevator - Essa função adiciona um elevador no Array Elevators do prédio e espera um Elevator como entrada.<br/>
searchElevator - Essa função procura o elevador mais próximo disponível e retorna seu index no array Elevators. Essa função espera como entrada dois números inteiros, um indicando o andar em que se encontra, e o outro a direção, sendo (IMPORTANTE) 1 caso se queira subir ou -1 caso se queira descer.<br/>
requestElevator - O objetivo dessa função é adicionar um novo andar (onde a pessoa se encontra) no array destination do elevador mais próximo encontrado pela função searchElevator. Note, porém, que você pode passar dois ou três inteiros como entrada para essa função. Em ambos você passa o andar em que se encontra (que será adicionado o Array) e a direção (sendo 1 caso se queira subir ou -1 caso se queira descer), caso você chame com o terceiro inteiro, o que indica o andar de destino ( que você pretede ir) você chamará uma outra versão dessa função,(IMPORTANTE) que só deve ser usada para testes, já que, além de atrapalhar a performance, não faria sentido, uma vez que (conforme solicitado) você só tem a opção de selecionar o andar de destino dentro do elevador.<br/><br/>


Instalação:<br/>

- Em cada andar (conforme requisitado) têm dois botões para chamar o elevador (com exceção do andar mais baixo, e do mais alto) sendo que cada botão indica a direção em que se deseja ir. Esses botões devem chamar a função requestElevator do prédio (do objeto da classe Building em que os elevadores se encontram), passando como parâmetros o andar em que se encontra e a direção.<br/>
- Uma vez dentro do elevador, encontra-se uma série de botões indicando os possíveis andares que se pode escolher, cada um desses botões deve chamar a função addDestination do respectivo elevador, e passar o número do andar correspondente.<br/>
- Dentro do elevador, também se encontra um botão de emergência, que deve chamar a função handleEmergency do repectivo elevador e passar um boolean true quando pressionado.

