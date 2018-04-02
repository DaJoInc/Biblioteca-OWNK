package com.ownk.libary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtils {
	/**
	 * -------------
	 * archivosDeProyecto
	 * --------------
	 * Metodo Encargado de buscar todos los archivos que finalizen con .java de un proyecto y listar su respectiva ruta
	 * @param path= Ruta del proyecto que actua como inicializador del metodo.
	 * @param rutaArchivo=Lista que de manera recursiva se vuelve a llamar para usar el mismo espacio de memoria y llene de manera continua su contenido con rutas de archivos .java 
	 * @return
	 */
	public List<String> archivosDeProyecto(String path,List<String> rutaArchivo){
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) 
        {
            if (file.isFile())
            {
            	if (file.getName().trim().endsWith(".txt")) {
              		rutaArchivo.add(String.valueOf(file.getAbsolutePath()));
				}
            }
            else if (file.isDirectory())
            {
            	archivosDeProyecto(file.getAbsolutePath(),rutaArchivo);
            }
        }
        return rutaArchivo;
    }
	/**
	 * ----------------------------------------------------------------------
	 * listarUnaRutaIsFile
	 * -----------------------------------------------------------------------
	 * 	Metodo encargado de listar unicamente archivos de una ruta, es decir, que exceputara absolutamentte cualquier otro archivo que no sea .txt
	 * @param ruta: Ubicación tipo String que brinda la ruta que se recorrera
	 * @return
	 */
	public List<String> listarUnaRutaIsFile(String ruta){
		List<String> archivosEnUnaCarpeta = new ArrayList<String>();
		File archivos = new File(ruta);
		File[] ficheros = archivos.listFiles();
		for (File file : ficheros) {
			if(file.isFile()) {
//				System.out.println("Archivos: "+file.getName());
				archivosEnUnaCarpeta.add(file.getName());
			}
		}
		return archivosEnUnaCarpeta;
	}
	/**
	 * ----------------------------
	 * leerLineaDeArchivo
	 * ----------------------------
	 * leerLineaDeArchivo es el metodo que permite tomar la ruta de un archivo especifico y obtener de el un arreglo que se llenara con el contenido de cada archivo.
	 * @param rutaArchivo= Ruta donde se puede encontrar la carpeta del archivo especifico que se quiere leer.
	 * @param nombreDelArchivo= Nombre individual y unico del archivo que se va a leer(Se le puede pasar una ruta con el archivo a leer)
	 * @return
	 */
	public List<String>leerLineaDeArchivo(String rutaArchivo,String nombreDelArchivo){
		List<String>obtenerLineaArchivo = new ArrayList<>();
		List<String>listadoDeLineas = new ArrayList<>();
		File archivo = new File(rutaArchivo+"/"+nombreDelArchivo);
		FileReader fr;
		BufferedReader br;
		String siguientelinea="";
		if (rutaArchivo.equals(nombreDelArchivo)) {
			try {
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);
				
		        while((siguientelinea=br.readLine())!=null) {
		        	obtenerLineaArchivo.add(siguientelinea);
		        }
		        for (String lineasArchivo : obtenerLineaArchivo) {
		        	listadoDeLineas.add(lineasArchivo);
//	      	System.out.println("LineaOWNK: "+lineasArchivo);
		        	}
			 	}
			 catch (Exception e) {
				// TODO: handle exception
			 	}
		}
		else {
			try {
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);
				
		        while((siguientelinea=br.readLine())!=null) {
		        	obtenerLineaArchivo.add(siguientelinea);
		        }
		        for (String lineasArchivo : obtenerLineaArchivo) {
		        	listadoDeLineas.add(lineasArchivo);
//	      	System.out.println("LineaOWNK: "+lineasArchivo);
		        	}
			 	}
			 catch (Exception e) {
				// TODO: handle exception
			 	}
			
		}
		 
		 return listadoDeLineas;
		}
	/**
	 * ------------------------
	 * leerLineaDeArchivoB
	 * --------------------------
	 * Lectura de un archivo que trae su ruta como ubicador exacto, se suele usar para lista de rutas
	 * @param rutaArchivo=String que contiene ubicación exacta del archivo que se quiere leer
	 * @return
	 */
	public List<String>leerLineaDeArchivoB(String rutaArchivo){
		List<String>obtenerLineaArchivo = new ArrayList<>();
		List<String>listadoDeLineas = new ArrayList<>();
		File archivo = new File(rutaArchivo);
		FileReader fr;
		BufferedReader br;
		String siguientelinea="";
		 try {
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
	        while((siguientelinea=br.readLine())!=null) {
	        	obtenerLineaArchivo.add(siguientelinea);
	        }
	        for (String lineasArchivo : obtenerLineaArchivo) {
	        	listadoDeLineas.add(lineasArchivo);
//      	System.out.println("LineaOWNK: "+lineasArchivo);
	        	}
		 	}
		 catch (Exception e) {
			// TODO: handle exception
		 	}
		 return listadoDeLineas;
		}

/**
 * ------------------
 * Cear Archivo
 * -------------------
 *Se usa este metodo para crear un archivo txt, la ruta y el nombre servira para que concatenado se haga el nombre del archivo, además de que el contenido estara dado por la lista que traera el indice.
 * @param contenido=Esta cadena contendra los datos del indice
 * @param nombre=Nombre que podra ser concatenado para crear el archivo en una ruta especifica.
 * @param rutadestino=Ruta de carpeta  donde sera designado el archivo a guardar, la ruta se da por la carpeta que se llamara como el usuario. 
 * @return
 */
	public boolean crearArchivo(List<String>contenido, String nombre, String rutadestino) {
		FileWriter file=null;
		PrintWriter pw =null;
		String acumuladorLineasIndice="";
		try {
			 file = new FileWriter(rutadestino+"/"+nombre+".txt" );
			 pw = new PrintWriter(file);
		for (String datosdearchivo : contenido) {
			acumuladorLineasIndice=acumuladorLineasIndice+"\r"+"\n"+datosdearchivo; 
			
		}	 
		pw.println(acumuladorLineasIndice);
		 file.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}

