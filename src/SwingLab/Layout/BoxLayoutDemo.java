package SwingLab.Layout;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import javax.swing.*;

/*
*
* FlowLayoutDemo.java
*
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BoxLayoutDemo extends JFrame {

    public BoxLayoutDemo(){

        this.setTitle("Box Layout");
        this.setSize(300, 170);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel b1 = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(new JButton("Bouton 1"));
        b1.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));

        JPanel b2 = new JPanel();
        //Idem pour cette ligne
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(new JButton("Bouton 2"));
        b2.add(new JButton("Bouton 3"));
        b2.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));

        JPanel b3 = new JPanel();
        //Idem pour cette ligne
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(new JButton("Bouton 4"));
        b3.add(new JButton("Bouton 5"));
        b3.add(new JButton("Bouton 6"));
        b3.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));

        JPanel b4 = new JPanel();
        //On positionne maintenant ces trois lignes en colonne
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        this.getContentPane().add(b4);
        this.setVisible(true);
    }

    public static void main(String[] arguments) {
        BoxLayoutDemo box = new BoxLayoutDemo();
    }
}
