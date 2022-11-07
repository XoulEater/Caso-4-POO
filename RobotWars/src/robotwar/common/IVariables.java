package robotwar.common;

import java.util.ArrayList;
import java.util.List;

import robotwar.MeleSlam.Slam;
import robotwar.common.robotbase.Trap;
import robotwar.proyectiles.Proyectile;

public class IVariables {
	// Instancia del IVariables, aqui guardaremos su unica instancia 
    private static IVariables instance = null;
    
    // Aca podemos definir datos globales
    private List<Trap> arrayTraps;
	private List<Proyectile> arrayProyectiles;
	private List<Slam> arrayMeleSlams;
	private List<Integer> posPlayer1;
	private List<Integer> posPlayer2;
	private int index, index2;
    
    // Contructor privado, asi no se podra llamar desde fuera
    private IVariables()
    {
    	this.setArrayTraps(new ArrayList<>());
		this.arrayProyectiles = new ArrayList<>();
		this.arrayMeleSlams = new ArrayList<>();
		this.index = 0;
		this.index2 = 0;
    }
    
    // "Constructor publico"
    // Si es la primera vez que se llama crea una instancia nueva
    // De no ser así retorna la ya existente 
    public static synchronized IVariables getInstance()
    {
        if (instance == null)
        	instance = new IVariables();
  
        return instance;
    }
    
    public void addTrap(Trap pTrap) {
		getArrayTraps().add(pTrap);
	}
    public void addProyectile(Proyectile pProyectile) {
    	pProyectile.setIndex(index);
    	index++;
    	arrayProyectiles.add(pProyectile);
	}

	public List<Proyectile> getArrayProyectiles() {
		return arrayProyectiles;
	}
	
	public void arrayMeleSlams(Slam pSlams) {
		pSlams.setIndex(index2);
		index2++;
    	arrayMeleSlams.add(pSlams);
	}

	public List<Slam> getArrayMele() {
		return arrayMeleSlams;
	}

	public void setArrayProyectiles(List<Proyectile> arrayProyectiles) {
		this.arrayProyectiles = arrayProyectiles;
	}

	public  List<Trap> getArrayTraps() {
		return arrayTraps;
	}

	public void setArrayTraps(List<Trap> arrayTraps) {
		this.arrayTraps = arrayTraps;
	}
	

	// Igualmente se pueden añadir mas metodos y variables 
}

