
package pro.logic;


public class usuario {
    String id;
    String password;
    char tipo;

    public usuario() {
    }

    public usuario(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public usuario(String id, String password, char tipo) {
        this.id = id;
        this.password = password;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public char getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", password=" + password + ", tipo=" + tipo + '}';
    }

 

    
}
