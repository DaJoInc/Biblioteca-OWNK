package com.ownk.libary;

import java.awt.LinearGradientPaint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CarpetasUtils {
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
              		rutaArchivo.add(String.valueOf(file.getName()));
              		System.out.println(file.getName());
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
	 * --------------
	 * listaArchivosEnCarpeta
	 * --------------
	 * Metodo encargado de listar archivos que hayan en una carpeta especifica
	 * @param rutaCarpeta: ruta de la carpeta epecifica a la que se le recorreran sus archivos
	 * @return
	 */
	public List<String> listaArchivosEnCarpeta(String rutaCarpeta){
		List<String> listaArchivos = new ArrayList<String>();
				
				String sDirectorio = rutaCarpeta;
				File f = new File(sDirectorio);
				
					File[] ficheros = f.listFiles();
					for (int x=0;x<ficheros.length;x++){
						listaArchivos.add(ficheros[x].getName());
					}
					return listaArchivos;
				}
	
	/**
	 * -----------
	 * crearCarpeta
	 * ---------------
	 * Se crea una carpeta donde el usuario tenga su biblioteca, esta carpeta tendra como nombre, el nombre del usuario
	 * @param dueño:Nombre que se le dara a la carpeta que sera creada
	 * @param ruta: ruta de biblioteca donde sera creada la carpeta
	 * @return
	 */
	public boolean crearCarpeta(String dueño,String ruta) {
		
		File directorioIndice=new File(ruta,dueño);
		
		if (!directorioIndice.exists()) {
			directorioIndice=new File(ruta,dueño); 
			directorioIndice.mkdir();
			System.out.println("Se creo la carpeta "+dueño+" en la ruta:"+ruta);
			return true;
		}

		return false;
	}

}
