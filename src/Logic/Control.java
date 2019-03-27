package Logic;

import java.util.ArrayList;

public class Control {
    
    //prohibición de instancia
    
    private Control(){}
    
    //llamada para ordenar base de alumnos.
    
    public static void ordenar(ArrayList<Alumno> dbase){
    
        mergeSort(0,dbase.size()-1,dbase);
    
    }
    
    //Combina dos subarreglos adyacentes ordenados en un arreglo ordenado
    
    private static void merge(ArrayList<Alumno> dbase, int inicio, int fin){
    
        //declaración de variables
        
        int size = fin - inicio + 1;
        
        int sizeA = size/2;
        int sizeB = size - sizeA;
        
        //arreglos auxiliares
        
        Alumno[] arrA = new Alumno[sizeA];
        Alumno[] arrB = new Alumno[sizeB];
        
        int contA;
        int contB;
        int contC;
        
        contA = contB = 0;
        contC = inicio;
        
        //llenado de arreglos auxiliares
        
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
        
        //llenado de arreglo principal
        
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
        
        //vaciado de arreglos auxiliares
        
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
    
    //ordenamiento RECURSIVO
    
    private static void mergeSort(int inicio, int fin, ArrayList<Alumno> dbase){
        
        if(inicio > fin)
            return;
    
        int  size = fin - inicio + 1;
        
        int mid = (size/2) - 1;
        
        //divide el arreglo en dos
        //ordena esas dos mitades
        //combina esas dos mitades}
        //asi para todo subarreglo
        
        mergeSort(inicio, mid, dbase);
        mergeSort(mid+1, fin, dbase);
        
        merge(dbase,inicio,fin);
    
    }
    
    //busqueda binaria para carnet de alumno
    
    public static int buscar(ArrayList<Alumno> dbase, String carnet){
    
        int inicio = 0, fin = dbase.size() - 1;
        
        int mid;
        String key;
        
        while(inicio < fin){
        
            mid = (inicio + fin)/2;
            key = dbase.get(mid).getCarnet();
            
            if(key.compareTo(carnet) < 0)
                inicio = mid+1;
            else if(key.compareTo(carnet) > 0)
                fin = mid-1;
            else 
                return mid;
        
        }
        
        return -1;
    }
    
    public static void agregar(Alumno nuevo, ArrayList<Alumno> dbase){
    
        dbase.add(nuevo);
        
        ordenar(dbase);
        
    }
    
}
