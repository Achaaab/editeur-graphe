/* Generated By:JavaCC: Do not edit this line. CompilateurFonction.java */
package com.github.achaaab.graphe.grammaire;

import java.util.ArrayList;
import java.util.List;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.fabrique.FabriqueFonction;

public class CompilateurFonction implements CompilateurFonctionConstants {

  final public Fonction compilerFonction() throws ParseException {
        Fonction fonction;
    fonction = fonctionAdditive();
    jj_consume_token(0);
          {if (true) return fonction;}
    throw new Error("Missing return statement in function");
  }

  final public Fonction fonctionAdditive() throws ParseException {
        Fonction sousFonction0;
        Fonction sousFonction1;
        Fonction fonctionAdditive;
    sousFonction0 = fonctionMultiplicative();
          fonctionAdditive = sousFonction0;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPERATEUR_ADDITION:
      case OPERATEUR_SOUSTRACTION:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPERATEUR_ADDITION:
        jj_consume_token(OPERATEUR_ADDITION);
        sousFonction1 = fonctionMultiplicative();
                          fonctionAdditive = FabriqueFonction.getInstance().creerAddition(fonctionAdditive, sousFonction1);
        break;
      case OPERATEUR_SOUSTRACTION:
        jj_consume_token(OPERATEUR_SOUSTRACTION);
        sousFonction1 = fonctionMultiplicative();
                          fonctionAdditive = FabriqueFonction.getInstance().creerSoustraction(fonctionAdditive, sousFonction1);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
          {if (true) return fonctionAdditive;}
    throw new Error("Missing return statement in function");
  }

  final public Fonction fonctionMultiplicative() throws ParseException {
        Fonction sousFonction0;
        Fonction sousFonction1;
        Fonction fonctionMultiplicative;
    sousFonction0 = fonctionUnaire();
          fonctionMultiplicative = sousFonction0;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPERATEUR_DIVISION:
      case OPERATEUR_MULTIPLICATION:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPERATEUR_MULTIPLICATION:
        jj_consume_token(OPERATEUR_MULTIPLICATION);
        sousFonction1 = fonctionUnaire();
                          fonctionMultiplicative = FabriqueFonction.getInstance().creerMultiplication(fonctionMultiplicative, sousFonction1);
        break;
      case OPERATEUR_DIVISION:
        jj_consume_token(OPERATEUR_DIVISION);
        sousFonction1 = fonctionUnaire();
                          fonctionMultiplicative = FabriqueFonction.getInstance().creerDivision(fonctionMultiplicative, sousFonction1);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
          {if (true) return fonctionMultiplicative;}
    throw new Error("Missing return statement in function");
  }

  final public Fonction fonctionUnaire() throws ParseException {
        Fonction sousFonction;
        Fonction fonctionUnaire;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERATEUR_SOUSTRACTION:
      jj_consume_token(OPERATEUR_SOUSTRACTION);
      sousFonction = fonctionUnaire();
                          fonctionUnaire = FabriqueFonction.getInstance().creerOpposition(sousFonction);
      break;
    case VARIABLE:
    case CONSTANTE_E:
    case CONSTANTE_PI:
    case NOM_FONCTION:
    case NOMBRE:
    case PARENTHESE_GAUCHE:
      fonctionUnaire = fonctionPrimaire();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return fonctionUnaire;}
    throw new Error("Missing return statement in function");
  }

  final public Fonction fonctionPrimaire() throws ParseException {
        Fonction fonctionPrimaire;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANTE_E:
    case CONSTANTE_PI:
    case NOMBRE:
      fonctionPrimaire = constante();
      break;
    case VARIABLE:
      fonctionPrimaire = identite();
      break;
    case NOM_FONCTION:
      fonctionPrimaire = fonctionNommee();
      break;
    case PARENTHESE_GAUCHE:
      jj_consume_token(PARENTHESE_GAUCHE);
      fonctionPrimaire = fonctionAdditive();
      jj_consume_token(PARENTHESE_DROITE);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return fonctionPrimaire;}
    throw new Error("Missing return statement in function");
  }

  final public Fonction constante() throws ParseException {
        Token tokenValeur;
        double valeur;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOMBRE:
      tokenValeur = jj_consume_token(NOMBRE);
                          valeur = Double.parseDouble(tokenValeur.image);
      break;
    case CONSTANTE_E:
      jj_consume_token(CONSTANTE_E);
                          valeur = Math.E;
      break;
    case CONSTANTE_PI:
      jj_consume_token(CONSTANTE_PI);
                          valeur = Math.PI;
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return FabriqueFonction.getInstance().creerConstante(valeur);}
    throw new Error("Missing return statement in function");
  }

  final public Fonction identite() throws ParseException {
        Token tokenVariable;
        Fonction identite;
    tokenVariable = jj_consume_token(VARIABLE);
          identite = FabriqueFonction.getInstance().creerIdentite(tokenVariable.image);
          {if (true) return identite;}
    throw new Error("Missing return statement in function");
  }

  final public Fonction fonctionNommee() throws ParseException {
        Token tokenNomFonction;
        String nomFonction;
        Fonction fonctionNommee;
        List<Fonction> sousFonctions;
        Fonction sousFonction;
    tokenNomFonction = jj_consume_token(NOM_FONCTION);
          nomFonction = tokenNomFonction.image;
    jj_consume_token(PARENTHESE_GAUCHE);
          sousFonctions = new ArrayList<Fonction>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERATEUR_SOUSTRACTION:
    case VARIABLE:
    case CONSTANTE_E:
    case CONSTANTE_PI:
    case NOM_FONCTION:
    case NOMBRE:
    case PARENTHESE_GAUCHE:
      sousFonction = fonctionAdditive();
          sousFonctions.add(sousFonction);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEPARATEUR_PARAMETRES:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_3;
        }
        jj_consume_token(SEPARATEUR_PARAMETRES);
        sousFonction = fonctionAdditive();
                  sousFonctions.add(sousFonction);
      }
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(PARENTHESE_DROITE);
          fonctionNommee = FabriqueFonction.getInstance().creerFonction(nomFonction, sousFonctions);
          {if (true) return fonctionNommee;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public CompilateurFonctionTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[9];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc0,0xc0,0x300,0x300,0x1bc80,0x1bc00,0x9800,0x40000,0x1bc80,};
   }

  /** Constructor with InputStream. */
  public CompilateurFonction(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CompilateurFonction(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CompilateurFonctionTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public CompilateurFonction(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CompilateurFonctionTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public CompilateurFonction(CompilateurFonctionTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CompilateurFonctionTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[19];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 19; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
