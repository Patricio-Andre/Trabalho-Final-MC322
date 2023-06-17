# HOSPHUB - Trabalho final MC322
## André Patricio de Sousa - RA 260363 - turma B
## Daniel Santos Sobrinho - RA 260404 - turma A
## Fernando de Araújo Sacerdote - RA 240807 - turma A
## Maria Beatriz Guimarães Trombini Manhães Moreira - RA 252873 - turma A

O projeto em questão pretende implementar um método de administração de hospitais que serviria tanto para um único hospital, quanto para uma rede. Isso é possível, pois, por meio da classe *"Hospital"*, o usuário consegue cadastrar o hospital específico em que trabalha, ou todos os hospitais que possui. Cada hospital possui seu **nome**, **telefone**, **email**, **endereco**, **um HashMap de seus funcionarios** (cujo id é o COREN/CRM e o valor é o próprio funcionário), seu **cnpj** (final), um **número de vagas disponíveis para internacao**, e uma **LinkedList de internações**. Essa classe, além dos métodos de acesso (gets e sets) para todos os atributos (menos cnpj, que por ser final só possui get) implementa a interface *"Cadastrable"*, que por sua vez, possui os métodos **Cadastrar: boolean** e **Remover: boolean.** Na classe em questão, os métodos serão implementados de 2 formas diferentes: a primeira **Cadastrar(ProfissionalSaude): boolean** e sua sobrecarga **Cadastrar(Internacao):boolean** e, analogamente, **Remover(String id): boolean** e **Remover(Paciente paciente): boolean**. Além disso, a classe hospital permite a busca de profissional de saúde por meio do id, listar funcionários, listar enfermeiros, listar médicos, listar internação removerPaciente e toString. Para facilitar o cadastro de médicos, existe a classe ArquivoProfissionais, com o método leProfissionais e o próprio método leArquivo da classe Hospital, de modo que um arquivo com as informacoes dos profissionais da saude pode ser lido e suas informações adicionadas ao programa.

Para a classe **abstrata** *ProfissionalSaude*, existem os atributos **nome**, **cpf**(que será validado), **registro**(que pode ser tanto COREN quanto CRM). É importante frisar que, ao contrário do cpf, o CRM e o COREN não são feitos com um hashing, e são apenas números sequenciais, ou seja, não há algoritmos para validá-los. Por isso, guardaremos um "E" ou um "M" no fim do registro a depender da classe concreta em que o profissional for instanciado, evitar possíveis confusões. Além disso, o médico possui 2 atributos LocalDateTime, sendo um deles o **início** do seu plantão e outro o seu **fim**. Além disso, possui uma **LinkedList de dias da semana em que faz plantão**- algo importante para quando se for cadastrar um paciente - e um **HashMap de pacientes**, que será controlado por meio da Cadastrable. também possui um **numero máximo de pacientes que pode atender***. Seus métodos principais são **gerarReceita(Paciente)**: boolean e **retirarReceita(Paciente)**: boolean. Além disso, em sua implementação de Cadastrar, caso não ele não esteja de plantão quando o paciente chegar, será gerada uma **ProfissionalUnfitException**, que é checked. 

A classe *Medique* é uma classe concreta que herda de ProfissionalSaude. Possui 2 atributos próprios: **custo** e **especialidade**. Um dos casos que também pode gerar ProfissionalUnfit exception em cadastrar, é quando a especialidade do médico não é a que o paciente precisa. Possui os métodos: **gerarLaudo(Paciente): boolean**, **solicitacaoExame(Paciente): boolean** e **cobrar(Paciente): void**. Caso o paciente não esteja na lista do profissional, é jogada uma **PacientenotFound** exception.

*Enfermeire* é outra classe concreta que herda de ProfissionalSaude. Possui 2 metodos, **alimentar** e **dar banho**. Se passou mais de 5 segundos desde a entrada do paciente, é chamada a função alimentar, mais de 10, dar banho.

A classe *Paciente*, por sua vez, é uma classe **abstrata**, que possui os atributos **nome**, **idade**, LinkedList de **sintomas (String)**, LinkedList de **remédios incompativeis(String)**, de **examesincompativeis(String)**, **niveldeDor**, **quarto**, **cpf** e **gravidade**. A gravidade é gerada pelo método gerar gravidade, que usa um algoritmo para atribuir "verde", "amarela" ou "vermelha". Caso o nível seja verde, nada ocorrerá, caso seja amarelo, assim que for atribuido a um médico, será gerada uma receita e um atestado. Caso seja  vermelho, quando isso ocorrer, será gerado um exame um laudo e um atestado. 
Caso sejam mudados os níveis de dor do paciente, ou o numero de sintomas, esse processo sera repetido. Os pacientes podem gravar nas classes *ArquivoLaudo*, *ArquivoAtestados* e *ArquivoReceitas* todos os laudos, receitas e atestados que ja receberam.

*PacienteParticular* é a classe concreta que herda de Paciente e possui os atributos **convenio**, **id convenio** e **custo**. *PacienteSUS* também herda de Paciente e possui os atributos **numeroSUS** e **cama**. (há varias camas por quarto para SUS). 

A classe *Exame* possui **nome**, **custo** e **data**. A classe *Atestado* possui um **médico**, **dias de ausencia** e **datadoatendimento**, a classe *Laudo* possui **médico**, **doença** e **datadoatendimento**. A classe *Receita* possui **remedio(String)**, **dosagem** e **lista de interferencias(String)**, **datadeValidade(LocalDate)**, e um **profissional responsável**. 
Caso um médico tente atribuir uma receita a um paciente que ele seja alérgico ou que está em seus remédios incompatíveis, gerará uma **RemedioIncompativelException**.
Caso o mesmo ocorra com um exame, gerará um **ExameIncompativelException**.

Por fim, a classe *Internacao* possui um **paciente**, um **medico responsavel**, uma **enfermeira responsavel**, um **custo**, uma LocalDateTime **entrada** e uma LocalDateTime **saida**.

Todos os pacientes recebem alta na saida dada na internacao. 
Todo o programa será controlado por meio de uma interface gráfica, com um JMenu, JButtons 