package com.oc.Model;


import javax.servlet.http.HttpServletRequest;

public class Operation {

  private int valeur1;
  private int valeur2;
  private String choixOperation;
  private String resultat;
  private String git;             // Ajouté deux attribues git & github !!
  private String gitHub;


  public String getResultat() {

    return resultat;
  }

  public int getValeur1() {
    return valeur1;

  }

  public void setValeur1(int valeur1) {

    this.valeur1 = valeur1;
  }

  public int getValeur2() {
    try {
      return valeur2;
    } catch (NumberFormatException ex) {
      return valeur2 = 0;
    }
  }

  public void setValeur2(int valeur2) {

    this.valeur2 = valeur2;
  }

  public String getChoixOperation() {
    return choixOperation;
  }

  public void setChoixOperation(String choixOperation) {
    this.choixOperation = choixOperation;
  }

  public void setResultat() {

    this.resultat = resultat;
  }

  public void calculette(HttpServletRequest request) {

    String v1 = request.getParameter("valeur1");  //v1: chaine de caractere récupéré
    if (v1.isEmpty()) {
      valeur1 = 0;
    } else {
      valeur1 = Integer.parseInt(v1);
    }
    String v2 = request.getParameter("valeur2");   //v2: chaine de caractere récupéré
    if (v2.isEmpty()) {
      valeur2 = 0;
    } else {
      valeur2 = Integer.parseInt(v2);
    }
    choixOperation = request.getParameter("choixOperation");

    switch (choixOperation) {
      case "+":
        resultat = String.valueOf((valeur1) + (valeur2));
        break;
      case "-":
        resultat = String.valueOf((valeur1) - (valeur2));
        break;
      case "*":
        resultat = String.valueOf((valeur1) * (valeur2));
        break;
      case "/":
        resultat = String.valueOf((valeur1) / (valeur2));
        break;
      default:
        resultat = "Veuillez recommencer est bien choisir une opération !";
    }

  }

}

