# HopefulHarbor

 Este sistema destina-se ao controle de doações para instituições sem fins lucrativos, como ONG's, por exemplo.
      
<h2> Manual do usuário </h2>

Como faço para acessar o sistema?

    Você pode acessar o sistema utilizando seu login e senha fornecidos pelo administrador. Caso ainda não tenha um, entre em contato com o administrador para obter suas credenciais.
    
Funções do Administrador:

    2.1 Cadastrar Usuário [1]:

    O administrador pode adicionar novos usuários ao sistema. Forneça as informações necessárias, como nome, senha, e atribua as permissões adequadas.
    
    2.2 Exibir Usuários Cadastrados [2]:

    Visualize a lista de todos os usuários cadastrados no sistema.
    
    2.3 Alterar Senha do Usuário [3]:

    Permite ao administrador alterar a senha de um usuário específico. Informe o nome do usuário e a nova senha desejada.
    
    2.4 Deletar Usuário [4]:

    Remove um usuário do sistema. Informe o nome do usuário que deseja excluir.
    
Funções do Usuário:

    3.1 Cadastrar Doação [1]:

    Após o login, o usuário pode adicionar novas doações ao sistema. Forneça informações como descrição, categoria e quantidade.
    
    3.2 Exibir Doações Cadastradas [2]:

    Visualize a lista de todas as doações cadastradas por você.
    
    3.3 Alterar Descrição da Doação [3]:

    Permite ao usuário modificar a descrição de uma doação específica. Informe o ID da doação e a nova descrição desejada.
    
    3.4 Excluir Cadastro [4]:

    Remove uma doação cadastrada. Informe o ID da doação que deseja excluir.
    
    3.5 Dar Entrada no Estoque [5]:

    Adiciona mais unidades de uma doação ao estoque. Informe o ID da doação e a quantidade a ser adicionada.
    
    3.6 Dar Baixa no Estoque [6]:

    Remove unidades de uma doação do estoque. Informe o ID da doação e a quantidade a ser removida.
    
    3.7 Consultar Doações em Estoque por ID [7]:

    Visualize as informações de uma doação específica no estoque. Informe o ID da doação desejada.
    
    3.8 Consultar Doações por Categoria [8]:

    Veja a lista de doações filtradas por categoria. Informe a categoria desejada.
    
Dicas Gerais:

    Sempre mantenha suas credenciais de login seguras e não compartilhe com outros usuários.
    Ao realizar operações sensíveis, como deletar usuários ou doações, confirme suas ações para evitar erros.
    Em caso de dúvidas ou problemas, entre em contato com o administrador do sistema para obter suporte.
    Esse manual serve como um guia básico para o uso do sistema. 

<h2> Manual de instalação JDK </h2> 
   
<h3> Instalação da JDK no Windows: </h3> 
          
   Baixar o JDK:
    
    Acesse o site oficial da Oracle JDK: Oracle JDK Downloads.
    Baixe a versão mais recente do JDK para Windows.
    
   Executar o Instalador:
    
    Após o download, execute o instalador clicando duas vezes no arquivo baixado.
    Siga as instruções do assistente de instalação.
    
   Configurar as Variáveis de Ambiente:
    
    Após a instalação, é necessário configurar as variáveis de ambiente.
    Abra o "Painel de Controle" -> "Sistema e Segurança" -> "Sistema" -> "Configurações Avançadas do Sistema".
    Clique em "Variáveis de Ambiente".
    
    Em "Variáveis do Sistema", clique em "Novo" e adicione uma nova variável chamada JAVA_HOME com o caminho para o diretório de instalação do JDK (ex: C:\Program Files\Java\jdk- 
    15.0.2).
    Edite a variável "Path" e adicione %JAVA_HOME%\bin ao final.
    
   Verificar a Instalação:
    
    Abra um prompt de comando e digite java -version e javac -version. Isso deve exibir as versões do Java e do compilador Java, confirmando que a instalação foi bem-sucedida.
    
   <h3>Instalação da JDK no Linux:</h3>
    
   Atualizar o Sistema:
    
    Abra um terminal e execute os seguintes comandos para garantir que o sistema esteja atualizado:
    bash
    Copy code
    sudo apt update
    sudo apt upgrade
    Instalar o JDK:
    
    Execute o seguinte comando para instalar o OpenJDK, uma implementação gratuita e de código aberto do JDK:
    bash
    Copy code
    sudo apt install default-jdk
    Configurar as Variáveis de Ambiente (Opcional):
    
    Em alguns casos, as variáveis de ambiente já são configuradas automaticamente. Caso contrário, você pode adicionar as seguintes linhas ao final do arquivo ~/.bashrc ou 
    ~/.zshrc:
    bash
    Copy code
    export JAVA_HOME=/usr/lib/jvm/default-java
    export PATH=$PATH:$JAVA_HOME/bin
    Use source ~/.bashrc ou source ~/.zshrc para aplicar as alterações imediatamente.
    Verificar a Instalação:
    
    No terminal, execute java -version e javac -version para verificar se o Java e o compilador Java foram instalados corretamente.






  
