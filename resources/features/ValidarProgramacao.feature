# language: pt
# Author: Danilo Silva Tempos
# encoding UTF-8
Funcionalidade: Validar programação
  A fim de validar as programações no site da Sky

  @Sky @CT01
  Cenário: CT01 Validar se programação atual é igual na tela e no modal no site da Sky
    Dado que acesse a tela inicial da Sky
    Quando acessar a Programação
    E verificar o programa atual do primeiro canal com a programação disponível
    Então validar que o programa atual é o mesmo exibido no modal do canal selecionado
