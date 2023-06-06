
import java.util.Optional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 
 */
public class NewClass {

    public static void main(String[] args) {
        System.out.println(getString("asd").get());
    }

    public static Optional<String> getString(String str) {

        if (str.equals("asd")) {
            return Optional.of("asd");
        } else {
            return Optional.empty();
        }

    }
    
    public static String getString2(String str){
        if (str.equals("asd")) {
            return "ok";
        }
        return null;
    }
// Optional class provides a way, to replace the null reference of T Type with a non-null value
}
