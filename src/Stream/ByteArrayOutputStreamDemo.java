package Stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by morgannm on 19/07/2018.
 */
public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);

        while( bOutput.size()!= 10 ) {
            // Gets the inputs from the user
            bOutput.write("hello".getBytes());
        }
        byte b [] = bOutput.toByteArray();
        System.out.println("Print the content");

        for(int x = 0; x < b.length; x++) {
            // printing the characters
            System.out.print((char)b[x]  + "   ");
        }
        System.out.println("   ");

        int c;
        ByteArrayInputStream bInput = new ByteArrayInputStream(b);
        System.out.println("Converting characters to Upper case " );

        for(int y = 0 ; y < 1; y++ ) {
            while(( c = bInput.read())!= -1) {
                System.out.println(Character.toUpperCase((char)c));
            }
            bInput.reset();
        }

        System.out.println("======================");
        ByteArrayOutputStream bOutput2 = new ByteArrayOutputStream();
        bOutput2.write("morgann.moussier@free.fr".getBytes());
        System.out.println("Taille du ByteArrayOutputStream  : " + bOutput2.size());

    }
}
