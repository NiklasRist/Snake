import java.util.Random;

public class Steuerung{
    public static void main(String[] args) throws Exception {
        char feld[][]= new char[11][41];
        Random rand = new Random();
        boolean apfel = false;
        int counter = 0;
        int posKopf []= {5,20};
        int richtung[] = {-1,0};
        
        neuesSpielfeld(feld, posKopf);
        while(true){
            if(apfel==false){
                spawnApfel(feld, rand);
                apfel = true;
            }
            if(counter==200000000){ 
                aktualisiereSpielfeld(feld, apfel, rand, posKopf, richtung);
                zeigeSpielfeld(feld);
            }
            counter=(counter+1)%200000001;
            
        }
    }

    static void neuesSpielfeld(char [][] feld,int posKopf[]){
        for(int i = 0;i < feld.length;i++){
            for(int j = 0; j < feld[i].length;j++){
                if(i == 0 || i == 10 || j == 0  || j == 40){
                    feld[i][j] = '#';
                }else{
                    if(i==5&&j==20){
                        feld[i][j] = 'O';
                        posKopf [0] = 5;
                        posKopf [1] = 20;
                    }else{
                        feld[i][j] = ' ';
                    }
                }
                System.out.print(feld[i][j]);
            }
            System.out.println("");
        }
        
    }

    static void spawnApfel(char [][] feld, Random rand){
        int i , j;
        i=rand.nextInt(8)+1;
        j=rand.nextInt(38)+1;
        feld[i][j]='*';
        
    }
    static void zeigeSpielfeld(char [][] feld){
        for(int i = 0;i < feld.length;i++){
            for(int j = 0; j < feld[i].length;j++){
                System.out.print(feld[i][j]);
            }
            System.out.println("");
        }
    }
    static void aktualisiereSpielfeld(char [][] feld,boolean apfel, Random rand,int [] position, int [] richtung){
        if(apfel==false){
            spawnApfel(feld, rand);
            apfel = true;
        }
        feld[position[0]][position[1]] = ' ';
        bewegungUmVektor(position, richtung);
        feld[position[0]][position[1]] = 'O';
        
    }
    static void bewegungUmVektor(int [] position, int [] richtung){
        for(int i = 0;i<position.length;i++){
            position[i] += richtung[i];
        }
        if(position[0]==0){
            position[0]=9;
        }
        if(position[0]==10){
            position[0]=1;
        }
        if(position[1]==0){
            position[1]=39;
        }
        if(position[1]==40){
            position[1]=1;
        }

    }
    
}
