package com.example.login.objetos;

import java.util.ArrayList;

public class RepositorioCaso {

    private static ArrayList<Caso> casos = new ArrayList<Caso>();


    public static ArrayList<Caso> getCasos() {
        return casos;
    }

    public static void setCasos(ArrayList<Caso> c) {
        casos = c;
    }

}

