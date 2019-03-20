package pt2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import pt2.usuaris.Usuari;

/**
 *
 * @author x2382383c
 */
public class Pt2 {
    static HashMap<Integer,Usuari> totsUsuaris = new HashMap<Integer, Usuari>();
    public static void main(String[] args) {
        //Login usuari y contraseña 
        //Verificacion si existe usando usuaris.txt
        //Si el usuario no existe el programa acaba
        //Si el usuario existe creara un archivo zip pt2.zip
        //con los archivos del src de la practica de juegos anterior.
        try {
            File userTxt = new File("Usuaris.txt");
            
            readUser(userTxt);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce el nombre de usuario");
            String username = br.readLine();
            System.out.println("Introduce la contrasenya del usuario");
            int passwd = Integer.parseInt(br.readLine());
            
            Usuari n = new Usuari(username, username);
            checkUser(n);
            
        } catch (Exception e) {
        } 
    }
    
    
    public static String[] splitStringX(String in){
        String conversor = in;
        String[] splitString = conversor.split(":");
        return splitString;
    }
    
    //se para en el readuser, especificamente en el bufferedReader
    public static void readUser(File doc){
        try {
            FileReader fr = new FileReader(doc);
            BufferedReader br = new BufferedReader(fr);
            String linea1;
            
            while((linea1 = br.readLine()) !=null){
                String[] temp = splitStringX(linea1);
                int uID = Integer.parseInt(temp[0]);
                String user = temp[1];
                String passw = temp[2];
            
                Usuari n = new Usuari(uID, user, passw);
                totsUsuaris.put(uID, n);
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public static void checkUser(Usuari in){
        try {
            for (Map.Entry<Integer, Usuari> entry : totsUsuaris.entrySet()) {
                Usuari value = entry.getValue();
                
                if(value.getUsername().equals(in.getUsername()) && value.getPassword().equals(in.getPassword())){
                    System.out.println("Usuario correcto");
                }else{
                    System.out.println("Usuario incorrecto");
                }
            }
        } catch (Exception e) {
        }
    }
    
}
