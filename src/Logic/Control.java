package Logic;

import java.util.ArrayList;

public class Control {
    
    private Control(){}
    
    public static void ordenar(ArrayList<Alumno> dbase){
    
        mergeSort(0,dbase.size()-1,dbase);
    
    }
    
    private static void merge(ArrayList<Alumno> dbase, int inicio, int fin){
    
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
        
        while(contA < sizeA){
        
            dbase.remove(contC);
            dbase.add(contC,arrA[contA]);
            
            contC++;
            contA++;
            
        }       
        
        while(contB < sizeB){
        
            dbase.remove(contC);
            dbase.add(contC,arrB[contB]);
            
            contC++;
            contB++;            
        
        }
        
    }
    
    private static void mergeSort(int inicio, int fin, ArrayList<Alumno> dbase){
        
        if(inicio > fin)
            return;
    
        int  size = fin - inicio + 1;
        
        int mid = (size/2) - 1;
        
        mergeSort(inicio, mid, dbase);
        mergeSort(mid+1, fin, dbase);
        
        merge(dbase,inicio,fin);
    
    }
    
    
    
}
