package agenda;

public class Agenda {	
	//Atributos
	Contacto[] registro;	
	
	//Metodos Constructores
	public Agenda(int tamaño_agenda){
		this.registro= new Contacto[tamaño_agenda]; 
	}
	
	public Agenda(){
		this.registro= new Contacto[12]; 
	}	
	
	
	//Metodo insertar contactos
	public void setContacto(Contacto c){		
		int indice=buscar_indice_vacio();
		for(int i=0;i<(this.registro).length;i++){
			if(indice<0){
				System.out.println("");
				System.out.println("Advertencia: Agenda llena!");
			}else {
				this.registro[indice]=c;
			}
		}
	}
	
	//Buscar un vacio
	private int buscar_indice_vacio() {		
		int indice=0;		
		while(this.registro[indice]!=null){			
			indice++;
			if(indice > (this.registro).length-1){
				return -1;
			}				
		}		
		return indice;				
	}
	
	//Metodo listar contactos
	public void listarContactos(){
		System.out.println("");
		System.out.println("Lista de contactos");
		for(int i=0;i<(this.registro).length;i++){
			if(this.registro[i]!=null){
				System.out.println("");
				System.out.println("Contacto: "+(i+1));
				(this.registro[i]).DatosContacto();
			}
		}			
	}
	 
	//Metodo buscar contacto
	public void buscarContactos(String nombre) {
		boolean encontrado=false;
		 for (int i=0;i<registro.length;i++) {
			 if (!encontrado && this.registro[i]!=null && registro[i].getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("");
				System.out.println("Contacto: "+(i+1));
				(this.registro[i]).DatosContacto();
				encontrado=true;
			 }
		 }
		 if (!encontrado) {
			 System.out.println("No se ha encontrado el contacto ingresado");
		 }
	}
	
	//Metodo eliminar contacto
	public void eliminarContacto(String nombre) {
		boolean encontrado=false;
		for (int i=0;i<registro.length;i++) {
			if (!encontrado && this.registro[i]!=null && this.registro[i].getNombre().equalsIgnoreCase(nombre)) {
				this.registro[i]=null;
				encontrado=true;
			}
		}
		if (!encontrado) {
			System.out.println("El contacto ingresado no existe");
		}
	}
	
	//Metodo editar contacto
	public void editarContacto(int indice,Contacto newc) {
		if (indice>0 && indice<=this.registro.length) {
			this.registro[indice-1]=newc;
		}else {
			 System.out.println("El contacto ingresado no existe");
			 }
	}
	}	