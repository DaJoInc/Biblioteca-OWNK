package com.ownk.libary;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaUtils {
	
	/**
	 * ------------------------
	 * obtenerListasDeArchivosAspirantesArchivoLibros
	 * ------------------------
	 * Metodo encargado de listar los archivos que tienen en una linea especifica el nombre del usuario y exactamente 3 lineas en su contenido
	 * @param rutaBiblioteca= Ubicación en la que se encontraran las carpetas que contienen los archivos a analizar.
	 * @param usuario= Nombre que sera comparado con cada linea de archivo hasta encontrar un igual en algun archivo.
	 * @return
	 */
		public List<String> obtenerListasDeArchivosAspirantesArchivoLibros(String rutaBiblioteca,String usuario) {
			
			List<String>recorrerCarpetasBiblioteca= new ArrayList<>();
			List<String>leerLineasDeArchivos= new ArrayList<>();
			List<String>listadoDeArchivosLibros= new ArrayList<>();
			List<String>listadoDeArchivosLibrosRutas= new ArrayList<>();
			int cuentaLineasArchivoLibros=0;
//			String archivoDentroDeCarpeta="";
			ArchivoUtils archivoUtils =new ArchivoUtils();
			if (rutaBiblioteca.endsWith(".txt")) {
				leerLineasDeArchivos=archivoUtils.leerLineaDeArchivoB(rutaBiblioteca);
				for (String contenidoLibro : leerLineasDeArchivos) {
					cuentaLineasArchivoLibros=leerLineasDeArchivos.size();
					if (cuentaLineasArchivoLibros==3&&leerLineasDeArchivos.get(2).equalsIgnoreCase(usuario)) {
//					System.out.println("Linea de libro: "+contenidoLibro);
					listadoDeArchivosLibros.add(rutaBiblioteca);
					}
				}
		for (String rutaLibro : listadoDeArchivosLibros) {
//			System.out.println("rutaLibro: "+rutaLibro);
			listadoDeArchivosLibrosRutas.add(rutaLibro);
		}
			}
			else{
				recorrerCarpetasBiblioteca=archivoUtils.archivosDeProyecto(rutaBiblioteca,recorrerCarpetasBiblioteca);
				for (String archivoDentroDeCarpeta : recorrerCarpetasBiblioteca) {
//					System.out.println("Archivo: "+archivoDentroDeCarpeta);
					leerLineasDeArchivos=archivoUtils.leerLineaDeArchivoB(archivoDentroDeCarpeta);
					cuentaLineasArchivoLibros=leerLineasDeArchivos.size();
					if (cuentaLineasArchivoLibros==3&&leerLineasDeArchivos.get(2).equalsIgnoreCase(usuario)) {
//						System.out.println("Linea de libro: "+archivoDentroDeCarpeta);
						listadoDeArchivosLibros.add(archivoDentroDeCarpeta);
					}
				}
			for (String rutaLibro : listadoDeArchivosLibros) {
				listadoDeArchivosLibrosRutas.add(rutaLibro);
				}
			}
		return listadoDeArchivosLibrosRutas;
	}
/**
 *   ------------------------
 * obtenerListasDeArchivosAspirantesArchivoLibros
 * ------------------------
 * Metodo encargado de listar los archivos que tienen más de tres lineas
 * @param rutaBiblioteca= Ubicación en la que se encontraran las carpetas que contienen los archivos a analizar.
 * @return
 */
		public List<String> obtenerListasDeArchivosAspirantesArchivoCapitulo(String rutaBiblioteca) {
			List<String>recorrerCarpetasBiblioteca= new ArrayList<>();
			List<String>leerLineasDeArchivos= new ArrayList<>();
			List<String>listadoArchivosCapitulo= new ArrayList<>();
			List<String>listadoArchivosCapituloRuta= new ArrayList<>();
			int cuentaLineasArchivoLibros=0;
			ArchivoUtils archivoUtils =new ArchivoUtils();
			if (rutaBiblioteca.endsWith(".txt")) {
				leerLineasDeArchivos=archivoUtils.leerLineaDeArchivoB(rutaBiblioteca);
				for (String contenidoCapitulo : leerLineasDeArchivos) {
					cuentaLineasArchivoLibros=leerLineasDeArchivos.size();
//					System.out.println("Linea de Capitulo: "+contenidoCapitulo);
					if (cuentaLineasArchivoLibros>3) {
						listadoArchivosCapitulo.add(rutaBiblioteca);
					}	
				}
		for (String rutaCapitulo : listadoArchivosCapitulo) {
			listadoArchivosCapituloRuta.add(rutaCapitulo);
	}	
			}
			else {
				recorrerCarpetasBiblioteca=archivoUtils.archivosDeProyecto(rutaBiblioteca,recorrerCarpetasBiblioteca);
				for (String archivoDentroDeCarpeta : recorrerCarpetasBiblioteca) {
					leerLineasDeArchivos=archivoUtils.leerLineaDeArchivoB(archivoDentroDeCarpeta);
					cuentaLineasArchivoLibros=leerLineasDeArchivos.size();
					if (cuentaLineasArchivoLibros>3) {
						listadoArchivosCapitulo.add(archivoDentroDeCarpeta);
					}
			}
			for (String rutaCapitulo : listadoArchivosCapitulo) {
				listadoArchivosCapituloRuta.add(rutaCapitulo);
				}
			}
		return listadoArchivosCapituloRuta;
	}
		/**
		 * --------------------
		 * crearArchivoIndiceLibro
		 * ---------------------
		 * Metodo encargado de crear la carpeta y el archivo que contendra el indice de archivo de salida.
		 */
		public boolean crearArchivoIndiceLibro(List<String>listaArchivosLibros,List<String>listaArchivosCapitulos,String rutaBiblioteca,String nombreDueño) {
			List<String>lineasArchivoLibro=new ArrayList<>();
			List<String>lineasArchivoCapitulo=new ArrayList<>();
			List<String>indice=new ArrayList<>();
			ArchivoUtils archivoUtils =new ArchivoUtils();
			CarpetasUtils carpetaUtils=new CarpetasUtils();
			lineasArchivoLibro=listaArchivosLibros;
			lineasArchivoCapitulo=listaArchivosCapitulos;
			indice.add("Indice");
			for (String libros : listaArchivosLibros) {
				lineasArchivoLibro=archivoUtils.leerLineaDeArchivoB(libros);
				indice.add(lineasArchivoLibro.get(0));
				for (String archivosCapitulos : listaArchivosCapitulos) {
					lineasArchivoCapitulo=archivoUtils.leerLineaDeArchivoB(archivosCapitulos);
					if (lineasArchivoCapitulo.get(1).equalsIgnoreCase(lineasArchivoLibro.get(1))) {
						indice.add(lineasArchivoCapitulo.get(0)+" __ Ruta de carpeta: "+archivosCapitulos);		
						for (int contadorSubtilulos = 3; contadorSubtilulos < lineasArchivoCapitulo.size(); contadorSubtilulos+=2) {
							indice.add(lineasArchivoCapitulo.get(contadorSubtilulos)+" __ Linea de Subtitulo: "+contadorSubtilulos);
							
						}
						carpetaUtils.crearCarpeta(nombreDueño, rutaBiblioteca);
						archivoUtils.crearArchivo(indice, lineasArchivoLibro.get(0), rutaBiblioteca+"/"+nombreDueño);	
					}
				}
				
			}
			
			return false;
		}
}