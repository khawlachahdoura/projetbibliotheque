package application;

import java.sql.*;

import java.util.Scanner;
 
import Business.*;
import Entities.*;
import ImpDAO.*; 

public class Main {

	static boolean test = true;
	static int val;
	static Scanner sc = new Scanner(System.in);
	static GererLivre gLivre = new GererLivre(new ImpDAOGererLivre());

	static GererNouveauEmprunt gEmprunt = new GererNouveauEmprunt(new ImpDAOGererNouveauEmp());

	public static void main(String[] args) {

		while (test) {

			menu();
		}

	}

	private static void supprimerEmprunt() {
		System.out.println("Veuillez saisir un id de emprunt pour le supp :");
		int idEmprunt = Integer.parseInt(sc.nextLine());

		System.out.println("Voulez-vous vraiment supprimer cette emprunt(y/n)?");
		String reponse = sc.nextLine();

		if (reponse.equals("y")) {
			boolean test = gEmprunt.deleteEmprunt(idEmprunt);
			if (test) {
				System.out.println("Emprunt supprimer avec sucées");
			} else {
				System.out.println("Il y un probleme lors de sppruimer d'un emprunt:" + idEmprunt);
			}
		} else {
			if (reponse.equals("n")) {

				System.out.println("OK");

			}
		}

	}

	private static void modifierIDEtudiant() {
		System.out.println("Veuillez de saisir un idEmpt de l'emprunt qui veut modifier :");
		int idEmpt = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau id etudiant  :");

		int nbIDEtudiant = Integer.parseInt(sc.nextLine());

		boolean test = gEmprunt.modifieridEtudiant(idEmpt, nbIDEtudiant);
		if (test) {
			System.out.println("Modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un emprunt:" + idEmpt);
		}

	}

	private static void modifieridExemplaire() {
		System.out.println("Veuillez de saisir un idEmpt de l'emprunt qui veut modifier :");
		int idEmpt = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau id Exemplaire  :");

		int nvIDExemplaire = Integer.parseInt(sc.nextLine());

		boolean test = gEmprunt.modifieridExemplaire(idEmpt, nvIDExemplaire);
		if (test) {
			System.out.println("Modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un emprunt:" + idEmpt);
		}

	}

	private static void modifierDateRet() {
		System.out.println("Veuillez de saisir un idEmpt de l'emprunt qui veut modifier :");
		int idEmpt = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau date retour  :");

		String vdate_RE = sc.nextLine();
		Date nvDateRet = Date.valueOf(vdate_RE);

		boolean test = gEmprunt.modifierDateRet(idEmpt, nvDateRet);
		if (test) {
			System.out.println("Modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un emprunt:" + idEmpt);
		}

	}

	private static void modifierDateEmp() {
		System.out.println("Veuillez de saisir un idEmpt de l'emprunt qui veut modifier :");
		int idEmpt = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau date emprunt :");

		String vdate_E = sc.nextLine();
		Date nvDateEmp = Date.valueOf(vdate_E);

		boolean test = gEmprunt.modifierDateEmp(idEmpt, nvDateEmp);
		if (test) {
			System.out.println("Livre modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un emprunt:" + idEmpt);
		}

	}

	private static void ajouterEmprunt() {

		System.out.println("Veuillez saisir DateEmprunt (YYYY-MM-JJ) :");
		String vdate_E = sc.nextLine();
		Date date_E = Date.valueOf(vdate_E);

		System.out.println("Veuillez saisir Date de retour (YYYY-MM-JJ):");
		String vdate_RE = sc.nextLine();
		Date date_RE = Date.valueOf(vdate_RE);
		
		while(!comparDate(date_E,date_RE)) {
			ajouterEmprunt();
		}

		System.out.println("Veuillez saisir idExemplaire :");
		int idEtudiant = Integer.parseInt(sc.nextLine());

		System.out.println("Veuillez saisir idEtudiant :");
		int idExemplaire = Integer.parseInt(sc.nextLine());

		Emprunt emprunt = new Emprunt(idExemplaire, idEtudiant, date_E, date_RE,0);

		boolean test = gEmprunt.addEmprunt(emprunt);
		if (test) {
			System.out.println("Livre emprunt avec sucées");
		} else {
			System.out.println("Il y un probleme lors d'ajouter d'un emprunt:" + emprunt.getIdEmprunt());
		}

	}

	private static boolean comparDate(Date date_E, Date date_RE) {
		if(date_E.compareTo(date_RE) > 0) {
	         System.out.println("date_E  apres date_RE");
	         return false;
	      } else if(date_E.compareTo(date_RE) == 0) {
	         System.out.println(" date_E=date_RE ");
	         return false;
	      }  
		return true;
		
	}

	private static void exit() {
		System.out.println("Merci ");
		test = false;

	}

	// gerer livre

	private static void supprimerLivre(GererLivre gLivre, Scanner sc) {

		System.out.println("Veuillez saisir un isbn de livre pour le supp :");
		int isbn = Integer.parseInt(sc.nextLine());

		System.out.println("Voulez-vous vraiment supprimer cette livre(y/n)?");
		String reponse = sc.nextLine();

		if (reponse.equals("y")) {
			boolean test = gLivre.deleteLivre(isbn);
			if (test) {
				System.out.println("Livre supprimer avec sucées");
			} else {
				System.out.println("Il y un probleme lors de sppruimer d'un livre:" + isbn);
			}
		} else {
			if (reponse.equals("n")) {

				System.out.println("OK");

			}
		}

	}

	private static void modifierAuteur(GererLivre gLivre, Scanner sc) {

		System.out.println("Veuillez de saisir un isbn de livre qui veut modifier :");
		int aISBN = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau auteur :");
		String auteur = sc.nextLine();

		boolean test = gLivre.updateAuteur(auteur, aISBN);
		if (test) {
			System.out.println("Livre modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un livre:" + aISBN);
		}

	}

	private static void modifierTheme(GererLivre gLivre, Scanner sc) {
		System.out.println("Veuillez de saisir un isbn de livre qui veut modifier :");
		int aISBN = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau theme :");
		String theme = sc.nextLine();

		boolean test = gLivre.updateTheme(theme, aISBN);
		if (test) {
			System.out.println("Livre modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un livre:" + aISBN);
		}

	}

	private static void modifierTitre(GererLivre gLivre, Scanner sc) {
		System.out.println("Veuillez de saisir un isbn de livre qui veut modifier :");
		int aISBN = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau titre :");
		String titre = sc.nextLine();

		boolean test = gLivre.updateTitre(titre, aISBN);
		if (test) {
			System.out.println("Livre modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un livre:" + aISBN);
		}

	}

	private static void modifierISBN(GererLivre gLivre, Scanner sc) {
		System.out.println("Veuillez de saisir un isbn de livre qui veut modifier :");
		int aISBN = Integer.parseInt(sc.nextLine());
		System.out.println("Veuillez de saisir nouveau isbn :");
		int n_isbn = Integer.parseInt(sc.nextLine());
		boolean test = gLivre.updateISBN(n_isbn, aISBN);
		if (test) {
			System.out.println("Livre modifier avec sucées");
		} else {
			System.out.println("Il y un probleme lors de modifier d'un livre:" + aISBN);
		}

	}

	private static void ajouterLivre(GererLivre gLivre, Scanner sc) {

		System.out.println("Veuillez saisir un isbn de livre :");
		int isbn = Integer.parseInt(sc.nextLine());

		System.out.println("Veuillez saisir un titre de livre :");
		String titre = sc.nextLine();

		System.out.println("Veuillez saisir un theme de livre :");
		String theme = sc.nextLine();

		System.out.println("Veuillez saisir un auteur de livre :");
		String auteur = sc.nextLine();

		Livre livre = new Livre(isbn, titre, theme, auteur);

		boolean test = gLivre.addLivre(livre);
		if (test) {
			System.out.println("Livre ajouter avec sucées");
		} else {
			System.out.println("Il y un probleme lors d'ajouter d'un livre:" + livre.getISBN());
		}

	}

	private static void menu() {
		System.out.println("Menu :");

		System.out.println("1-->Gerer Livre :");
		System.out.println("2--> Gerer Emprunt :");
		System.out.println("3--> exit :");

		while (saisirEntier(sc.nextLine())) {

			sousMenu();
		}

		menu();

	}

	private static void sousMenu() {

		if (val == 1) {

			menuGererLivre();

		} else {

			if (val == 2) {

				menuGererEmprunt();

			} else {
				if (val == 3) {
					exit();
				} else {
					System.out.println("SVP saisir 1 ou 2 ou 3 :");
					menu();
				}
			}

		}
	}

	private static void menuGererEmprunt() {
		System.out.println("1--> Ajouter un emprunt ");

		System.out.println("2--> Modifer date d'un emprunt ");
		System.out.println("3--> Modifer date de retour d'un emprunt ");

		System.out.println("4--> Modifer idExemplaire pour un emprunt ");

		System.out.println("5--> Modifer idEtudiant exemplaire ");
		System.out.println("6--> Supprimer exemplaire ");
		System.out.println("7--> exit ");

		while (!saisirEntier(sc.nextLine())) {
			menuGererEmprunt();
		}

		switch (val) {
		case 1:
			ajouterEmprunt();
			break;
		case 2:
			modifierDateEmp();
			break;
		case 3:
			modifierDateRet();
			break;
		case 4:
			modifieridExemplaire();
			break;
		case 5:
			modifierIDEtudiant();
			break;
		case 6:
			supprimerEmprunt();
			break;
		case 7:
			exit();
			break;
		default:
			System.out.println("SVP saisir 1 ou 2 ou 3 ou 4 ou 5 ou 6 ou 7:");
			menuGererEmprunt();
		}

	}

	private static void menuGererLivre() {

		System.out.println("1--> Ajouter un livre ");

		System.out.println("2-->  Modifer ISBN d'un livre ");
		System.out.println("3-->Modifer Titre d'un livre ");

		System.out.println("4-->Modifer Theme d'un livre ");

		System.out.println("5-->Modifer Auteur d'un livre");
		System.out.println("6-->Supprimer  d'un livre ");
		System.out.println("7-->exit :");

		int val2 = 0;

		/*
		 * if (saisirEntier(sc.nextLine())) { val2 = Integer.parseInt(sc.nextLine()); }
		 * else { menuGererLivre(); }
		 */

		while (!saisirEntier(sc.nextLine())) {
			menuGererEmprunt();
		}

		switch (val) {
		case 1:
			ajouterLivre(gLivre, sc);
			break;
		case 2:
			modifierISBN(gLivre, sc);
			break;
		case 3:
			modifierTitre(gLivre, sc);
			break;
		case 4:
			modifierTheme(gLivre, sc);
			break;
		case 5:
			modifierAuteur(gLivre, sc);
			break;
		case 6:
			supprimerLivre(gLivre, sc);
			break;
		case 7:
			exit();
			break;
		default:
			System.out.println("SVP saisir 1 ou 2 ou 3 ou 4 ou 5 ou 6 ou 7:");
			menuGererLivre();
		}

	}

	public static boolean saisirEntier(String entier) {
		try {
			val = Integer.parseInt(entier);

			return true;
		} catch (NumberFormatException e) {
			System.out.println("Cette valeur n'est pas un chiffre, essaie encore !");
		}
		return false;
	}

}