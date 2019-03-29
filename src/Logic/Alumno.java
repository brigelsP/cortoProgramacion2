package Logic;

public class Alumno {
    private String nombre;
    private String apellido;
    private String grado;
    private String carnet;
    public static int rel = 0;
    
    private Alumno(){}

    public Alumno(String nombre, String apellido, String grado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.carnet = generate(nombre,apellido,grado);
    }
    
    public Alumno(String nombre, String apellido, String grado, String carnet) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado = grado;
        this.carnet = carnet;
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
    
    public void setCarnet(String carnet){     
        this.carnet = carnet;
    }
    
    //Generador de carnet con correlativo    
    public static String generate(String nombre, String apellido, String grado){
    
        nombre = nombre.toUpperCase();
        apellido = apellido.toUpperCase();
        
        return nombre.charAt(0) + "" + apellido.charAt(0) + "" + grado;
    
    }
    
    public static int compare(Alumno a, Alumno b){
        
        int k = a.getCarnet().compareTo(b.getCarnet());
        
        return k;
        
    }
    
    @Override
    public String toString(){
        
        String res = this.nombre + " " + this.apellido + ": " + this.carnet;
        
        return res;
        
    }
    
}
