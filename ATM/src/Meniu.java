import groovy.util.MapEntry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Meniu extends Cont {
    Scanner meniu=new Scanner(System.in);
DecimalFormat formatBani=new DecimalFormat("'$'###,###.00");
HashMap<Integer,Integer> data=new HashMap<Integer,Integer>();
    int selectie;

public void getLogin()throws IOException {
    int x=1;
    do {
        try{
            if(selectie==3)
                break;
            data.put(12345,1234);
            data.put(923,123);
            System.out.println("Bine ai venit la acest ATM");
            System.out.println("Introduceti numarul de utilizator: ");
            setIdClient(meniu.nextInt());
            System.out.println("Introduceti pin ul dumneavoastra: ");
            setPinClient(meniu.nextInt());
        }
        catch (Exception e){
            System.out.println("caracter invalid ");
        x=2;
        }
for(Entry<Integer,Integer>entry: data.entrySet())
{
    if(entry.getKey()==getIdClient()&&entry.getValue()==getPinClient()){
        getContulDorit();
    }
}
    }
    while(x==1);
}

   public void getContulDorit(){
       System.out.println("Selectati contul pe care doriti sa l accesati: ");
       System.out.println("Tastati 1: Contul curent");
       System.out.println("Tastati 2: Contul de economii");
       System.out.println("Tastati 3: Exit");
       System.out.println("Alegeti: ");
       selectie=meniu.nextInt();
       switch (selectie){
           case 1:
               getCurent();
               break;
           case 2:
               getEconomii();
               break;
           case 3:
               System.out.println("Multumim ca ati folosit acest ATM");
               break;
           default:
               System.out.println("Alegere incorecta");
            break;
       }
   }
public void getCurent(){
    System.out.println("Contul curent ");
    System.out.println("Tastati 1: Vedeti balanta");
    System.out.println("Tastati 2: Retrageti fonduri");
    System.out.println("Tastati 3: Depuneri fonduri");
    System.out.println("Tastati 4:Exit");
    System.out.println("Alegeti: ");
    selectie=meniu.nextInt();
    switch (selectie){
        case 1:
            System.out.println("Balanta contului curent: "+formatBani.format(getContCurent()));
            getContulDorit();
            break;
        case 2:
            contCurentRetragere();
            getContulDorit();
            break;
        case 3:
            contCurentDepunere();
            getContulDorit();
            break;
        case 4:
            getContulDorit();
            break;

        default:
            System.out.println("Alegere incorecta ");
            getContulDorit();

    }
}
public void getEconomii(){
    System.out.println("Contul de economii ");
    System.out.println("Tastati 1: Vedeti balanta");
    System.out.println("Tastati 2: Retrageti fonduri");
    System.out.println("Tastati 3: Depuneri fonduri");
    System.out.println("Tastati 4:Exit");
    System.out.println("Alegeti: ");
    selectie=meniu.nextInt();
    switch (selectie){
        case 1:
            System.out.println("Balanta contului de economii "+formatBani.format(getContEconomii()));
            getContulDorit();
            break;
        case 2:
            contEconomiiRetragere();
            getContulDorit();
            break;
        case 3:
            contEconomiiDepunere();
            getContulDorit();
            break;
        case 4:
            getContulDorit();
            break;
        default:
            System.out.println("Alegere incorecta ");
            getContulDorit();
    }

}
}
