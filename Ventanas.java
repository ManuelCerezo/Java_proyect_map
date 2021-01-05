import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.imageio.ImageIO;

public  class Ventanas extends Clase_Compartida{
	

	//-----------------ATRIBUTOS VENTANA PRINCIPAL PICCHAS-----------------------------
	static int opcion;
	JFrame ventana ;
	JPanel panel ;
	JLabel lb1 ;
	JLabel lb2 ;
	JLabel lb3 ;
	JLabel lb4 ;
	JLabel lb5 ;
	JLabel lb6 ;
	JLabel lATR;
	JLabel lInfo;
	JLabel lNombre;
	JLabel lLoc;
	JLabel lBol;
	JButton bOK ;
	JButton bCANCER;
	JTextField tf;
	JTextField tfNombre;
	JTextField tfBolsillo;
	JTextField tfLoc;
	static JTextArea tfInfo;
		
	public void ventanaPrincipal(){
		//Funcion para inicializar la ventana.
		inicVentPrin(); 
		ventana.setVisible(true);
		
	}
	public void ActBcancelar(){
		ActionListener pulCan = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){
				tf.setText("");
			}
			
		};
		//Añadimos el evento de escucha
		bCANCER.addActionListener(pulCan);
		
	}
	public void obmenu() {
		//Agregacion de evento Action Listener.
		
		ActionListener pulPrin = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){
				//int op=0;
				opcion = Integer.parseInt(tf.getText());
				tf.setText("");
				//Ronda.setOp(opcion);
				System.out.println("La opcion es: "+(opcion));
			}
			
		};
		//Añadimos el evento de escucha
		bOK.addActionListener(pulPrin);
	}
	private void inicVentPrin() {
		
		int height=0;
		int width=0;
		
		//INICIALIZAMOS LOS ATRIBUTOS
		 opcion = 0;
		 ventana = new JFrame("MENU PRINCIPAL");
		 panel = new JPanel(); //Esto es lo mismo que un Div en HTML
		 lb1 = new JLabel("MENU PRINCIPAL");
		 lb2 = new JLabel("1. Mover a otra localizacion");
		 lb3 = new JLabel("2. Coger un objeto");
		 lb4 = new JLabel("3. Dejar un objeto");
		 lb5 = new JLabel("4. Intercambiar un objeto");
		 lb6 = new JLabel("SELECCIONE OPCION:");
		 lATR = new JLabel("ATRIBUTOS");
		 lNombre = new JLabel("Nombre Jugador:");
		 lLoc = new JLabel("Localizacion Jugador:");
		 lBol = new JLabel("Bolsillo Jugador:");
		 lInfo = new JLabel("INFORMACION");
		 bOK = new JButton("OK");
		 bCANCER = new JButton("Cancelar");
		 tf = new JTextField(4);
		 tfNombre = new JTextField(10);
		 tfBolsillo =  new JTextField(10);
		 tfLoc = new JTextField(10);
		 tfInfo =  new JTextArea();
		 
		 //DIMENSION DE PANTALLA -- POSICIONAMIENTO
		 Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); //Obtener la dimension de la pantalla
		 height = pantalla.height;
		 width = pantalla.width;
		 ventana.setSize(width/3, ((height/3)+30)); //Situacionar la pantalla
		 ventana.setLocationRelativeTo(null); //Situar la ventana en medio de la pantalla
		 
		 
		 actCordenadas();
		 aniadirpanel();
		 aniadirVent();
		
		 ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Opcion para que cierre el programa cuando se cierra la ventana. [X]
		 
	}
	private void aniadirVent() {
		ventana.getContentPane().add(panel); //Agregamos el panel a la ventana
	}
	private void aniadirpanel() {
		panel.add(lb1); //Incluimos los labels en dentrod el Panel
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);
		panel.add(lb6);
		panel.add(tf);
		panel.add(bCANCER);
		panel.add(bOK);
		panel.add(tfNombre);
		panel.add(tfLoc);
		panel.add(lNombre);
		panel.add(lATR);
		panel.add(lLoc);
		panel.add(lInfo);
		panel.add(tfInfo);
		panel.add(lBol);
		panel.add(tfBolsillo);
	}
	
	private void actCordenadas() {
		/*lb1.setLayout(null); //Desactivamos los layouts
	    lb2.setLayout(null);
	    lb3.setLayout(null);
	    lb4.setLayout(null);
	    lb5.setLayout(null);
	    lb6.setLayout(null);*/
	    
	    panel.setLayout(null); //Solamente hace falta desactivar el Layout del Panel
	    
	    //DEFINICION DE POSICION : X , Y , ANCHURA, ALTURA
	    lb1.setBounds(50, 10, 150, 20); // "Menu principal"
	    lATR.setBounds(330, 10, 150, 20);
	    lb2.setBounds(30, 30, 200, 20);
	    lb3.setBounds(30, 50, 150, 20);
	    lb4.setBounds(30, 70, 150, 20);
	    lb5.setBounds(30, 90, 150, 20);
	    lb6.setBounds(30, 120, 150, 20); // "Seleccione una opcion"
	    tf.setBounds(170, 120, 30, 20);
	    tfNombre.setBounds(370, 40, 100, 20);
	    lNombre.setBounds(265,40 ,150 , 20);
	    tfLoc.setBounds(370, 70, 100, 20);
	    lLoc.setBounds(240, 70, 150, 20);
	    bOK.setBounds(30, 150, 90, 20);
	    bCANCER.setBounds(110, 150, 90, 20);
	    
	    lBol.setBounds(268,100,150,20);
	    tfBolsillo.setBounds(370,100,100,20);
	    
	    lInfo.setBounds(330,130,150,20);
	    tfInfo.setBounds(270,160,200,100);
	  
	}
	
	public static void borrInfo() {
		tfInfo.setText("");
	}
	public static void setInfo(String palabra) {
		tfInfo.setText(palabra);
	}
	public void setBolsi() {
		tfBolsillo.setText(jugador.getBolsillo());
	}
	public void setNomb(){
		tfNombre.setText(jugador.getNombre());
	}
	public void setLoc() {
		tfLoc.setText(jugador.getLocalizacion());
	}
	
	public static int getOpcion() {
		return opcion;
	}
	public static void setOpcion(int opcion) {
		Ventanas.opcion = opcion;
	}
	public static void limpiezaOpcion() {
		Ventanas.opcion = 0;
	}
	
	
}