package com.ownk.libary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrquestadorBiblioteca {
	

	private static Scanner nameUser;
	private static Scanner directory;

	/**
	 * Orquesta toda la logica que se ha creado 
	 * @param args= Main donde residen los metodos que contendran la logica.
	 */
	public static void main(String[] args){
		String rutaBiblioteca="";
		String nombreUsuario="";
		System.out.println("!Bienvenido a el Generador de Indices de OWNK SAS¡"+"\n"+"||||||||||||||||||||||||||||||||||||||||||||||||||"+"\n"+"Digite los datos que se le indican para comenzar el proceso"+"\n"+"Ruta de su Biblioteca");
		directory = new Scanner(System.in);
		rutaBiblioteca= directory.nextLine(); 
		System.out.println("Nombre de la persona dueña de algun libro en la biblioteca");
		nameUser = new Scanner(System.in);
		nombreUsuario= nameUser.nextLine(); 
		BibliotecaUtils biblitecaUtils=new BibliotecaUtils();
		CarpetasUtils carpetaUtils=new CarpetasUtils();
		List<String> listaArchivosLibro=new ArrayList<>();
		List<String> rutaArchivos=new ArrayList<>();
		List<String> listaArchivosCapitulo=new ArrayList<>();
		rutaArchivos=carpetaUtils.listaArchivosEnCarpeta(rutaBiblioteca);
		for (String listadoCarpetas : rutaArchivos) {
			listaArchivosLibro=biblitecaUtils.obtenerListasDeArchivosAspirantesArchivoLibros(rutaBiblioteca+"/"+listadoCarpetas, nombreUsuario);
			listaArchivosCapitulo=biblitecaUtils.obtenerListasDeArchivosAspirantesArchivoCapitulo(rutaBiblioteca+"/"+listadoCarpetas);
			biblitecaUtils.crearArchivoIndiceLibro(listaArchivosLibro, listaArchivosCapitulo, rutaBiblioteca, nombreUsuario);
		}
		System.out.println("Su proceso ha finalizado, gracias vuelva pronto");		
	}
}