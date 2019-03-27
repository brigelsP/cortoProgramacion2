package Logic;

import java.util.ArrayList;

public class Control {
    
    //prohibición de instancia
    
    private Control(){}
    
    //llamada para ordenar base de alumnos.
    
    public static void ordenar(ArrayList<Alumno> dbase){
    
        System.out.println(dbase.size());
        
        mergeSort(0,dbase.size()-1,dbase,"");
    
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
            
            if(Alumno.compare(arrA[contA],arrB[contB]) < 0){            
                
                dbase.set(contC,arrA[contA]);
                
                contA++;
                contC++;
            
            }else{
                
                dbase.set(contC,arrB[contB]);
                
                contB++;
                contC++;
            }
        
        }
        
        //vaciado de arreglos auxiliares
        
        while(contA < sizeA){
        
            dbase.set(contC,arrA[contA]);
            
            contC++;
            contA++;
            
        }       
        
        while(contB < sizeB){
            
            dbase.set(contC,arrB[contB]);
            
            contC++;
            contB++;            
        
        }
        
    }
    
    //ordenamiento RECURSIVO
    
    private static void mergeSort(int inicio, int fin, ArrayList<Alumno> dbase, String space){
        
        System.out.println(space + inicio + " " + fin);
        
        if(inicio >= fin)
            return;
        
        int  size = fin - inicio + 1;
        
        int mid = inicio + (size/2) - 1;
        
        //divide el arreglo en dos
        //ordena esas dos mitades
        //combina esas dos mitades}
        //asi para todo subarreglo
        
        mergeSort(inicio, mid, dbase,space + " ");
        mergeSort(mid+1, fin, dbase,space + " ");
        
        merge(dbase,inicio,fin);
    
    }
    
    //busqueda binaria para carnet de alumno
    
     public static int buscar(String carnet, ArrayList<Alumno> dbase){
    
        int inicio = 0, fin = dbase.size() - 1;
        
        int mid;
        String key;
        
        while(inicio <= fin){
        
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
    
    //Agregar alumno
    
    public static void agregar(Alumno nuevo, ArrayList<Alumno> dbase){
    
        dbase.add(nuevo);
        
    }
    
    //eliminar Alumno
    
    public static boolean eliminar(String carnet, ArrayList<Alumno> dbase){
    
        int toDel = buscar(carnet, dbase);
        
        if(toDel == -1)
            return false;
        
        dbase.remove(toDel);
        
        return true;
    }
    
    //editar Alumno
    
    public static boolean editar(Alumno editado, ArrayList<Alumno> dbase){
    
        int toEdit = buscar(editado.getCarnet(),dbase);
        
        if(toEdit == -1)
            return false;
        
        dbase.remove(toEdit);
        dbase.add(toEdit,editado);
        
        return true;
        
    }
    
    public static void main(String args[]){
    
        ArrayList<Alumno> dbase  = new ArrayList<>();
        
        Alumno a = new Alumno("Luis", "Ramírez","9");
        Alumno b = new Alumno("Jose","Ramirez","9");
        Alumno c = new Alumno("Briggels", "Pacheco","6");
        Alumno d = new Alumno("Ernesto", "Cardona", "7");
        
        agregar(a,dbase);
        agregar(b,dbase);
        agregar(c,dbase);
        agregar(d,dbase);
        
        ordenar(dbase);
        
        System.out.println(dbase.size());
        
        for(int i = 0; i < dbase.size(); i++){
            
            System.out.println(dbase.get(i));
            
        }
        
        String search = dbase.get(1).getCarnet();
        int num = buscar(search,dbase);
        
        System.out.println(search + " " + num);
        
        eliminar(search,dbase);
        
        System.out.println();
               
        for(int i = 0; i < dbase.size(); i++){
            
            System.out.println(dbase.get(i));
            
        }
        
        Alumno editado = new Alumno("Jose","Peralta","10",dbase.get(1).getCarnet());
        
        editar(editado,dbase);
        System.out.println();
        
        for(int i = 0; i < dbase.size(); i++){
            
            System.out.println(dbase.get(i));
            
        }
    
    }
    
}
