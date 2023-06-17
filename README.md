# HOSPHUB - Trabalho final MC322
## André Patricio de Sousa - RA 260363 - turma B
## Daniel Santos Sobrinho - RA 260404 - turma A
## Fernando de Araújo Sacerdote - RA 240807 - turma A
## Maria Beatriz Guimarães Trombini Manhães Moreira - RA 252873 - turma A

O projeto em questão pretende implementar um método de administração de hospitais que serviria tanto para um único hospital, quanto para uma rede. Isso é possível, pois, por meio da classe *"Hospital"*, o usuário consegue cadastrar o hospital específico em que trabalha, ou todos os hospitais que possui. Cada hospital possui seu **nome**, **telefone**, **email**, **endereco**, **um HashMap de seus funcionarios** (cujo id é o COREN/CRM e o valor é o próprio funcionário), seu **cnpj** (final), um **número de vagas disponíveis para internacao**, e uma **LinkedList de internações**. Essa classe, além dos métodos de acesso (gets e sets) para todos os atributos (menos cnpj, que por ser final só possui get) implementa a interface *"Cadastrable"*, que por sua vez, possui os métodos **Cadastrar: boolean** e **Remover: boolean.** Na classe em questão, os métodos serão implementados de 2 formas diferentes: a primeira **Cadastrar(ProfissionalSaude): boolean** e sua sobrecarga **Cadastrar(Internacao):boolean** e, analogamente, **Remover(String id): boolean** e **Remover(Paciente paciente): boolean**. Além disso, a classe hospital permite a busca de profissional de saúde por meio do id, listar funcionários, listar enfermeiros, listar médicos, listar internação e toString.



