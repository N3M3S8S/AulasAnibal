package ArquivosJava;

import ArquivosJava.UsuarioDados;

public class CalculaMedia {
    
    public static float[] SetCom(float n1, float n2, float n3, float n4) {
        float[] temp = {n1,n2,n3,n4};
        return temp;
    }
    
    public static void main(String[] args) {
        UsuarioDados a1 = new UsuarioDados();
        a1.setNotas(SetCom(1.5f, 1.4f, 1.6f, 1.3f));
        UsuarioDados a2 = new UsuarioDados();
    }
}
