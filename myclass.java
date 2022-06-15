package dia6;

import java.util.*;

public class myclass {
    public String ganadores(List<Carta[]> jugadas){
        System.out.println("Cantidad de jugadas: " + jugadas.size());
        for (Carta[] mano : jugadas) {
            System.out.println("JUGADA ======================");
            for (Carta c : mano) {
                System.out.println(c.valorPalo());
            }
        }
        return "0";
    }


    public static void main(String args[]) {
        myclass mc = new myclass();
        List<Carta[]> jugadas = new ArrayList<Carta[]>();
        Carta[] m1 = new Carta[5];
        m1[0] = new Carta("AH");
        m1[1] = new Carta("AD");
        m1[2] = new Carta("TH");
        m1[3] = new Carta("TC");
        m1[4] = new Carta("6S");
    
        String[] numeros = new String[5];
        String[] palos = new String[5];
        for(int i=0; i<5; i++){
            if (m1[i].valor.equals("A")){
                numeros[i] = "1";
            } else if (m1[i].valor.equals("T")){
                numeros[i]="10";
            } else if (m1[i].valor.equals("J")){
                numeros[i] = "11";
            } else if (m1[i].valor.equals("Q")){
                numeros[i] = "12";
            } else if (m1[i].valor.equals("K")){
                numeros[i] = "13";
            } else {
                numeros[i] = m1[i].valor;
            }    
            palos[i] = m1[i].palo;
        }
        System.out.println("Numeros: " + numeros[0] + " " + numeros[1] + " " + numeros[2] + " " + numeros[3] + " " + numeros[4]);  
        System.out.println("Palos: " + palos[0] + " " + palos[1] + " " + palos[2] + " " + palos[3] + " " + palos[4]);      
        //hasta aca funciona
        
        
        Carta[] m2 = new Carta[5];
        m2[0] = new Carta("AH");
        m2[1] = new Carta("KD");
        m2[2] = new Carta("QH");
        m2[3] = new Carta("3C");
        m2[4] = new Carta("3S");

            
        String[] numeros2 = new String[5];
        String[] palos2 = new String[5];
        for(int i=0; i<5; i++){
            if (m2[i].valor.equals("A")){
                numeros2[i] = "1";
            } else if (m2[i].valor.equals("T")){
                numeros2[i]="10";
            } else if (m2[i].valor.equals("J")){
                numeros2[i] = "11";
            } else if (m2[i].valor.equals("Q")){
                numeros2[i] = "12";
            } else if (m2[i].valor.equals("K")){
                numeros2[i] = "13";
            } else {
                numeros2[i] = m2[i].valor;
            }    
            palos2[i] = m2[i].palo;
        }
        System.out.println("Numeros 2: " + numeros2[0] + " " + numeros2[1] + " " + numeros2[2] + " " + numeros2[3] + " " + numeros2[4]);
        System.out.println("Palos 2: " + palos2[0] + " " + palos2[1] + " " + palos2[2] + " " + palos2[3] + " " + palos2[4]);
        //hasta aca funciona tambien 

        //pasamos numeros a int
        int[] numerosInt = new int[5];
        for(int i=0; i<5; i++){
            numerosInt[i] = Integer.parseInt(numeros[i]);
        }
        System.out.println("Numeros int1: " + numerosInt[0] + " " + numerosInt[1] + " " + numerosInt[2] + " " + numerosInt[3] + " " + numerosInt[4]);
        //funciona

        int[] numerosInt2 = new int[5];
        for(int i=0; i<5; i++){
            numerosInt2[i] = Integer.parseInt(numeros2[i]);
        }
        System.out.println("Numeros int2: " + numerosInt2[0] + " " + numerosInt2[1] + " " + numerosInt2[2] + " " + numerosInt2[3] + " " + numerosInt2[4]);
        //funciona

        //ordeno los numeros
        Arrays.sort(numerosInt);
        Arrays.sort(numerosInt2);

        //escalera de color, poker, full, color, escalera, trio, doble pareja, pareja, carta alta
        //poker
        int p1=0,p2=0,f1=0,f2=0,c1=0,c2=0,e1=0,e2=0,t1=0,t2=0,dp1=0,dp2=0,p3=0,p4=0,c3=0,c4=0,e3=0,e4=0,t3=0,t4=0,ec1=0,ec2=0;
        if (numerosInt[0] == numerosInt[1] && numerosInt[1] == numerosInt[2] && numerosInt[3] == numerosInt[4]){
            System.out.println("POKER");
            p1 = 1;
        } else if (numerosInt2[0] == numerosInt2[1] && numerosInt2[1] == numerosInt2[2] && numerosInt2[3] == numerosInt2[4]){
            System.out.println("POKER");
            p2 = 1;
        }

        //full
        for (int i = 1; i < numerosInt.length; i++) {
            if (numerosInt[i] == 3) {
                for (int j = 1; j < numerosInt.length; j++) {
                    if (numerosInt[j] == 2) {
                        System.out.println("Full");
                        f1 = 1;
                    }
                }
            }
        } 
        for (int i = 1; i < numerosInt2.length; i++) {
            if (numerosInt2[i] == 3) {
                for (int j = 1; j < numerosInt2.length; j++) {
                    if (numerosInt2[j] == 2) {
                        System.out.println("Full");
                        f2 = 1;
                    }
                }
            }
        }     
        
        //color
        if (palos[0].equals(palos[1]) && palos[1].equals(palos[2]) && palos[2].equals(palos[3]) && palos[3].equals(palos[4])) {
            System.out.println("Color");
            c1 = 1;
        }

        if (palos2[0].equals(palos2[1]) && palos2[1].equals(palos2[2]) && palos2[2].equals(palos2[3]) && palos2[3].equals(palos2[4])) {
            System.out.println("Color");
            c2 = 1;
        }

        //escalera
        if (numerosInt[0]+1==numerosInt[1] && numerosInt[1]+1==numerosInt[2] && numerosInt[2]+1==numerosInt[3] && numerosInt[3]+1==numerosInt[4]){
            System.out.println("Escalera");
            e1 = 1;
        }
        if (numerosInt2[0]+1==numerosInt2[1] && numerosInt2[1]+1==numerosInt2[2] && numerosInt2[2]+1==numerosInt2[3] && numerosInt2[3]+1==numerosInt2[4]){
            System.out.println("Escalera");
            e2 = 1;
        }

        //escalera color
        if (e1 == 1 && c1 == 1){
            System.out.println("Escalera Color");
            ec1 = 1;
        }
        if(e2 == 1 && c2 == 1){
            System.out.println("Escalera Color");
            ec2 = 1;
        }

        //cuento cuantas veces aparece cada numero
        int[] cuenta = new int[13];
        for(int i=0; i<5; i++){
            cuenta[numerosInt[i]-1]++;
        }

        int[] cuenta2 = new int[13];
        for(int i=0; i<5; i++){
            cuenta2[numerosInt2[i]-1]++;
        }

        //trio
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i] == 3) {
                System.out.println("Trio");
                t1 = 1;
            }
        }
        for (int i = 0; i < cuenta2.length; i++) {
            if (cuenta2[i] == 3) {
                System.out.println("Trio");
                t2 = 1;
            }
        }

        //par doble
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i] == 2) {
                for (int j = 0; j < cuenta.length; j++) {
                    if (cuenta[j] == 2) {
                        System.out.println("Doble Par");
                        dp1 = 1;
                    }
                }
            }
        }
        for (int i = 0; i < cuenta2.length; i++) {
            if (cuenta2[i] == 2) {
                for (int j = 0; j < cuenta2.length; j++) {
                    if (cuenta2[j] == 2) {
                        System.out.println("Doble Par");
                        dp2 = 1;
                    }
                }
            }
        }

        //par
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i] == 2) {
                System.out.println("Par");
                p1 = 1;
            }
        }

        for (int i = 0; i < cuenta2.length; i++) {
            if (cuenta2[i] == 2) {
                System.out.println("Par");
                p2 = 1;
            }
        }

    
        //carta alta
        if (e1 != 1 && c1 != 1 && t1 != 1 && dp1 != 1 && p1 != 1 && numerosInt[4] > numerosInt[0]) {
            System.out.println("Carta Alta");
            int ca1 = 1;
        }

    
        if (e2 != 1 && c2 != 1 && t2 != 1 && dp2 != 1 && p2 != 1 && numerosInt2[4] > numerosInt2[0]) {
            System.out.println("Carta Alta");
            int ca2 = 1;
        }
        
        jugadas.add(m1);
        jugadas.add(m2);
        String ganadores = mc.ganadores(jugadas);
        System.out.println("Ganadores = " + ganadores);
    }
}