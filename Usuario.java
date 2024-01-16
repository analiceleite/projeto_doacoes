
public class Usuario {
    int idUsuario;
    private String senha, confirmacaoSenha, login, nomeUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    public String getNome() {
        return nomeUsuario;
    }

    public void setNome(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    
}
