/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.NominayComisiones;

import java.text.DecimalFormat;

/**
 *
 * @author robyn
 */
public class ClsNomina {
    private static String [][] nc = new String[6][10];
    
    private static final int EN=1;
    private static final int FEB=2;
    private static final int MAR=3;
    private static final int ABR=4;
    private static final int TOT=5;
    private static final int TOTV=5;
    private static final int COM=6;
    private static final int TVC=7;
    private static final int ISR=8;
    private static final int LIQ=9;
    
    private static  DecimalFormat d = new DecimalFormat("###.##"); 
    
    public static void DatosMatriz(){
       
        //nombres de los empleados
        nc[0][0]="Axel Santiago\t";
        nc[1][0]="Marlen Vega\t";
        nc[2][0]="Yesica Arroyo\t";
        nc[3][0]="Sebas Barcenas\t";
        nc[4][0]="Robyn Orellana\t";
        nc[5][0]="TOTALES\t";
        
        //Mes de enero
        nc[0][1]="500";
        nc[1][1]="390";
        nc[2][1]="679";
        nc[3][1]="489";
        nc[4][1]="1700";
        
        //Febrero
        nc[0][2]="650";
        nc[1][2]="240";
        nc[2][2]="530";
        nc[3][2]="400";
        nc[4][2]="190";
        
        //Marzo
        nc[0][3]="95";
        nc[1][3]="400";
        nc[2][3]="520";
        nc[3][3]="500";
        nc[4][3]="460";
        
        //Abril
        nc[0][4]="85";
        nc[1][4]="500";
        nc[2][4]="600";
        nc[3][4]="489";
        nc[4][4]="300";
       
        
    }
    
    public static void totalesInferiores(){
        int te=0, tf=0, tm=0, ta=0, tv=0;
        double comi=0, totvc=0, isr=0, liq=0;
        for (int i = 0; i < 5; i++) {
             
             te=te+Integer.parseInt(nc[i][EN]);
             tf=tf+Integer.parseInt(nc[i][FEB]);
             tm=tm+Integer.parseInt(nc[i][MAR]);
             ta=ta+Integer.parseInt(nc[i][ABR]);
             tv=tv+Integer.parseInt(nc[i][TOTV]);
             comi=comi+Double.parseDouble(nc[i][COM]);
             totvc=totvc+Double.parseDouble(nc[i][TVC]);
             isr=isr+Double.parseDouble(nc[i][ISR]);
             liq=liq+Double.parseDouble(nc[i][LIQ]);
            }
        
        nc[TOT][EN]= String.valueOf(te);
        nc[TOT][FEB]= String.valueOf(tf);
        nc[TOT][MAR]= String.valueOf(tm);
        nc[TOT][ABR]= String.valueOf(ta);
        nc[TOT][TOTV]=String.valueOf(tv);
        nc[TOT][COM]=String.valueOf(d.format(comi));
        nc[TOT][TVC]=String.valueOf(d.format(totvc));
        nc[TOT][ISR]=String.valueOf(d.format(isr));
        nc[TOT][LIQ]=String.valueOf(d.format(liq));

    }
    
    public static void totalVentas(){
       int total = 0;
         for (int i = 0; i < 5; i++) {
             total = Integer.parseInt(nc[i][EN]);
             total = total + Integer.parseInt(nc[i][FEB]);
             total = total + Integer.parseInt(nc[i][MAR]);
             total = total + Integer.parseInt(nc[i][ABR]);
             
             nc[i][TOTV]=String.valueOf(total);
             
         }
        
    }
    
    public static void comisiones(){
        double com=0, cal=0;
       
        for (int i = 0; i < 5; i++) {
            com=Double.parseDouble(nc[i][TOTV]);
            if (com>2000) {
                cal=com*0.35;
                nc[i][COM]=String.valueOf(d.format(cal));
                
            }
            else{
                cal=com*0.20;
                nc[i][COM]=String.valueOf(d.format(cal));
            }
            
        }
    }
    
    public static void totalVC(){
      double sumat=0, sumav=0, sumac=0;
        for (int i = 0; i < 5; i++) {
            sumav=Double.parseDouble(nc[i][TOTV]);
            sumac=Double.parseDouble(nc[i][COM]);
            sumat=sumav+sumac;
            nc[i][TVC]=String.valueOf(d.format(sumat));
        }
    }
    
    public static void isr(){
        double tv=0, isr=0;
        for (int i = 0; i < 5; i++) {
            
            tv=Double.parseDouble(nc[i][TVC]);
            isr=tv*0.05;
            nc[i][ISR]=String.valueOf(d.format(isr));
        }
        
    }
    
    public static void liquido(){
        double ci=0, tvc=0, li=0;
        for (int i = 0; i < 5; i++) {
            tvc=Double.parseDouble(nc[i][TVC]);
            ci=Double.parseDouble(nc[i][ISR]);
            li=tvc-ci;
            nc[i][LIQ]=String.valueOf(d.format(li));
        }
    }
    
    public static void vendedor(){
        double ven=0, cont=0;
        String p="";
        for (int i = 0; i < 5; i++) {
            cont=Double.parseDouble(nc[i][LIQ]);
            
            if (cont>ven) {
                ven=cont;
                p=nc[i][LIQ-9];
            }
            else{
                cont=cont;

            }
        }
        
        System.out.println("El vendedor que mas recibio es: " + p);
    }
    
    public static void vendedorMenor(){
        double ven=100, cont=0;
        String p="";
        ven=Double.parseDouble(nc[5][LIQ]);
        for (int i = 0; i < 5; i++) {
            cont=Double.parseDouble(nc[i][LIQ]);
            
            if (cont<ven) {
                ven=cont;
                p=nc[i][LIQ-9];
            }
            else{
                cont=ven;
            }
        }
        
        System.out.println("El vendedor que menos recibio es: " + p);
    }
    
    public static void imprimirDecorado(){
        for (int x = 0; x < nc.length; x++) {
            System.out.print("|");
            for (int y = 0; y < nc[x].length; y++) {
                System.out.print(nc[x][y]);
                if (y != nc[x].length -1) {
                    System.out.print("\t\t");
                }
            }
            System.out.println("|");
        }
        
    }
    
    
    public static void main(String[] args) {
        DatosMatriz();
        totalVentas();
        comisiones();
        totalVC();
        isr();
        liquido();
        totalesInferiores();
        imprimirDecorado();
        vendedor();
        vendedorMenor();
    }
    
    
}
