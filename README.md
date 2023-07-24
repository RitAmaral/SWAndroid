# Acesso Móvel a Sistemas de Informação

![image](https://github.com/RitAmaral/SWAndroid/assets/132366922/bf37c094-0400-4b53-bdd5-b99464870347)

[Formador: Bruno Santos](https://github.com/brunofrs7/Android-Kotlin)

## Aulas e exercícios: Android - Kotlin

- [02 Primeira App](02_PrimeiraAPP_Rita) - Aula 20 e 21/06/2023
    - Para cada ecrã da aplicação serão criados 2 ficheiros: .kt = lógica de programação, .xml = layout
    - Identação: Code -> Reformat code ou ctrl alt L
    - Comentários é como em C#: `//` ou `/* */`
    - Prestar atenção / colocar Id que faça sentido nos elementos que colocamos (botão, etc)
    - Sempre que colocar os elementos, clicar na varinha (Infer constraints), para eles ficarem no sítio onde os colocamos.
    - build.gradle(Module) -> onde estão as configurações da aplicação, colocar o viewBinding, que liga o XML a KT. Colocar em baixo de kotlinOptions. É necessário colocar em todos os projetos, e depois de colocar, temos de clicar em Sync now:
      
      ![image](https://github.com/RitAmaral/SWAndroid/assets/132366922/9835a887-07a1-4eb5-ab3c-193f88497f32)

    - Ir ao ficheiro main activity e crio variável binding:
      
      ![image](https://github.com/RitAmaral/SWAndroid/assets/132366922/820a9c1d-be8d-44f0-9782-832fc2e7401a)

    - `val nome = binding.editNome.text.toString()` -> é como se fosse Console.ReadLine e `binding.textResultado.setText("Olá ${nome}")` -> é como se fosse Console.WriteLine. val = constante, poupa memória em relação a var = variável. Também posso escrever, se não estiver a atribuir um valor: `val nome : String`. Mas este não é o caso, e é nulo. Outra forma, que representa 0 e não nulo: `val nome = ""`.
      
      ![image](https://github.com/RitAmaral/SWAndroid/assets/132366922/c59708ce-3e4c-4737-a2d8-a9dd9f7092ad)
      
- [02 Ex1](02_Ex1) - Aula 21/06/2023 - Exercícios 1 e 2
- [02 Ex3](02_Ex3) - Aula 21/06/2023 - Exercício 3
    - Conversão de elementos:
     
      ![image](https://github.com/RitAmaral/SWAndroid/assets/132366922/d91de8cf-095d-4a2d-925f-51e49b244b55)

- [03 Ex1](03_Ex1) - Aula 21/06/2023 - Exercício 1
- [03 Ex2](03_Ex2) - Aula 21/06/2023 - Exercício 2 - igual ao exercício 1 mas com toast (pop-up) em vez de textview
- [04 Ex1](04_Ex1) - Aula 22/06/2023 - Exercício 1
- [04 Ex2](04_Ex2) - Aula 22/06/2023 - Exercício 2
- [04 Ex3](04_Ex3) - Aula 22/06/2023 - Exercício 3 - LinearLayout dentro de Linear Layout - ex de converter euros em dólares, reais e pesos.
- [04 Ex4](04_Ex4) - Aula 22/06/2023 - Exercício 4 - LinearLayout dentro de Linear Layout - ex username e password válidos
- [05 Exemplo](05_Exemplo) - Aula 23/06/2023 - Exemplos sobre criar **múltiplas activities**, *intent* que faz a ligação entre activities, *splashscreen*, *handler*, trocar launcher activity através do *manifest*.
- [05 Ex1](05_Ex1) - Aula 26/06/2023 - Exercício 1 - toast, e segunda activity
- [05 Ex2](05_Ex2) - Aula 26/06/2023 - Exercício 2 - 3 activities
- [05 Ex3](05_Ex3) - Aula 26/06/2023 - Exercício 3 - splashcreen (handler)
- [05 Ex4](05_Ex4) - Aula 26/06/2023 - Exercício 4 - número par/ímpar e primo/não primo
- [05 Ex5](05_Ex5) - Aula 26/06/2023 - Exercício 5 - converter horas em semanas, dias e horas
- [06 Ex1](06_Ex1) - Aula 28/06/2023 - Exercício 1 - mandar dados de formulário de uma activity para outra: put extra, get string
- [06 Ex2](06_Ex2) - Aula 28/06/2023 - Exercício 2 - 3 activities, bundle
- [06 Ex3](06_Ex3) - Aula 28/06/2023 - Exercício 3 - 5 activities, menu registo, login, sobre
- [06 Ex4](06_Ex4) - Aula 28/06/2023 - Exercício 4 e 5 - checkbox
- [07 ListaListViewString](07_ListaListViewString) - Aula 03/07/2023 - Exemplo sobre listas, listview
- [07 ListViewObjetos](07_ListViewObjetos) - Aula 03/07/2023- Exemplo sobre classes e objetos
- [07 Ex1](07_Ex1) - Aula 04/07/2023 - Exercício 1 - lista de nomes
- [07 Ex2](07_Ex2) - Aula 04/07/2023 - Exercício 2 - lista de numeros, adicionar, editar e remover
- [07 Ex3](07_Ex3) - Aula 04/07/2023 - Exercício 3 - lista de alunos (classe aluno - nome, morada, email), adicionar, editar e remover
- [09 Shared Preferences](09_SharedPreferences) - Aula 05/07/2023 - Shared Preferences - guardar dados em ficheiro xml
- [09 Audio](09_Audio) - Aula 05/07/2023 - Audio - como colocar audio numa app (criar pasta raw dentro do res, inserir file audio mp3 lá)
- [09 Ex1](09_Ex1) - Aula 05/07/2023 - Exercício 1 - Shared Preferences: username e password guardados em ficheiro xml
- [09 Ex2](09_Ex2) - Aula 06/07/2023 - Exercício 2 - Shared Preferences: bloco de notas
- [09 Ex3](09_Ex3) - Aula 06/07/2023 - Exercício 3 - 3 audios - 3 botões
- [10 RelativeLayout](10_RelativeLayout)
- [11 CicloVidaActivity](11_CicloVidaActivity)
- [12 AppRelogio](12_AppRelogio) - fullscreen, ecrã sempre ligado
- [13 RecyclerView](13_RecyclerView)
- [14 SQLite](14_SQLite) - base de dados
- [16 ROOM](16_ROOM)
- [TP MOB_AnaRitaAmaral](TP_MOB_AnaRitaAmaral) - trabalho final de Mobile

