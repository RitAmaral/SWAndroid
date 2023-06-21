# Acesso Móvel a Sistemas de Informação

![image](https://github.com/RitAmaral/SWAndroid/assets/132366922/bf37c094-0400-4b53-bdd5-b99464870347)


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
      
- [02 Ex1](02_Ex1) - Aula 20 e 21/06/2023 - Exercícios 1 e 2
- [02 Ex3](02_Ex3) - Aula 20 e 21/06/2023 - Exercício 3




    
