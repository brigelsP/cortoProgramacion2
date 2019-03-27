package Logic;
public class Alumno {
    private String nombre;
    private String apellido;
    private String grado;
    private String carnet;
    
    private Alumno(){}

    public Alumno(String nombre, String apellido, String grado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.carnet = generate(nombre,apellido,grado);
    }
    
    //Getters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGrado() {
        return grado;
    }

    public String getCarnet() {
        return carnet;
    }

    //Seters
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    //Generador de carnet con correlativo
    
    private static int rel = 0;
    
    public static String generate(String nombre, String apellido, String grado){
    
        nombre = nombre.toLowerCase();
        apellido = apellido.toLowerCase();
        
        return grado + nombre.charAt(0) + apellido.charAt(0) + String.valueOf(rel++);
    
    }
    
    public static int compare(Alumno a, Alumno b){
        
        int k = a.getCarnet().compareTo(b.getCarnet());
        
        return k;
        
    }
    
    
}
