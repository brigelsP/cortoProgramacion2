package Logic;

import java.util.ArrayList;

public class Control {
    
    private Control(){}
    
    public static void ordenar(ArrayList<Alumno> dbase){
    
        
    
    }
    
    private static void Merge(ArrayList<Alumno> dbase, int inicio, int fin){
    
        int size = fin - inicio + 1;
        
        int sizeA = size/2;
        int sizeB = size - sizeA;
        
        Alumno[] arrA = new Alumno[sizeA];
        Alumno[] arrB = new Alumno[sizeB];
        
        int contA;
        int contB;
        int contC;
        
        contA = contB = 0;
        contC = inicio;
        
        while(contA < sizeA){
        
            arrA[contA] = dbase.get(contC);
            
            contA ++;
            contC ++;
        
        }
        
        while(contB < sizeB){
        
            arrB[contB] = dbase.get(contC);
            
            contB ++;
            contC ++;
        
        }
        
        
        contA = contB = 0;
        contC = inicio;
        
        while(contA < sizeA && contB < sizeB){
            
            dbase.remove(contC);
            
            if(Alumno.compare(arrA[contA],arrB[contB]) < 0){            
                
                dbase.add(contC,arrA[contA]);
                
                contA++;
            
            }else{
                
                dbase.add(contC,arrB[contB]);
                
                contB++;
            
            }
        
        }
        
        
        
        
        
    }
    
}
