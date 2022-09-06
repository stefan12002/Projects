import java.text.DecimalFormat;
import java.util.Scanner;

public class Cont {
Scanner scanner=new Scanner(System.in);
DecimalFormat formatBani=new DecimalFormat("'$'###,###.00");//pentru a imparti un numar in cate 3 cifre
    private int idClient,pinClient;
    private double contCurent,contEconomii;
//getteri setteri
    public int getIdClient() {
        return idClient;
    }

    public int getPinClient() {
        return pinClient;
    }

    public double getContCurent() {
        return contCurent;
    }

    public double getContEconomii() {
        return contEconomii;
    }

    public int setIdClient(int idClient) {
        this.idClient = idClient;
        return idClient;
    }

    public int setPinClient(int pinClient) {
        this.pinClient = pinClient;
    return pinClient;
    }

    //constructor

 public double retragereContCurent(double suma){
        contCurent=contCurent-suma;
        return  contCurent;
 }
    public double depunereContCurent(double suma){
        contCurent=contCurent+suma;
        return  contCurent;
    }
    public double retragereContEconomii(double suma){
        contEconomii=contEconomii-suma;
        return  contEconomii;
    }
    public double depunereContEconomii(double suma){
        contEconomii=contEconomii+suma;
        return  contEconomii;
    }
public void contCurentRetragere(){
    System.out.println("Balanta contului curent este: "+formatBani.format(contCurent));
    System.out.println("Suma pe care doriti sa o retrageti din Contul Curent: ");
    double suma= scanner.nextDouble();
    if(contCurent-suma>=0){
        retragereContCurent(suma);
        System.out.println("Noua balanta a Contului curent: "+formatBani.format(contCurent));
        System.out.println("Retragerea a fost efectuata cu succes");
    }
    else
    {
        System.out.println("Ne pare rau,fonduri indisponibile");
    }
    }
    public void contCurentDepunere(){
        System.out.println("Balanta contului curent este: "+formatBani.format(contCurent));
        System.out.println("Suma pe care doriti sa o depuneti in Contul Curent: ");
        double suma= scanner.nextDouble();
        depunereContCurent(suma);
            System.out.println("Noua balanta a Contului curent: "+formatBani.format(contCurent));
            System.out.println("Depunerea a fost efectuata cu succes");


    }
    public void contEconomiiDepunere() {
        System.out.println("Balanta contului de Economii este: " + formatBani.format(contEconomii));
        System.out.println("Suma pe care doriti sa o depuneti in Contul de Economii: ");
        double suma = scanner.nextDouble();
            depunereContEconomii(suma);
            System.out.println("Noua balanta a Contului de Economii: " + formatBani.format(contEconomii));
        System.out.println("Depunerea a fost efectuata cu succes");
    }
    public void contEconomiiRetragere() {
        System.out.println("Balanta contului de economii este: " + formatBani.format(contEconomii));
        System.out.println("Suma pe care doriti sa o retrageti din Contul de Economii: ");
        double suma = scanner.nextDouble();

        if (contEconomii - suma >= 0) {
            retragereContEconomii(suma);
            System.out.println("Noua balanta a Contului de Economii: " + formatBani.format(contEconomii));
            System.out.println("Retragerea a fost efectuata cu succes");
        } else {
            System.out.println("Ne pare rau,fonduri indisponibile");
        }

    }
    }
